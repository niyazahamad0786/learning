package com.codematrix.flight.config;

import com.codematrix.flight.controllers.responses.FlightPriceRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;

public class FlightPriceRequestArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(FlightPriceRequest.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {

        FlightPriceRequest flightPriceRequest = new FlightPriceRequest();

        for (Field field : flightPriceRequest.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonProperty.class)) {
                JsonProperty annotation = field.getAnnotation(JsonProperty.class);
                String setter = findSetter(field.getName());
                setValues(flightPriceRequest, field, setter, annotation.value(), nativeWebRequest);
                continue;
            }
            String setter = findSetter(field.getName());
            setValues(flightPriceRequest, field, setter, field.getName(), nativeWebRequest);
        }
        return flightPriceRequest;
    }

    private void setValues(FlightPriceRequest flightPriceRequest, Field field, String setter, String parameterName, NativeWebRequest nativeWebRequest) throws Exception {
        Method method = flightPriceRequest.getClass().getMethod(setter, field.getType());
        Object value = parseValue(field.getType(), nativeWebRequest, parameterName);
        if (value != null) {
            method.invoke(flightPriceRequest, value);
        }
    }

    private Object parseValue(Class<?> type, NativeWebRequest nativeWebRequest, String parameter) {
        if (type.isAssignableFrom(LocalDate.class)) {
            return LocalDate.parse(parameter);
        }
        return nativeWebRequest.getParameter(parameter);
    }

    private String findSetter(String name) {
        return "set" + StringUtils.capitalize(name);
    }

}
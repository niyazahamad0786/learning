package com.codematrix.flight.config;

import com.codematrix.flight.dto.ScheduleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class FlightMetaSearchConfiguration {

    @Autowired
    private FlightMetaSearch flightMetaSearch;

    @Bean
    public AsyncTaskExecutor asyncTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setMaxPoolSize(flightMetaSearch.getMaxPoolSize());
        threadPoolTaskExecutor.setCorePoolSize(flightMetaSearch.getCorePoolSize());
        return threadPoolTaskExecutor;
    }

    @Bean
    public RedisTemplate<String, ScheduleDto> redisTemplate() {
        final RedisTemplate<String, ScheduleDto> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(ScheduleDto.class));
        redisTemplate.setConnectionFactory(new JedisConnectionFactory());
        return redisTemplate;
    }

}

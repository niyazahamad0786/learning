package com.codematrix.learning.problems.core;

import org.springframework.context.i18n.LocaleContext;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class NumberFormatterDemo {
    public static void main(String[] args) {
        double payment = 12324.134;

        // Write your code here.
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        formatter.setMaximumFractionDigits(2);

        String us = formatter.format(payment);

//        formatter.setCurrency(Currency.getInstance(new Locale("en", "IN")));
        formatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        String india = formatter.format(payment);

//        formatter.setCurrency(Currency.getInstance(Locale.CHINA));
        formatter = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String china = formatter.format(payment);

//        formatter.setCurrency(Currency.getInstance(Locale.FRANCE));
        formatter = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = formatter.format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);

    }
}

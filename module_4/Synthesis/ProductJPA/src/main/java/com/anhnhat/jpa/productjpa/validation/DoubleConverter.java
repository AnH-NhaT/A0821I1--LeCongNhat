package com.anhnhat.jpa.productjpa.validation;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DoubleConverter implements Converter<String, Double> {

    @Override
    public Double convert(String source) {
        try {
            return Double.valueOf(source);
        } catch (Exception e) {
            return -1.0;
        }
    }
}
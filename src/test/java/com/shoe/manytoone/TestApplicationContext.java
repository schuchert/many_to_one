package com.shoe.manytoone;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class TestApplicationContext {
    private static final ConfigurableApplicationContext context = SpringApplication.run(Main.class);

    public static <T> T getBean(Class<T> clazz) throws BeansException {
        return context.getBean(clazz);
    }
}

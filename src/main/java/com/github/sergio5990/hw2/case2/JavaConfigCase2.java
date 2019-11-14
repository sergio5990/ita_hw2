package com.github.sergio5990.hw2.case2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigCase2 {

    @Bean
    public ServiceCase2 serviceCase2() {
        return new ServiceCase2();
    }
}

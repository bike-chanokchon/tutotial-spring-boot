package com.luv2code.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.SwinCoach;

@Configuration
public class SportConfig {
    @Bean("aquatic") // สามารถ custom bean id ได้
    public Coach swimCoach() {
        return new SwinCoach();
    }
}

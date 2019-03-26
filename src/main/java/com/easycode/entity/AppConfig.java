package com.easycode.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class AppConfig {

    @Bean
    public SpringEntity springEntity(){

        return new SpringEntity();
    }

    @Bean
    public SpringEntity initedEntity(){

        return springEntity();
    }

}

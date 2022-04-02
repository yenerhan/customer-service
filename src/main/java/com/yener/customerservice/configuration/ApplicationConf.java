package com.yener.customerservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConf {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

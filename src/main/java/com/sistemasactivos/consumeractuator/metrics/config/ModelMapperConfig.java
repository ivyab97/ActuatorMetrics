package com.sistemasactivos.consumeractuator.metrics.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Ivan Andres Brestt
 */
@Configuration
public class ModelMapperConfig {

    private static final ModelMapper modelMapper = createModelMapper();

    private static ModelMapper createModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    @Bean
    public static ModelMapper modelMapper() {
        return modelMapper;
    }
}

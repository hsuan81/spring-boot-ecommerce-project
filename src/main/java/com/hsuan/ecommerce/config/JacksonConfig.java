package com.hsuan.ecommerce.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hsuan.ecommerce.common.MaskingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        // Register the MaskingFilter with the ObjectMapper
        SimpleFilterProvider filterProvider = new SimpleFilterProvider();
        // Add support for Java 8 date/time types
        mapper.registerModule(new JavaTimeModule());

        // Ensure dates are serialized as ISO-8601 strings
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        filterProvider.addFilter("maskingFilter", new MaskingFilter());
        mapper.setFilterProvider(filterProvider);

        return mapper;
    }
}

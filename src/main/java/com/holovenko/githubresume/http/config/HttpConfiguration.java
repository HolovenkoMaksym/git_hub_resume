package com.holovenko.githubresume.http.config;

import com.holovenko.githubresume.http.validator.ResponseEntityBodyValidator;
import com.holovenko.githubresume.http.validator.ResponseEntityCodeValidator;
import com.holovenko.githubresume.http.validator.ResponseEntityValidator;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpConfiguration {

    @Bean
    public ResponseEntityValidator composeValidators() {
        final ResponseEntityValidator validator = new ResponseEntityCodeValidator();
        validator.setNext(new ResponseEntityBodyValidator());

        return validator;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}

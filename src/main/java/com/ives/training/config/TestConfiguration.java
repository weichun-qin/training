package com.ives.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @DESCRIPTION:
 * @AUTHOR: ives
 * @DATE: 2020/12/31 13:30
 */
@Configuration
public class TestConfiguration {
    @Bean
    public RestTemplate getRestTemplate() {
/*    SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
    requestFactory.setConnectTimeout(5000);
    requestFactory.setReadTimeout(3000);*/
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}

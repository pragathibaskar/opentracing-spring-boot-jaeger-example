package com.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages="com.hello.*")
public class HelloApplication implements WebMvcConfigurer {

	 @Bean
	    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
	        return restTemplateBuilder.build();
	    }
	    
    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }
}

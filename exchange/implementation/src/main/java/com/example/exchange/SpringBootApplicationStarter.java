package com.example.exchange;

import com.example.exchange.configuration.ExchangeSpringConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootApplicationStarter {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ExchangeSpringConfiguration.class, args);
    }
}
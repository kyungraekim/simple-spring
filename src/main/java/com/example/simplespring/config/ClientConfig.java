package com.example.simplespring.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ClientConfig {
    @Value("${store.host}")
    private String host;

    @Value("${store.port}")
    private int port;
}

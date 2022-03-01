package com.edu.nju.clockcourier.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("db")
public class DatabaseConfig {

    @Value("page-size")
    private String pageSize;

}

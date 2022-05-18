package com.edu.nju.clockcourier.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("display")
public class DisplayConfig {

    @Value("page-size")
    private String pageSize;

    public Integer pageAll(Integer all) {
        int size = Integer.parseInt(this.pageSize);
        return all / size + ((all % size == 0) ? 0 : 1);
    }

}

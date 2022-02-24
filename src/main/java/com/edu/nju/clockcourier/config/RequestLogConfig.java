package com.edu.nju.clockcourier.config;

import com.edu.nju.clockcourier.util.RequestLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class RequestLogConfig {

    @Bean
    public RequestLogger requestLogger() {
        return new RequestLogger();
    }

}

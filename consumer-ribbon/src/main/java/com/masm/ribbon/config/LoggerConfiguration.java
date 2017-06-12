package com.masm.ribbon.config;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfiguration {

    /**
     * @Description: 设置feign日志级别
     * NONE, no logging(default)
     * BASIC, log only the request method and url and the response status code and execution time.
     * HEADERS, log the basic information along with request and response headers.
     * FULL, log the headers,body,and metadata for both request and responses
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("root", "123456");
    }
}

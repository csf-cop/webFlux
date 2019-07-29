package com.csf.whoami;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.csf.whoami.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class WhoamiSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhoamiSecurityApplication.class, args);
    }
}
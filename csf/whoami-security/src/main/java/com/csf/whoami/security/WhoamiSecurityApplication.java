package com.csf.whoami.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.csf.whoami.security.social.AppProperties;

// this is to disable default login page from spring security
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
// Setting social login.
@EnableConfigurationProperties(AppProperties.class)
public class WhoamiSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhoamiSecurityApplication.class, args);
    }
}

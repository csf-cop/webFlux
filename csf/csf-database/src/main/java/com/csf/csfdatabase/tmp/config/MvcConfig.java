package com.csf.csfdatabase.tmp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry registry){
    registry.addMapping("/**").allowedMethods("GET", "POST", "PUT");
  }
}

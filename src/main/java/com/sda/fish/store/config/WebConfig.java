package com.sda.fish.store.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");

        registry.addResourceHandler("/imagines/**").addResourceLocations("classpath:/static/imagines/");

        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
    }
}

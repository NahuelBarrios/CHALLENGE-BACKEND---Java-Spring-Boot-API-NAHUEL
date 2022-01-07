package com.example.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfiguracionWeb implements WebMvcConfigurer{
    
    @Override
    public void addViewControllers(ViewControllerRegistry registro)
    {
        registro.addViewController("/").setViewName("index");
        registro.addViewController("/login");
        registro.addViewController("/registronuevo");
    }
    
}

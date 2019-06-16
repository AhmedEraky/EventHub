package org.eventhub.web.config;

import org.eventhub.facade.config.AppConfig;
import org.eventhub.web.convertor.OrganizationConverter;
import org.eventhub.web.convertor.CountryConverter;
import org.eventhub.web.convertor.EventConverter;
import org.springframework.context.annotation.*;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableWebSecurity
@ComponentScan("org.eventhub.web")
@Import(AppConfig.class)
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new CountryConverter());
        registry.addConverter(new EventConverter());
        registry.addConverter(new OrganizationConverter());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
}

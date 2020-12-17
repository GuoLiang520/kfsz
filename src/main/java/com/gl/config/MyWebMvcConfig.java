package com.gl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * 
 * @author 郭亮
 * @date 2020/9/27 16:04 
 **/
@Configuration
public class MyWebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/mystatic/**").addResourceLocations("classpath:/mystatic/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /*@Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MyHttpMessageConverter());
    }*/

    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MyHttpMessageConverter());
    }

    @Override
    protected void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new MyFormatter());
        //registry.addFormatterForFieldAnnotation(new MyAnnotationFormatterFactory());
    }



    @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(new MyViewResolver());
    }

}
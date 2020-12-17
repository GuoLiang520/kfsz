package com.gl.config;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * 
 * @author 郭亮
 * @date 2020/11/8 15:02 
 **/
public class MyViewResolver implements ViewResolver {
    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        System.out.println(viewName);
        return new MyXslView();
    }
}

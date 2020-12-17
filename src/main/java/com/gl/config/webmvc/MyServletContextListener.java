package com.gl.config.webmvc;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

/**
 * 
 * @author 郭亮
 * @date 2020/10/27 17:33 
 **/
@WebListener
public class MyServletContextListener implements javax.servlet.ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce){
        System.out.println("MyServletContextListener");
    }
}

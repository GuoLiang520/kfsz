package com.gl.config.webmvc;

import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebListener;

/**
 * 
 * @author 郭亮
 * @date 2020/10/27 17:33 
 **/
@WebListener
public class MyServletRequestListener implements javax.servlet.ServletRequestListener {

    @Override
    public void requestInitialized (ServletRequestEvent sre) {
        System.out.println("MyServletRequestListener");
    }
}

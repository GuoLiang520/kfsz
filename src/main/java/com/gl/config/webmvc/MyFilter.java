package com.gl.config.webmvc;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 
 * @author 郭亮
 * @date 2020/10/27 15:41 
 **/
@WebFilter
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter before");
        chain.doFilter(request, response);
        System.out.println("MyFilter after");
    }
}

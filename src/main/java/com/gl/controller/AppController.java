package com.gl.controller;

import com.gl.utils.SpringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author 郭亮
 * @date 2020/10/16 11:48 
 **/
@Controller
@RequestMapping(value = "/app")
public class AppController {

    @RequestMapping(value = "/getRealPath")
    @ResponseBody
    public String getRealPath(HttpServletRequest request) {
        request.getSession();
        SpringUtils.getBean("kfszDataSourceProperties");
        SpringUtils.getBean("kfszDataSourceProperties");
        return request.getServletContext().getRealPath("/");
    }
}

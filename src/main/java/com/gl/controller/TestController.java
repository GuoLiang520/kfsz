package com.gl.controller;

import com.gl.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author 郭亮
 * @date 2020/9/23 9:59 
 **/
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test.do")
    @ResponseBody
    public Object test(String ahdm){
        return testService.getEaj(ahdm);
    }

    @RequestMapping(value = "/save.do")
    @ResponseBody
    public Object save(){
        testService.insertEaj();
        return "success";
    }

    @RequestMapping(value = "/getByNd.do")
    @ResponseBody
    public Object getByNd(){
        testService.getByNd();
        return "success";
    }

    @RequestMapping(value = "/saveJpa.do")
    @ResponseBody
    public Object saveJpa(){
        testService.saveJpa();
        return "success";
    }

    @RequestMapping(value = "/getJpa.do")
    @ResponseBody
    public Object getJpa(String ahdm){
        return testService.getJpa(ahdm);
    }
}
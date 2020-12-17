package com.gl.controller;

import com.gl.entity.Eaj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


/**
 * 
 * @author 郭亮
 * @date 2020/9/27 15:45 
 **/
@Controller
public class IndexController {

    /**
     * 指数
     *
     * @return {@link ModelAndView}
     */
    @RequestMapping(value = "index.do")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("name", "kfsz");
        return mav;
    }

    /**
     * 我的http消息转换器
     *
     * @param eaj eaj
     * @return {@link Object}
     */
    @RequestMapping(value = "myHttpMessageConverter.do", consumes = "application/gl;charset=UTF-8", produces = "application/json")
    @ResponseBody
    public Object myHttpMessageConverter(@RequestBody Eaj eaj) {
        return eaj;
    }

    /**
     * 我格式化程序
     *
     * @param eaj eaj
     * @return {@link Object}
     */
    @RequestMapping(value = "myFormatter.do", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object myFormatter(@Valid Eaj eaj) {
        //eaj.setDate(new Date());
        return eaj;
    }
}

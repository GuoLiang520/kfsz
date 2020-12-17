package com.gl.controller;

import com.gl.config.MyXslView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author 郭亮
 * @date 2020/11/8 15:20 
 **/
@Controller
@RequestMapping(value = "excel")
public class ExcelController {

    @RequestMapping("/exportExcel")
    public ModelAndView exportExcel(){
        ModelAndView mav = new ModelAndView();
        mav.setView(new MyXslView());
        mav.addObject("row", 10);
        mav.addObject("col", 12);
        return mav;
    }
}

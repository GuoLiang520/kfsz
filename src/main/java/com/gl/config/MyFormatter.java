package com.gl.config;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author 郭亮
 * @date 2020/9/27 16:48
 **/
public class MyFormatter implements Formatter<String> {
    @Override
    public String parse(String text, Locale locale) throws ParseException {
        //System.out.println(text);
        return text;
    }

    @Override
    public String print(String object, Locale locale) {
        System.out.println(object);
        return object;
    }
}

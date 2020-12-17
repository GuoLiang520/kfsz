package com.gl.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;

/**
 * 
 * @author 郭亮
 * @date 2020/9/27 16:17 
 **/
public class MyHttpMessageConverter extends AbstractHttpMessageConverter<Serializable> {

    public MyHttpMessageConverter() {
        super(new MediaType("application", "gl", Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return true;
    }

    @Override
    protected Serializable readInternal(Class<? extends Serializable> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream body = httpInputMessage.getBody();
        byte[] buffer = new byte[10240];
        body.read(buffer);
        String s = new String(buffer);
        return JSONObject.parseObject(s, aClass);
    }

    @Override
    protected void writeInternal(Serializable serializable, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        httpOutputMessage.getBody().write(JSON.toJSONString(serializable).getBytes());
    }
}

package com.gl.config;


import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author 郭亮
 * @date 2020/10/14 17:31 
 **/
@Configuration
//@Endpoint(id = "myEndpoint")
public class MyEndpoint {

    /**
     * @return
     */
    //@ReadOperation
    public Map<String, Object> endpoint() {
        Map<String, Object> map = new HashMap<>(16);
        map.put("message", "this is my endpoint");
        return map;
    }
}

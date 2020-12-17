package com.gl.config;

import lombok.Data;

/**
 * 
 * @author 郭亮
 * @date 2020/10/10 9:51 
 **/
@Data
//@Component
//@PropertySource(value = "classpath:redis.properties")
//@ConfigurationProperties(prefix = "kfsz.redis")
public class RedisProperties {

    private String host;

    private Integer port;

    private String password;
}

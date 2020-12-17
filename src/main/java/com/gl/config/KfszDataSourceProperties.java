package com.gl.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 
 * @author 郭亮
 * @date 2020/9/23 9:00 
 **/
@Component
@PropertySource(value = "classpath:jdbc.properties")
@ConfigurationProperties(prefix = "kfsz")
@Data
public class KfszDataSourceProperties {
    private String driverClassName;

    private String url;

    private String username;

    private String password;
}

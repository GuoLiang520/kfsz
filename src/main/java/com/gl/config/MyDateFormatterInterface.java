package com.gl.config;

import java.lang.annotation.*;

/**
 * 
 * @author 郭亮
 * @date 2020/9/27 17:08 
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
public @interface MyDateFormatterInterface {

    String value() default "";

    String pattern() default "";
}

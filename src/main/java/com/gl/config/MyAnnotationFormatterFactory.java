package com.gl.config;

import org.springframework.context.support.EmbeddedValueResolutionSupport;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Formatter;
import org.springframework.format.Parser;
import org.springframework.format.Printer;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author 郭亮
 * @date 2020/9/27 17:08 
 **/
public class MyAnnotationFormatterFactory extends EmbeddedValueResolutionSupport
        implements AnnotationFormatterFactory<MyDateFormatterInterface> {
    @Override
    public Set<Class<?>> getFieldTypes() {
        HashSet<Class<?>> objects = new HashSet<>();
        objects.add(Date.class);
        return objects;
    }

    @Override
    public Printer<?> getPrinter(MyDateFormatterInterface annotation, Class<?> fieldType) {
        return getFormatter(annotation, fieldType);
    }

    @Override
    public Parser<?> getParser(MyDateFormatterInterface annotation, Class<?> fieldType) {
        return getFormatter(annotation, fieldType);
    }

    protected Formatter<Date> getFormatter(MyDateFormatterInterface annotation, Class<?> fieldType) {
        DateFormatter formatter = new DateFormatter();
        String pattern = resolveEmbeddedValue(annotation.pattern());
        if (StringUtils.hasLength(pattern)) {
            formatter.setPattern(pattern);
        }
        return formatter;
    }
}

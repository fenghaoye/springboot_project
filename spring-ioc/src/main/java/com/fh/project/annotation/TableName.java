package com.fh.project.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TableName {

    public String value() default "";
}

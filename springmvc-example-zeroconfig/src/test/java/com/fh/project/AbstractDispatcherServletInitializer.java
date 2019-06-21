package com.fh.project;

import org.springframework.util.ObjectUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class AbstractDispatcherServletInitializer extends AbstractContextLoaderInitializer {

    public void onStartup() {
        super.onStartup();
        this.createServletApplicationContext();
        System.out.println("AbstractDispatcherServletInitializer 中onStartup方法被调用");
    }

    /*protected void createServletApplicationContext() {
        System.out.println("AbstractDispatcherServletInitializer createServletApplicationContext");
    }*/
}

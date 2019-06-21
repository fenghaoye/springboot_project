package com.fh.project.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/*
    实现WebApplicationInitializer
    最钟会被容器调用onStartUp方法
 */
public class MyInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("初始化MyInitializer接口");
        // 1、创建spring容器
        AnnotationConfigWebApplicationContext webApplicationContext =
                new AnnotationConfigWebApplicationContext();
        // 2、在spring容器中加载springmvc配置类
        webApplicationContext.register(SpringMVCConfig.class);
        // 3、将spring容器放置在servlet容器中加载
        webApplicationContext.setServletContext(servletContext);

        // 4、设置springmvc核心的控制器Dispatcher
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
        ServletRegistration.Dynamic springmvc = servletContext.addServlet("springmvc", dispatcherServlet);
        springmvc.addMapping("/");
        springmvc.setLoadOnStartup(1);

    }
}

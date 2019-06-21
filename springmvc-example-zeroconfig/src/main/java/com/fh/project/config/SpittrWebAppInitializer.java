package com.fh.project.config;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/*
 初始化servlet 上下文中的 DispatcherServlet 和 Spring 其他上下文的配置初始化
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Nullable
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Nullable
    @Override
    protected Class<?>[] getServletConfigClasses() {
        // 获取配置类，并根据这个配置类加载spring容器
        System.out.println("调用SpittrWebAppInitializer初始化接口");
        return new Class<?>[] {SpringMVCConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}

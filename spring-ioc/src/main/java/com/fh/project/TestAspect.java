package com.fh.project;

import com.fh.project.config.AppConfig;
import com.fh.project.service.TestAopService;
import com.fh.project.service.TestAopServiceImpl;
import com.fh.project.service.TestServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAspect {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        TestAopService bean = configApplicationContext.getBean(TestAopService.class);
        bean.hello();
    }

}

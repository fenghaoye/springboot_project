package com.fh.project;

import com.fh.project.config.AppConfig;
import com.fh.project.entity.CatEntity;
import com.fh.project.util.CommonUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnnotation {

    public static void main(String[] args) {

        String sql = CommonUtil.buildQuerySql(new CatEntity());
        System.out.println(sql);


    }

}

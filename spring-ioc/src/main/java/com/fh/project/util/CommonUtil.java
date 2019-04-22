package com.fh.project.util;

import com.fh.project.annotation.TableName;

public class CommonUtil {

    public  static  String buildQuerySql(Object object){
        String sql = "select * from ";
        Class clazz = object.getClass();
        if(!clazz.isAnnotationPresent(TableName.class)){
            return "";
        }else {
            TableName declaredAnnotation = (TableName) clazz.getDeclaredAnnotation(TableName.class);
            String value = declaredAnnotation.value();
            sql = sql + value;
        }

        return sql;
    }
}

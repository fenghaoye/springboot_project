package com.fh.project.Test;

import com.fh.project.basic.staticDemo.SubClass;
import com.fh.project.basic.staticDemo.SuperClass;

public class NotInitialization {

    public static void main(String[] args) {
        //System.out.println(SubClass.value);
        SuperClass[] superClasses = new SuperClass[10];
    }
}

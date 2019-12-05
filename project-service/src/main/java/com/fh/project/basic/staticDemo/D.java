package com.fh.project.basic.staticDemo;

public class D extends C {

    static {
        System.out.println("D static block");
    }

    // 如果C没有默认的空构造方法会报错,除非使用super("a")调用父类的带参构造方法
    public D() {
        //super("str");
        System.out.println("D Constrcutor");
    }

    public static void main(String[] args) {

        new D();
        new D();
    }

}

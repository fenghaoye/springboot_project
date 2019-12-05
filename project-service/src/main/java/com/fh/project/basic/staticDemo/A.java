package com.fh.project.basic.staticDemo;

public class A {

    // 静态资源的假装顺序是严格按照静态资源的定义顺序来假装的
    private static int a = b();

    // 静态属性被赋值了一个新建的对象，也是在jvm启动的时候初始化该对象的
    private static B b = new B();

    // 静态代码块，main方法启动或者jvm启动的时候执行
    static {
        System.out.println("A static block");
        c();
    }

    // 静态方法被调用的时候才会被加载的
    public static int b() {
        System.out.println("A.b method");
        return 1;
    }

    // 静态方法未被调用，不会执行
    public static int c() {
        System.out.println("A.c method");
        // 静态方法对于定义在它之后的静态变量，还没被赋值，所以此时d的等于0
        System.out.println(d);
        // 此时d赋值成功，打印为6
        A.d=6;
        System.out.println(d);
        return 1;
    }

    private static int d = 5;


    public static void main(String[] args) {
        System.out.println(a);
        // 在c方法中定义了d=6,然后d又在静态变量中被重新赋值为5
        System.out.println(d);
    }

}

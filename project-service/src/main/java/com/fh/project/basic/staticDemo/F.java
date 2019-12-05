package com.fh.project.basic.staticDemo;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.util.SerializationUtils.serialize;

public class F {

    static {
        System.out.println("F static block");
        c();
    }

    public static int c() {
        System.out.println("F.c method");
        // 静态方法对于定义在它之后的静态变量，还没被赋值，所以此时d的等于0
        System.out.println(d);
        // 此时d赋值成功，打印为6
        F.d = 6;
        System.out.println(d);
        return 1;
    }

    // 再次赋值
    private static int d = 5;

    static byte[] bomb() {
        Set<Object> root = new HashSet<>();
        Set<Object> s1 = root;
        Set<Object> s2 = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            Set<Object> t1 = new HashSet<>();
            Set<Object> t2 = new HashSet<>();
            t1.add("foo");
            s1.add(t1);
            s1.add(t2);
            s2.add(t1);
            s2.add(t2);
            s1 = t1;
            s2 = t2;
        }
        return serialize(root);
    }

    public static void main(String[] args) {
        // 在c方法中定义了d=6,然后d又在静态变量中被重新赋值为5
        System.out.println(d);
    }

}

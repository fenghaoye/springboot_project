package com.fh.project.basic.staticDemo;

public class E {

    static {
        c = 3;
        // 引用的时候编译报错
        //System.out.println(c);
    }

    private static int c;

    public static void main(String[] args) {

    }

}

package com.fh.project.basic.staticDemo;

public class C {

    static {
        System.out.println("C static block");
    }

    public C() {
        System.out.println("C default Constrcutor");
    }

    public C(String str) {
        System.out.println("C Constrcutor");
    }

}

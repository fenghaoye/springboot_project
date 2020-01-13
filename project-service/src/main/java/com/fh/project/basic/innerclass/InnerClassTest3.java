package com.fh.project.basic.innerclass;

public class InnerClassTest3 {

    int field1 = 1;
    private int field2 = 2;

    public InnerClassTest3() {
        InnerClassA inner = new InnerClassA();
        int v = inner.x2;
    }

    public class InnerClassA {
        int x1 = field1;
        private int x2 = field2;
    }

}

package com.fh.project.designMode.principles.lod;

public class TestLOD {

    public static void main(String[] args) {
        /*
                基于接口而非实现编程
                基于最小接口而非最大实现编程
         */
        Serialization serialization = new Serialization();
        Demo1 demo1 = new Demo1(serialization);
        demo1.test();
    }
}

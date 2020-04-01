package com.fh.project.designMode.principles.lod;

public class Demo1 {

    // 迪米特法则，依赖有限接口
    private Serializable serializable;

    public Demo1(Serializable serializable){
        this.serializable = serializable;
    }

    public void test(){
        serializable.serialize(new Object());
    }


}

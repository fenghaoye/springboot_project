package com.fh.project.designMode.principles.lod;

public class Serialization implements Serializable ,DeSerializable{

    @Override
    public Object deSerialize(String s) {
        System.out.println("deSerialize");
        return null;
    }

    @Override
    public String serialize(Object object) {
        System.out.println("serialize");
        return null;
    }
}

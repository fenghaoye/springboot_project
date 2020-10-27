package com.fh.project.jvm.study10;

import java.util.ArrayList;
import java.util.List;

public class Foo {

    public static void main(String[] args) {
        Foo foo = new Foo();

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        String[] strings = list.toArray(new String[list.size()]);
        System.out.println(strings.toString());
    }
}

package com.fh.project.basic.comparable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestInteger {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(10);
        TestInteger.print(list);
        Collections.sort(list);
        TestInteger.print(list);
    }

    public static void print(List<Integer> list){
        for(Integer i : list){
            System.out.println(i);
        }
    }

}

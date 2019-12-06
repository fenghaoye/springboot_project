package com.fh.project.basic.Generic;

import com.fh.project.basic.staticDemo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Generic1 {


    void create(Supplier<? extends A> tileFactory) {
        System.out.println("xxx");

    }

    public static void main(String[] args) {
        ArrayList<Object> arrayList1=new ArrayList<Object>();
        arrayList1.add(new Object());
        arrayList1.add(new Object());
        ArrayList<String> arrayList2= new ArrayList<>();//编译错误
        arrayList1.addAll(arrayList2);
        //arrayList2.addAll(arrayList1); //编译错误

        // Mosaic create(Supplier<? extends Tile> tileFactory) { ... }
        Generic1 generic1 = new Generic1();
        generic1.create(new A());

        Boolean aTrue = Boolean.valueOf("true");
        aTrue = false;

    }
}

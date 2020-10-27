package com.fh.project.basic.reference;

public class ReferenceTest2 {

    public void setInteger(Integer num) {
        num = 2;
        System.out.println("方法中Integer的值：" + num);
    }

    public void setStr(String str) {
        str = "str2";
        System.out.println("方法中str的值：" + str);
    }

    public static void main(String[] args) {
        Integer num = 1;
        ReferenceTest2 test = new ReferenceTest2();
        test.setInteger(num);
        System.out.println("main方法中Integer的值：" + num);

        String str = "str1";
        test.setStr(str);
        System.out.println("方法中str的值：" + str);


    }
}

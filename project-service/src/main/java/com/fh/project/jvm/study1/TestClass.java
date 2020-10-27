package com.fh.project.jvm.study1;

/**
 * @Description
 * @Author fenghao
 * @Email 849260688@qq.com
 * @Date 2020/10/26 10:31 下午
 */
public class TestClass {

    private static final int num = 0;

    public int add(int num1,int num2){
        return num1+num2;
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.add(1,2);
    }
}

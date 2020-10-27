package com.fh.project.Test;

/**
 * @Description
 * @Author fenghao
 * @Email 849260688@qq.com
 * @Date 2020/10/25 7:45 上午
 */
public class TestJIT {

    public static final int NUM = 15000;

    public static int doubleValue(int i) {
        for (int j = 0; j < 100000; j++) {

        }
        return i * 2;
    }

    public static long scalaSum() {
        long sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += doubleValue(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            scalaSum();
        }
    }
}

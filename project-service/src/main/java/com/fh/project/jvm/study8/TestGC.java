package com.fh.project.jvm.study8;

public class TestGC {
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];

            placeholder = null;
        }
        System.gc();
    }
}

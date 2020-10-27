package com.fh.project.basic.exception;

public class JavaVMStackSOF {

    public void stackLeak() {
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.fh.project;

public class Test {

    public static void main(String[] args) {

        // 用接口去接收该实体类，会向上转型
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.onStartup();
    }
}

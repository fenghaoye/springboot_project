package com.fh.project;

public class SubDispatcherServlet extends DispatcherServlet {

    /*protected void createServletApplicationContext() {
        System.out.println("DispatcherServlet createServletApplicationContext");
    }*/

    public void onStartup() {

        System.out.println("SubDispatcherServlet 中onStartup方法被调用");
    }
}

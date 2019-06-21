package com.fh.project;

public class DispatcherServlet extends AbstractDispatcherServletInitializer {

    protected void createServletApplicationContext() {
        System.out.println("DispatcherServlet createServletApplicationContext");
    }
}

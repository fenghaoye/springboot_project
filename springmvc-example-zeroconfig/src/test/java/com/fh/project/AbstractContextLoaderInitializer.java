package com.fh.project;

public abstract class AbstractContextLoaderInitializer implements WebApplicationInitializer{

    public void onStartup() {
        System.out.println("AbstractContextLoaderInitializer 中onStartup");
    }

    protected void createServletApplicationContext() {
        System.out.println("AbstractContextLoaderInitializer createServletApplicationContext");
    }

}

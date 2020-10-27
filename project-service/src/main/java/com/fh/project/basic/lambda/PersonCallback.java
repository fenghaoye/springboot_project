package com.fh.project.basic.lambda;

public interface PersonCallback {

    void callback();
    void callback2();
    void callback3();


    default void callback4(){
        System.out.println("xxx");
    }
}

package com.fh.project.basic.Generic;

public class Generic<T> {

    private T t;


    public Generic(){
    }

    public Generic(T t){
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }


    public static void main(String[] args) {
        Generic<String> stringGeneric1 = new Generic("sss");
        Generic stringGeneric2 = new Generic<>("sss");
        Generic<String> stringGeneric3 = new Generic<>("sss");
        Generic<String> stringGeneric4 = new Generic<>("sss");
        Generic stringGeneric5 = new Generic();
        System.out.println(stringGeneric1.getT());
        System.out.println(stringGeneric2.getT());
        System.out.println(stringGeneric3.getT());
        System.out.println(stringGeneric4.getT());

    }
}

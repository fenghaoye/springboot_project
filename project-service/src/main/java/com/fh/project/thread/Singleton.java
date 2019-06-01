package com.fh.project.thread;

public class Singleton {

    // 私有构造方法，保证不能被外部创建
    private Singleton(){}

    // 项目启动就加载
    private static Singleton singleton = new Singleton();

    // 提供静态方法，让外部获取实例
    public static Singleton getInstance(){
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
    }
}

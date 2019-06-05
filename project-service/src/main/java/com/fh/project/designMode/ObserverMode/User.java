package com.fh.project.designMode.ObserverMode;

// 观察者
public class User implements Observer {

    private String name;

    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    // 被观察者发布消息时，通知所有的观察者，并调用观察者的更新方法
    public void update(String message) {
        this.message = message;
        read();

    }

    public void read(){
        System.out.println(name+"用户读取订阅消息："+message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

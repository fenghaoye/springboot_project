package com.fh.project.designMode.ObserverMode;

// 被观察者
public interface Observerable {

    // 注册观察者
    public void register(Observer observer);

    // 移除观察者
    public void remove(Observer observer);

    // 发送订阅消息给观察者
    void notifyObserver();
}

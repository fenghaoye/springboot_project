package com.fh.project.designMode.ObserverMode;

import java.util.ArrayList;
import java.util.List;

// 被观察者发布订阅消息给观察者
public class SubscriptionChannel implements  Observerable{

    private List<Observer> observerList = new ArrayList<>();

    private String message;

    @Override
    public void register(Observer observer) {
        System.out.println("添加订阅用户");
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        System.out.println("移除订阅用户");
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update(message);
        }
    }

    public void sendMessage(String message) {
        this.message = message;
        System.out.println("专栏作者更新专栏文章......");
        // 调用通知所有订阅者
        notifyObserver();
    }

    public List<Observer> getObserverList() {
        return observerList;
    }

    public void setObserverList(List<Observer> observerList) {
        this.observerList = observerList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

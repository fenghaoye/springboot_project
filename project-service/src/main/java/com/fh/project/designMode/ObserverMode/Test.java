package com.fh.project.designMode.ObserverMode;

public class Test {

    public static void main(String[] args) {
        // 创建用户，观察者
        User user1 = new User("张三");
        User user2 = new User("李四");
        User user3 = new User("王五");

        // 创建被观察者，消息
        SubscriptionChannel subscription = new SubscriptionChannel();

        // 用户订阅消息
        new Thread(() -> {
            try {
                subscription.register(user1);
                Thread.sleep(10000);
                subscription.register(user2);
                Thread.sleep(10000);
                subscription.register(user3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        // 服务发布订阅消息
        new Thread(() -> {
            try {
                int i = 1;
                while (true) {
                    subscription.sendMessage("设计模式" + i + "已经发布");
                    Thread.sleep(5000);
                    i++;
                    if (i > 5) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();

        // 新的用户订阅消息，或者取消订阅
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                subscription.register(new User("赵六"));
                Thread.sleep(3000);
                subscription.remove(user1);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();
    }
}

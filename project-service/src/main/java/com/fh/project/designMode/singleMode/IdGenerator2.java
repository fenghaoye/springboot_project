package com.fh.project.designMode.singleMode;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description 单例模式，懒汉式
 * @Author fenghao
 * @Email 849260688@qq.com
 * @Date 2020/4/6 11:01 上午
 */
public class IdGenerator2 {

    private AtomicLong id = new AtomicLong();
    private static IdGenerator2 instance;

    private IdGenerator2() {
    }

    public static synchronized IdGenerator2 getInstance() {
        if (instance == null) {
            instance = new IdGenerator2();
        }
        return instance;
    }

    public long getId() {
        return getInstance().id.incrementAndGet();
    }

}

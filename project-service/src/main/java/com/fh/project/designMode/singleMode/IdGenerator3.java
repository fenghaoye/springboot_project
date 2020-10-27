package com.fh.project.designMode.singleMode;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description 单例模式，双重检测
 * @Author fenghao
 * @Email 849260688@qq.com
 * @Date 2020/4/6 11:01 上午
 */
public class IdGenerator3 {
    private AtomicLong id = new AtomicLong(0);
    private static IdGenerator3 instance;

    private IdGenerator3() {

    }

    public static IdGenerator3 getInstance() { // 此处为类级别的锁
        if (instance == null) {
            synchronized (IdGenerator3.class) {
                if (instance == null) {
                    instance = new IdGenerator3();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}

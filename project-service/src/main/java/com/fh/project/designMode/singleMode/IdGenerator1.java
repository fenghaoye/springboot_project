package com.fh.project.designMode.singleMode;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description 单例模式，饿汉式
 * @Author fenghao
 * @Email 849260688@qq.com
 * @Date 2020/4/6 11:01 上午
 */
public class IdGenerator1 {

    private AtomicLong id = new AtomicLong(0);

    private static final IdGenerator1 instance = new IdGenerator1();

    private IdGenerator1() {
    }

    public static IdGenerator1 getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

}

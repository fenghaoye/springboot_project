package com.fh.project.designMode.singleMode;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description 单例模式，静态内部类
 * @Author fenghao
 * @Email 849260688@qq.com
 * @Date 2020/4/6 11:01 上午
 */
public class IdGenerator4 {

    private AtomicLong id = new AtomicLong(0);

    private IdGenerator4() {
    }

    private static class SingletonHolder {
        private static final IdGenerator4 instance = new IdGenerator4();
    }

    public static IdGenerator4 getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

}

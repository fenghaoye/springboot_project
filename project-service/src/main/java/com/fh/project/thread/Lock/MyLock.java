package com.fh.project.thread.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/*
    自定义锁
 */
public class MyLock implements Lock {
    private boolean isLock = false;
    @Override
    public synchronized void lock() {
        while (isLock){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            isLock = true;
        }

    }

    @Override
    public synchronized void unlock() {
        notify();
        isLock = false;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
}

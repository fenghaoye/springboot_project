package com.fh.project.thread;

public class TestSettleOrderMethod {

    public void test(TestSettleOrder settleOrder){
       /* synchronized (settleOrder){

        }*/
        System.out.println(settleOrder.getNum());
    }


}

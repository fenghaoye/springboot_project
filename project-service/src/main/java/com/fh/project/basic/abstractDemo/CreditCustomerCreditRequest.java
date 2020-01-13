package com.fh.project.basic.abstractDemo;

public  class CreditCustomerCreditRequest {

    protected boolean build;


    public void init() {

    }


    public final void build() {
        if (this.build) {
            return;
        }
        init();
        verifyType();
        doBuild();
        this.build = true;
    }

    protected void doBuild() {
        System.out.println("父类 doBuild");
    }


    protected void verifyType() {
        System.out.println("父类 verifyType");
    }
}

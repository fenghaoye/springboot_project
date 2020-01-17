package com.fh.project.basic.effective.java19;

public abstract class CreditCustomerCreditRequest {
    public CreditCustomerCreditRequest() {
        System.out.println("CreditCustomerCreditRequest constructor");
    }

    /**
     * @implSpec
     */
    protected void doBuild() {
        System.out.println("supper class doBuild()");
    }
}

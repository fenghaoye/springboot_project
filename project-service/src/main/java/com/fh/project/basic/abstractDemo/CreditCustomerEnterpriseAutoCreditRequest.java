package com.fh.project.basic.abstractDemo;

public class CreditCustomerEnterpriseAutoCreditRequest extends CreditCustomerCreditRequest {


    @Override
    protected void verifyType() {
        System.out.println("子类 verifyType");
        //super.verifyType();
    }

    @Override
    protected void doBuild() {
        System.out.println("子类 doBuild");
        super.doBuild();

    }

    public static void main(String[] args) {
        CreditCustomerCreditRequest request = new CreditCustomerEnterpriseAutoCreditRequest();
        request.build();
    }
}

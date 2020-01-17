package com.fh.project.basic.effective.java19;

public class CreditCustomerEnterpriseAutoCreditRequest extends CreditCustomerCreditRequest {

    public CreditCustomerEnterpriseAutoCreditRequest() {
    }



    @Override
    protected void doBuild() {
        System.out.println("doBuild()");
    }



    public static void main(String[] args) {
        CreditCustomerEnterpriseAutoCreditRequest creditCustomerEnterpriseAutoCreditRequest = new CreditCustomerEnterpriseAutoCreditRequest();
        creditCustomerEnterpriseAutoCreditRequest.doBuild();
    }
}

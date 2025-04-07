package com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.model;

public enum PaymentMethod {

    CASH("Cash"),
    BANK_TRANSFER("Bank Transfer"),
    MOBILE_MONEY("Mobile Money");

    private String method;

    PaymentMethod(String method){
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}

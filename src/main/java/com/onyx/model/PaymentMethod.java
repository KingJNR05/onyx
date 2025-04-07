package com.onyx.model;

public enum PaymentMethod {

    CASH("Cash"),
    BANK_TRANSFER("Bank Transfer"),
    MOBILE_MONEY("Mobile Money");

    private final String method;

    PaymentMethod(String method){
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}

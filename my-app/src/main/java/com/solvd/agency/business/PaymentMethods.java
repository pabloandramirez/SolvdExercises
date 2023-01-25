package com.solvd.agency.business;

public enum PaymentMethods {

    CASH("Cash"),
    TRANSFER("Transfer");

    private String method;
    PaymentMethods(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}

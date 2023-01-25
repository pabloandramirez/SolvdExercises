package com.solvd.agency.business;


public enum RentOrBuy {
    FOR_RENT("For Rent"),
    FOR_BUY("For Buy");

    private final String rentOrBuy;

    RentOrBuy(String rentOrBuy){
        this.rentOrBuy = rentOrBuy;
    }

    public String getRentOrBuy(){
        return this.rentOrBuy;
    }
}

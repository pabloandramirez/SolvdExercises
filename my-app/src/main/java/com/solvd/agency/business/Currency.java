package com.solvd.agency.business;

import com.solvd.agency.persons.Customer;

public enum Currency {

    U$S("Dollar"),
    E€U ("Euro");
    static double dollarToEuro = 0.92;
    static double euroToDollar = 1.09;

    private final String currency;

    Currency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public static double convertCurrency(Apartment apartment, Customer customer){
        double newPrice;
        if (customer.getCurrency()==Currency.U$S){
            newPrice = apartment.getPrice() * dollarToEuro;
        } else {
            newPrice = apartment.getPrice() * euroToDollar;
        }
        return  newPrice;
    }
}

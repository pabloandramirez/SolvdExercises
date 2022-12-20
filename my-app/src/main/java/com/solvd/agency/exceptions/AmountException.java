package com.solvd.agency.exceptions;

public class AmountException extends IllegalArgumentException{

    public AmountException(){
        super("The amount must be above zero");
    }
}

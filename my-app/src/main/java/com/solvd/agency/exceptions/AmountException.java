package com.solvd.agency.exceptions;

public class AmountException extends RuntimeException{

    public AmountException(){
        super("The amount must be above zero");
    }
}

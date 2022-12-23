package com.solvd.agency.exceptions;

public class NumberFieldException extends IllegalArgumentException{

    public NumberFieldException(){
        super("The field must contain only numbers");
    }
}

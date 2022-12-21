package com.solvd.agency.exceptions;

public class FieldException extends IllegalArgumentException {

    public FieldException(){
        super("The field must contain only letters");
    }
}

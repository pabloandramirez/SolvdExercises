package com.solvd.agency.exceptions;

public class StringFieldException extends IllegalArgumentException {

    public StringFieldException() {
        super("The field must contain only letters");
    }
}

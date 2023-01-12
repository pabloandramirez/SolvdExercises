package com.solvd.agency.exceptions;

public class WrongIdApartmentException extends IndexOutOfBoundsException{

    public WrongIdApartmentException() {
        super("The ID of apartment does not exists");
    }
}
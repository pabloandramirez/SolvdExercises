package com.solvd.agency.exceptions;

public class LocationException extends RuntimeException{

    public LocationException(){
        super("There is no apartments with this location");
    }
}

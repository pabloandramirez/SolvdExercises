package com.solvd.agency.exceptions;

public class RoomException extends IllegalArgumentException{

    public RoomException(){
        super("The number of rooms must be above zero");
    }
}

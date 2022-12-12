package solvd.agency.src.exceptions;

public class RoomException extends RuntimeException{

    public RoomException(){
        super("The number of rooms must be upper than zero");
    }
}

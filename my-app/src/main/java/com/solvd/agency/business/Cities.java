package com.solvd.agency.business;

public enum Cities {

    FLORIDA("Florida"),
    NEW_JORK("New Jork"),
    WASHINGTON("Washington"),
    PARIS("Paris"),
    ROME("Roma"),
    BARCELONA("Barcelona");

    private final String name;

    Cities(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}

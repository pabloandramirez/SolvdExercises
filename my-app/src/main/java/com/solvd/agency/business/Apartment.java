package com.solvd.agency.business;

import com.solvd.agency.persons.Person;

import java.util.Objects;

public final class Apartment {
    private final int idApartment;
    private String location;
    private float price;
    private int numberRooms;
    private static int idCounter;
    private boolean available;
    private Person owner;
    private RentOrBuy rentOrBuy;

    private Apartment() {
        this.idApartment = ++Apartment.idCounter;
    }

    public Apartment(Person owner, String location, float price, int numberRooms, Boolean available, RentOrBuy rentOrBuy) {
        this();
        this.owner = owner;
        this.location = location;
        this.price = price;
        this.numberRooms = numberRooms;
        this.available = available;
        this.rentOrBuy = rentOrBuy;
    }

    public int getIdApartment() {
        return idApartment;
    }


    public String getLocation() {
        return location.toLowerCase();
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumberRooms() {
        return numberRooms;
    }

    public void setNumberRooms(int numberRooms) {
        this.numberRooms = numberRooms;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public RentOrBuy getRentOrBuy() {
        return rentOrBuy;
    }


    @Override
    public String toString() {
        return "Apartment{" +
                "idApartment=" + idApartment +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", numberRooms=" + numberRooms +
                ", available=" + available +
                ", for rent or for buy=" + this.rentOrBuy +
                ", owner=" + owner.getFirstName() + " " + owner.getLastName() +
                ", owner contact=" + owner.getPhoneNumber() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return idApartment == apartment.idApartment && Float.compare(apartment.price, price) == 0
                && numberRooms == apartment.numberRooms && available == apartment.available
                && location.equals(apartment.location) && owner.equals(apartment.owner)
                && rentOrBuy == apartment.rentOrBuy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idApartment, location, price, numberRooms, available, owner, rentOrBuy);
    }
}

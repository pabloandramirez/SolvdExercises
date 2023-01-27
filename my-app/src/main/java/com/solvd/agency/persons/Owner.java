package com.solvd.agency.persons;


import com.solvd.agency.business.Apartment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public final class Owner extends Person {
    private final int idOwner;
    private static int idCounter;
    private ArrayList<Apartment> apartments = new ArrayList<>();
    private double profitsPerApartmentsSold;
    private static final Logger LOGGER = LogManager.getLogger(Owner.class);

    public Owner(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName, phoneNumber);
        this.idOwner = ++Owner.idCounter;
    }

    public void addApartments(Apartment... apartments) {
        this.apartments.addAll(Arrays.asList(apartments));
    }

    public void showApartments(){
        this.apartments.forEach(apartment -> LOGGER.info(apartment.toString()));
    }

    public int getIdOwner() {
        return idOwner;
    }

    public double getProfitsPerApartmentsSold() {
        return profitsPerApartmentsSold;
    }

    public void setProfitsPerApartmentsSold(double profitsPerApartmentsSold) {
        this.profitsPerApartmentsSold = profitsPerApartmentsSold;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "idOwner=" + idOwner +
                ", person=" + super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Owner owner = (Owner) o;
        return idOwner == owner.idOwner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idOwner);
    }
}

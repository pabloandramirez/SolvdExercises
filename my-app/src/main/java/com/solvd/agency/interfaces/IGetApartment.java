package com.solvd.agency.interfaces;

import com.solvd.agency.business.Apartment;

import java.util.ArrayList;

public interface IGetApartment {

    Apartment findApartmentWithId(int id);

    ArrayList<Apartment> findApartmentWithLocation(String location);
}

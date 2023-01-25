package com.solvd.agency.interfaces;

import com.solvd.agency.business.Apartment;
import com.solvd.agency.business.Cities;

import java.util.ArrayList;

public interface IGetApartment {

    Apartment findApartmentWithId(int id);

    ArrayList<Apartment> findApartmentWithLocation(Cities location);
}

package solvd.agency.src.interfaces;

import solvd.agency.src.business.Apartment;

import java.util.ArrayList;

public interface IGetApartment {

    Apartment findApartmentWithId(int id);

    ArrayList<Apartment> findApartmentWithLocation(String location);
}

package com.solvd.agency.interfaces;

import com.solvd.agency.business.Apartment;
import com.solvd.agency.business.Cities;
import com.solvd.agency.persons.Customer;

import java.util.ArrayList;

@FunctionalInterface
public interface IBuySearch {

    ArrayList<Apartment> buySearch(int rooms, Cities location, Customer customer);

}

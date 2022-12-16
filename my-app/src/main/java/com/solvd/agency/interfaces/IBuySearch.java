package com.solvd.agency.interfaces;

import com.solvd.agency.business.Agency;
import com.solvd.agency.business.Apartment;
import com.solvd.agency.business.Contract;
import com.solvd.agency.business.RentOrBuy;
import com.solvd.agency.persons.Agent;
import com.solvd.agency.persons.Customer;
import com.solvd.agency.persons.Owner;


public interface IBuySearch {

    void buySearch(int rooms, String location, Customer customer);

}

package com.solvd.agency.interfaces;

import com.solvd.agency.business.Agency;
import com.solvd.agency.business.Apartment;
import com.solvd.agency.business.RentOrBuy;
import com.solvd.agency.persons.Agent;
import com.solvd.agency.persons.Customer;
import com.solvd.agency.persons.Owner;

public interface IRentContract {

    RentOrBuy TYPE_OF_CONTRACT = RentOrBuy.FOR_RENT;


    public void makeRentContract(Customer customer, int idApartment, Agent agent);


}
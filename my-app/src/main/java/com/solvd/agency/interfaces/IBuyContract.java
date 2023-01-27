package com.solvd.agency.interfaces;

import com.solvd.agency.business.PaymentMethods;
import com.solvd.agency.business.RentOrBuy;
import com.solvd.agency.persons.Agent;
import com.solvd.agency.persons.Customer;
@FunctionalInterface
public interface IBuyContract {

    RentOrBuy TYPE_OF_CONTRACT = RentOrBuy.FOR_BUY;

    void makeBuyContract(Customer customer, int idApartment, Agent agent, PaymentMethods methods);

}
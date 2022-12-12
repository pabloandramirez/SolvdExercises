package solvd.agency.src.interfaces;


import solvd.agency.src.business.RentOrBuy;
import solvd.agency.src.persons.Agent;
import solvd.agency.src.persons.Customer;

public interface IBuyContract {

    RentOrBuy TYPE_OF_CONTRACT = RentOrBuy.FOR_BUY;

    public void makeBuyContract(Customer customer, int idApartment, Agent agent);

}
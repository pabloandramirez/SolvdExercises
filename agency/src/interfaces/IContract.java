package solvd.agency.src.interfaces;

import solvd.agency.src.business.Agency;
import solvd.agency.src.business.Apartment;
import solvd.agency.src.persons.Agent;
import solvd.agency.src.persons.Customer;
import solvd.agency.src.persons.Owner;


public interface IContract{

    void iContract(Customer customer, Apartment apartment, Agent agent, Owner owner, Agency agency);

}

package com.solvd.agency;

import com.solvd.agency.business.Agency;
import com.solvd.agency.business.Apartment;
import com.solvd.agency.business.RentOrBuy;
import com.solvd.agency.persons.Agent;
import com.solvd.agency.persons.Customer;
import com.solvd.agency.persons.Owner;

import org.apache.logging.log4j.Logger;

public class Main {
    
    public static void main(String[] args) {
        Owner owner1 = new Owner("John", "Doe", 1234567);
        Owner owner2 = new Owner("Meryl", "Streep", 2345678);
        Owner owner3 = new Owner("Jason", "Momoa", 3456789);

        Customer customerPaul = new Customer("Paul", "Newman", 123456, 9000, "Chicago", "pablo@mail.com");
        Customer customerMartin = new Customer("Martin", "Scorsese", 123456, 7000, "Missouri", "pablo@mail.com");
        Customer customerJonas = new Customer("Jonas", "Johnson", 123456, 9000, "Los Angeles", "pablo@mail.com");

        Agent agent1 = new Agent("Drew", "Barrymore", 123456, 20,10);
        Agent agent2 = new Agent("Kevin", "Hart", 123456, 20,10);
        Agent agent3 = new Agent("Dwayne", "Johnson", 123456, 20,10);

        Apartment apartmentMinimalistic = new Apartment(owner1, "Los Angeles", 5000, 5, true, RentOrBuy.FOR_BUY);
        Apartment apartmentEcologic = new Apartment(owner1, "New York", 4000, 3, true, RentOrBuy.FOR_RENT);
        Apartment apartmentFuturistic = new Apartment(owner1, "Chicago", 3500, 3, true, RentOrBuy.FOR_RENT);
        Apartment apartmentRustic = new Apartment(owner2, "Los Angeles", 1500, 1, true, RentOrBuy.FOR_BUY);
        Apartment apartmentSimple = new Apartment(owner2, "Chicago", 2000, 3, true, RentOrBuy.FOR_RENT);
        Apartment apartmentFuturistic2 = new Apartment(owner2, "Santa Cruz", 6000, 4, true, RentOrBuy.FOR_RENT);
        Apartment apartmentSimple2 = new Apartment(owner3, "New Jersey", 3500, 2, true, RentOrBuy.FOR_BUY);
        Apartment apartmentLuxury = new Apartment(owner3, "Washington", 5500, 4, true, RentOrBuy.FOR_RENT);
        Apartment apartmentSpecial = new Apartment(owner3, "Chicago", 7000, 3, true, RentOrBuy.FOR_BUY);

        Agency agency1 = new Agency("Real Estate Agency", "Evergreen 123", 12345678);
        agency1.addApartment(apartmentMinimalistic, apartmentEcologic, apartmentFuturistic,
                apartmentRustic, apartmentSimple);
        agency1.addApartment( apartmentFuturistic2, apartmentSimple2,
                apartmentLuxury, apartmentSpecial);
        agency1.addOwner(owner1, owner2, owner3);
        agency1.addCustomer(customerJonas,customerMartin,customerPaul);
        agency1.addAgent(agent1,agent2,agent3);


        if (owner1 == owner2){
            System.out.println("Same memory space reference");
        } else {
            System.out.println("Not same memory space reference");
        }
        if (owner1.equals(owner2)){
            System.out.println("Objects with same content");
        } else {
            System.out.println("Objects with different content");
        }
        if (owner1.hashCode() == owner2.hashCode()){
            System.out.println("Objects with same hash code");
        } else {
            System.out.println("Objects with different hash code");
        }

        agency1.rentSearch(-8, "Chicago", customerMartin);


        agency1.buySearch(1, "zxfgfsdgsdfg", customerJonas);




        agency1.makeBuyContract(customerJonas, 9, agent1);
        agency1.makeRentContract(customerMartin, 3, agent1);
        agency1.makeRentContract(customerMartin, 5, agent1);

        agency1.showContracts();


    }
}

package com.solvd.agency;

import com.solvd.agency.business.*;
import com.solvd.agency.exceptions.AmountException;
import com.solvd.agency.exceptions.RoomException;
import com.solvd.agency.exceptions.WrongIdApartmentException;
import com.solvd.agency.lambdas.ISearchApartment;
import com.solvd.agency.persons.Agent;
import com.solvd.agency.persons.Customer;
import com.solvd.agency.persons.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Owner owner1 = new Owner("Paul", "Walker", "fsff");
        Owner owner2 = new Owner("Meryl", "Streep", "2345678");
        Owner owner3 = new Owner("Jason", "Momoa", "3456789");

        Customer customerPaul = new Customer("Paul", "Newman", "123456", Currency.U$S,9000, "Chicago", "pablo@mail.com", 4);
        Customer customerMartin = new Customer("Martin", "Scorsese", "123456", Currency.E€U, 7000, "Missouri", "pablo@mail.com", 4);
        Customer customerJonas = new Customer("Jonas", "Johnson", "123456", Currency.U$S, 9000, "Los Angeles", "pablo@mail.com", 4);

        Agent agent1 = new Agent("Drew", "Barrymore", "123456", 10,5);
        Agent agent2 = new Agent("Kevin", "Hart", "123456", 10,5);
        Agent agent3 = new Agent("Dwayne", "Johnson", "123456", 10,5);

        Apartment apartmentMinimalistic = new Apartment(owner1, Cities.FLORIDA, Currency.U$S, 5000, 5, true, RentOrBuy.FOR_BUY);
        Apartment apartmentEcologic = new Apartment(owner1, Cities.BARCELONA, Currency.E€U,4000, 3, true, RentOrBuy.FOR_RENT);
        Apartment apartmentFuturistic = new Apartment(owner1, Cities.FLORIDA, Currency.U$S, 3500, 3, true, RentOrBuy.FOR_RENT);
        Apartment apartmentRustic = new Apartment(owner2, Cities.WASHINGTON, Currency.U$S,1500, 1, true, RentOrBuy.FOR_BUY);
        Apartment apartmentSimple = new Apartment(owner2, Cities.PARIS, Currency.U$S,2000, 3, true, RentOrBuy.FOR_RENT);
        Apartment apartmentFuturistic2 = new Apartment(owner2, Cities.NEW_JORK, Currency.U$S,6000, 4, true, RentOrBuy.FOR_RENT);
        Apartment apartmentSimple2 = new Apartment(owner3, Cities.ROME, Currency.U$S,3500, 2, true, RentOrBuy.FOR_BUY);
        Apartment apartmentLuxury = new Apartment(owner3, Cities.BARCELONA, Currency.U$S,5500, 4, true, RentOrBuy.FOR_RENT);
        Apartment apartmentSpecial = new Apartment(owner3, Cities.NEW_JORK, Currency.U$S,7000, 3, true, RentOrBuy.FOR_BUY);

        Agency agency1 = new Agency("Real Estate Agency", "Evergreen 123", "12345678", 15, 25);
        agency1.addApartment(apartmentMinimalistic, apartmentEcologic, apartmentFuturistic,
                apartmentRustic, apartmentSimple);
        agency1.addApartment( apartmentFuturistic2, apartmentSimple2,
                apartmentLuxury, apartmentSpecial);
        agency1.addOwner(owner1, owner2, owner3);
        agency1.addCustomer(customerJonas,customerMartin,customerPaul);
        agency1.addAgent(agent1,agent2,agent3);

        agency1.showAgents();
        agency1.showCustomers();
        agency1.showOwners();


        if (owner1 == owner2){
            LOGGER.info("Same memory space reference");
        } else {
            LOGGER.info("Not same memory space reference");
        }
        if (owner1.equals(owner2)){
            LOGGER.info("Objects with same content");
        } else {
            LOGGER.info("Objects with different content");
        }
        if (owner1.hashCode() == owner2.hashCode()){
            LOGGER.info("Objects with same hash code");
        } else {
            LOGGER.info("Objects with different hash code");
        }



        searchApartments(agency1.getApartments(), customerJonas, (a, c) -> a.getAvailable()
        && agency1.numberRooms(c.getNumberOfRooms(), a.getNumberRooms())
        && agency1.compareAmount(a, c)
        && a.getRentOrBuy() == RentOrBuy.FOR_BUY);

        searchApartments(agency1.getApartments(), customerJonas, (a, c) -> a.getAvailable()
                && agency1.numberRooms(c.getNumberOfRooms(), a.getNumberRooms())
                && agency1.compareAmount(a, c)
                && a.getRentOrBuy() == RentOrBuy.FOR_RENT);

        try{
            agency1.makeBuyContract(customerJonas, 19, agent1, PaymentMethods.CASH);
            agency1.makeRentContract(customerMartin, 25, agent1, PaymentMethods.CASH);
            agency1.makeRentContract(customerMartin, 5, agent1, PaymentMethods.TRANSFER);
        } catch (RoomException| AmountException| WrongIdApartmentException e){
            LOGGER.warn(e.getMessage());
        }


        agency1.showContracts();

        agency1.showCustomers();

        agency1.showAgents();

        agency1.showOwners();

        agency1.showApartments(agency1.getApartments(), (apartments) -> {
            for (Object apartment: apartments ) {
                LOGGER.info(apartment);
            }
        });

    }

    public static void searchApartments(ArrayList<Apartment> apartments, Customer customer, ISearchApartment<Apartment, Customer> search){
        apartments
                .stream()
                .filter(apartment -> search.searchApartment(apartment, customer))
                .forEach(LOGGER::info);
    }





}

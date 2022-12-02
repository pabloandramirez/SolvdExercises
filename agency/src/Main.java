package solvd.agency.src;

import solvd.agency.src.business.Agency;
import solvd.agency.src.business.Apartment;
import solvd.agency.src.business.RentOrBuy;
import solvd.agency.src.persons.Agent;
import solvd.agency.src.persons.Customer;
import solvd.agency.src.persons.Owner;

public class Main {
    public static void main(String[] args) {
        Owner owner1 = new Owner("John", "Doe", 1234567);
        Owner owner2 = new Owner("Meryl", "Streep", 2345678);
        Owner owner3 = new Owner("Jason", "Momoa", 3456789);

        Customer customerPaul = new Customer("Paul", "Newman", 123456, 8000.00, "Chicago", "pablo@mail.com");
        Customer customerMartin = new Customer("Martin", "Scorsese", 123456, 7000.00, "Missouri", "pablo@mail.com");
        Customer customerJonas = new Customer("Jonas", "Johnson", 123456, 9000.00, "Los Angeles", "pablo@mail.com");

        Agent agent1 = new Agent("Drew", "Barrymore", 123456, 20,10);
        Agent agent2 = new Agent("Kevin", "Hart", 123456, 20,10);
        Agent agent3 = new Agent("Dwayne", "Johnson", 123456, 20,10);

        Apartment apartmentMinimalistic = new Apartment(owner1, "Los Angeles", 5000, 5, true, RentOrBuy.ForBuy);
        Apartment apartmentEcologic = new Apartment(owner1, "New York", 4000, 3, true, RentOrBuy.ForRent);
        Apartment apartmentFuturistic = new Apartment(owner1, "Chicago", 3500, 3, true, RentOrBuy.ForRent);
        Apartment apartmentRustic = new Apartment(owner2, "Los Angeles", 1500, 1, true, RentOrBuy.ForBuy);
        Apartment apartmentSimple = new Apartment(owner2, "Chicago", 2000, 3, true, RentOrBuy.ForRent);
        Apartment apartmentFuturistic2 = new Apartment(owner2, "Santa Cruz", 6000, 4, true, RentOrBuy.ForRent);
        Apartment apartmentSimple2 = new Apartment(owner3, "New Jersey", 3500, 2, true, RentOrBuy.ForBuy);
        Apartment apartmentLuxury = new Apartment(owner3, "Washington", 5500, 4, true, RentOrBuy.ForRent);
        Apartment apartmentSpecial = new Apartment(owner3, "Chicago", 7000, 3, true, RentOrBuy.ForBuy);

        Agency agency1 = new Agency("Real Estate Agency", "Evergreen 123", 12345678);
        agency1.addApartment(apartmentMinimalistic, apartmentEcologic, apartmentFuturistic,
                apartmentRustic, apartmentSimple, apartmentFuturistic2, apartmentSimple2,
                apartmentLuxury, apartmentSpecial);
        agency1.addOwner(owner1, owner2, owner3);
        agency1.addCustomer(customerJonas,customerMartin,customerPaul);
        agency1.addAgent(agent1,agent2,agent3);


        agency1.rentSearch(3, "Chicago", customerMartin, agency1.getApartments());
        agency1.buySearch(3, "Chicago", customerJonas, agency1.getApartments());


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
    }
}

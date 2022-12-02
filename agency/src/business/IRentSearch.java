package solvd.agency.src.business;

import solvd.agency.src.persons.Customer;

public interface IRentSearch {
    public default void rentSearch(int rooms, String location, Customer customer, Apartment apartments[]){
        int o = 1;
        for (int i = 0; i < apartments.length ; i++) {
            if (apartments[i].getAvailable()) {
                if (rooms == apartments[i].getNumberRooms()) {
                    if (location.toLowerCase().equals(apartments[i].getLocation())) {
                        if (customer.getAmount() >= apartments[i].getPrice()) {
                            if (apartments[i].getRentOrBuy() == RentOrBuy.ForRent) {
                                System.out.println("Coincidence for rent " + (o++));
                                System.out.println(apartments[i]);
                            }
                        }
                    }
                }
            }
        }
    }
}

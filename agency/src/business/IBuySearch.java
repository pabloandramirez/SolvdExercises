package solvd.agency.src.business;

import solvd.agency.src.persons.Customer;

public interface IBuySearch {

    public default void buySearch(int rooms, String location, Customer customer, Apartment apartments[]){
        int o = 1;
        for (int i = 0; i < apartments.length ; i++) {
            if (apartments[i].getAvailable()) {
                if (rooms == apartments[i].getNumberRooms()) {
                    if (location.toLowerCase().equals(apartments[i].getLocation())) {
                        if (customer.getAmount() >= apartments[i].getPrice()) {
                            if (apartments[i].getRentOrBuy() == RentOrBuy.ForBuy) {
                                System.out.println("Coincidence for buy " + (o++));
                                System.out.println(apartments[i]);
                            }
                        }
                    }
                }
            }
        }
    }
}

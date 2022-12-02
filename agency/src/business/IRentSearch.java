package solvd.agency.src.business;

public interface IRentSearch {
    public default void rentSearch(int rooms, String location, float price, Apartment apartments[]){
        int o = 1;
        for (int i = 0; i < apartments.length ; i++) {
            if (apartments[i].getAvailable()) {
                if (rooms == apartments[i].getNumberRooms()) {
                    if (location.toLowerCase().equals(apartments[i].getLocation())) {
                        if (price >= apartments[i].getPrice()) {
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

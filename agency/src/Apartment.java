package solvd.agency.src;

public class Apartment {
    private int idApartment;
    private String location;
    private float price;
    private int numberRooms;
    private static int idCounter;
    private boolean available;
    private Owner owner;
    private RentOrBuy rentOrBuy;

    private Apartment() {
        this.idApartment = ++Apartment.idCounter;
    }

    public Apartment(Owner owner, String location, float price, int numberRooms, Boolean available, RentOrBuy rentOrBuy) {
        this();
        this.owner = owner;
        this.location = location;
        this.price = price;
        this.numberRooms = numberRooms;
        this.available = available;
        this.rentOrBuy = rentOrBuy;
    }

    public int getIdApartment() {
        return idApartment;
    }


    public String getLocation() {
        return location.toLowerCase();
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumberRooms() {
        return numberRooms;
    }

    public void setNumberRooms(int numberRooms) {
        this.numberRooms = numberRooms;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public RentOrBuy getRentOrBuy() {
        return rentOrBuy;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "idApartment=" + idApartment +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", numberRooms=" + numberRooms +
                ", available=" + available +
                ", for rent or for buy=" + this.rentOrBuy +
                ", owner=" + owner.getFirstName() + " " + owner.getLastName() +
                ", owner contact=" + owner.getPhoneNumber() +
                '}';
    }
}

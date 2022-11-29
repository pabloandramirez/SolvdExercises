package solvd.agency.src;

public class Customer {
    private int idClient;
    private String firstName;
    private String lastName;
    private String city;
    private String email;
    private long phoneNumber;
    private static int idCounter;
    private Apartment apartments[] = new Apartment[9];
    private int apartmentCounter;

    private Customer(){
        this.idClient = ++Customer.idCounter;
    }

    public Customer(String firstName, String lastName, String city, String email, long phoneNumber) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void buySearch(int rooms, String location, float price, Agency agency){
        int o = 1;
        for (int i = 0; i < agency.getApartments().length ; i++) {
            if (agency.getApartments()[i].getAvailable()) {
                if (rooms == agency.getApartments()[i].getNumberRooms()) {
                    if (location.toLowerCase().equals(agency.getApartments()[i].getLocation())) {
                        if (price >= agency.getApartments()[i].getPrice()) {
                            if (agency.getApartments()[i].getRentOrBuy() == RentOrBuy.ForBuy) {
                                System.out.println("Coincidence for buy " + (o++));
                                System.out.println(agency.getApartments()[i]);
                            }
                        }
                    }
                }
            }
        }
    }

    public void rentSearch(int rooms, String location, float price, Agency agency){
        int o = 1;
        for (int i = 0; i < agency.getApartments().length ; i++) {
            if (agency.getApartments()[i].getAvailable()) {
                if (rooms == agency.getApartments()[i].getNumberRooms()) {
                    if (location.toLowerCase().equals(agency.getApartments()[i].getLocation())) {
                        if (price >= agency.getApartments()[i].getPrice()) {
                            if (agency.getApartments()[i].getRentOrBuy() == RentOrBuy.ForRent) {
                                System.out.println("Coincidence for rent " + (o++));
                                System.out.println(agency.getApartments()[i]);
                            }
                        }
                    }
                }
            }
        }
    }


    public void buyApartment(Apartment apartment){
        this.apartments[this.apartmentCounter++] = apartment;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idClient=" + idClient +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}

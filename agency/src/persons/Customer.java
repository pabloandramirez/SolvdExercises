package solvd.agency.src.persons;

public class Customer extends Person {
    private int idClient;
    private String city;
    private String email;
    private static int idCounter;
    private int apartmentCounter;


    public Customer(String firstName, String lastName, long phoneNumber, String city, String email) {
        super(firstName, lastName, phoneNumber);
        this.idClient = ++Customer.idCounter;
        this.city = city;
        this.email = email;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", person=" + super.toString() +
                '}';
    }
}

package solvd.agency.src;

public class Customer {
    private int idClient;
    private String firstName;
    private String lastName;
    private String city;
    private String email;
    private long phoneNumber;
    private static int idCounter;
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

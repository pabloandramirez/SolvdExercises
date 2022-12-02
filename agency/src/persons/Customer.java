package solvd.agency.src.persons;

public class Customer extends Person {
    private int idClient;
    private String city;
    private String email;
    private static int idCounter;
    private double amount;


    public Customer(String firstName, String lastName, long phoneNumber, double amount, String city, String email) {
        super(firstName, lastName, phoneNumber);
        this.idClient = ++Customer.idCounter;
        this.amount = amount;
        this.city = city;
        this.email = email;
    }

    public int getIdClient() {
        return idClient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

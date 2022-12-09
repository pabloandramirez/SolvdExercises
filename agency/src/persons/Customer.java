package solvd.agency.src.persons;


import solvd.agency.src.business.Apartment;

import java.util.Objects;

public final class Customer extends Person {
    private final int idClient;
    private String city;
    private String email;
    private static int idCounter;
    private double amount;
    private Apartment[] apartments;


    public Customer(String firstName, String lastName, long phoneNumber, double amount, String city, String email) {
        super(firstName, lastName, phoneNumber);
        this.idClient = ++Customer.idCounter;
        this.amount = amount;
        this.city = city;
        this.email = email;
    }

    public void addApartments(Apartment... apartments){
        for (int i = 0; i < apartments.length; i++) {
            this.apartments[i] = apartments[i];
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return idClient == customer.idClient && Double.compare(customer.amount, amount) == 0 && city.equals(customer.city) && email.equals(customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idClient, city, email, amount);
    }

}

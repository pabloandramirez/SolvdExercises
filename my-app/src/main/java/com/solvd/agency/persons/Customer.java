package com.solvd.agency.persons;


import com.solvd.agency.business.Apartment;
import com.solvd.agency.business.Currency;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public final class Customer extends Person {
    private final int idClient;
    private String city;
    private String email;
    private static int idCounter;
    private Currency currency;
    private float amount;
    private ArrayList<Apartment> apartments = new ArrayList<>();
    private static final Logger LOGGER = LogManager.getLogger(Customer.class);


    public Customer(String firstName, String lastName, String phoneNumber, Currency currency, float amount, String city, String email) {
        super(firstName, lastName, phoneNumber);
        this.idClient = ++Customer.idCounter;
        this.currency = currency;
        this.amount = amount;
        this.city = city;
        this.email = email;
    }


    public void addApartments(Apartment... apartments) {
        this.apartments.addAll(Arrays.asList(apartments));
    }

    public void showApartments(){
        this.apartments.forEach(apartment -> LOGGER.info(apartment.toString()));
    }

    public int getIdClient() {
        return idClient;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
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
        return idClient == customer.idClient && Double.compare(customer.amount, amount) == 0 &&
                city.equals(customer.city) && email.equals(customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idClient, city, email, amount);
    }

}

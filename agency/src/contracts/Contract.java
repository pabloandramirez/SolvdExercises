package solvd.agency.src.contracts;

import solvd.agency.src.business.RentOrBuy;
import solvd.agency.src.persons.Agent;
import solvd.agency.src.business.Apartment;
import solvd.agency.src.persons.Customer;

import java.util.Objects;

abstract class Contract {
    private int idContract;
    private Customer customer;
    private Apartment apartment;
    private Agent agent;
    private static int idCounter;

    public Contract(Customer customer, Apartment apartment, Agent agent) {
        this.idContract = ++Contract.idCounter;
        this.customer = customer;
        this.apartment = apartment;
        this.agent = agent;
    }

    abstract void checkAvailable(Apartment apartment, RentOrBuy rentOrBuy);

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public int getIdContract() {
        return idContract;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "customer=" + customer +
                ", apartment=" + apartment +
                ", agent=" + agent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return idContract == contract.idContract && apartment == contract.apartment && customer.equals(contract.customer) && agent.equals(contract.agent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContract, customer, apartment, agent);
    }
}

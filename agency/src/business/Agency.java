package solvd.agency.src.business;

import solvd.agency.src.persons.Agent;
import solvd.agency.src.persons.Customer;
import solvd.agency.src.persons.Owner;

public class Agency implements IBuySearch, IRentSearch {
    private String name;
    private String address;
    private long phoneNumber;
    private Apartment apartments[] = new  Apartment[9];
    private Customer customers[] = new Customer[3];
    private Agent agents[] = new Agent[3];
    private Owner owners[] = new Owner[3];
    private int apartmentsCounter;

    public Agency(String name, String address, long phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void addApartment(Apartment... apartments){
        for (int i = 0; i < apartments.length; i++) {
            this.apartments[i] = apartments[i];
        }
    }

    public void addCustomer(Customer... customers){
        for (int i = 0; i < customers.length; i++) {
            this.customers[i] = customers[i];
        }
    }

    public void addAgent(Agent... agents){
        for (int i = 0; i < agents.length; i++) {
            this.agents[i] = agents[i];
        }
    }

    public void addOwner(Owner... owners){
        for (int i = 0; i < owners.length; i++) {
            this.owners[i] = owners[i];
        }
    }

    public Apartment[] getApartments() {
        return apartments;
    }

    public void showApartments(){
        for (int i = 0; i < apartments.length; i++) {
            System.out.println(apartments[i]);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "agency{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}

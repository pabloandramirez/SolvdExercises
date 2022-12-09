package solvd.agency.src.business;

import solvd.agency.src.interfaces.*;
import solvd.agency.src.persons.Agent;
import solvd.agency.src.persons.Customer;
import solvd.agency.src.persons.Owner;

import java.util.*;

public final class Agency implements IBuySearch, IRentSearch {
    private String name;
    private String address;
    private long phoneNumber;
    private ArrayList<Apartment> apartments = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Agent> agents = new ArrayList<>();
    private ArrayList<Owner> owners = new ArrayList<>();


    public Agency(String name, String address, long phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void buySearch(int rooms, String location, Customer customer) {
        int o = 1;
        for (Apartment apartment : this.apartments) {
            if (apartment.getAvailable()) {
                if (rooms == apartment.getNumberRooms()) {
                    if (location.toLowerCase().equals(apartment.getLocation())) {
                        if (customer.getAmount() >= apartment.getPrice()) {
                            if (apartment.getRentOrBuy() == RentOrBuy.FOR_BUY) {
                                System.out.println("Coincidence for buy " + (o++));
                                System.out.println(apartment);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void rentSearch(int rooms, String location, Customer customer) {
        int o = 1;
        for (Apartment apartment : this.apartments) {
            if (apartment.getAvailable()) {
                if (rooms == apartment.getNumberRooms()) {
                    if (location.toLowerCase().equals(apartment.getLocation())) {
                        if (customer.getAmount() >= apartment.getPrice()) {
                            if (apartment.getRentOrBuy() == RentOrBuy.FOR_RENT) {
                                System.out.println("Coincidence for rent " + (o++));
                                System.out.println(apartment);
                            }
                        }
                    }
                }
            }
        }
    }


    public void addApartment(Apartment... apartments){
        this.apartments.addAll(Arrays.asList(apartments));
    }

    public void addCustomer(Customer... customers){
        Collections.addAll(this.customers, customers);
    }

    public void addAgent(Agent... agents){
        this.agents.addAll(Arrays.asList(agents));
    }

    public void addOwner(Owner... owners){
        Collections.addAll(this.owners, owners);
    }

    public ArrayList<Apartment> getApartments() {
        return apartments;
    }

    public void removeApartment(int idApartment){
        this.apartments.remove(idApartment);
    }

    public void showApartments(){
        for (Apartment apartment : apartments) {
            System.out.println(apartment + " ");
        }
    }

    public void showCustomers(){
        for (Customer customer : customers) {
            System.out.println(customer + " ");
        }
    }

    public void showOwners(){
        for (Owner owner : owners) {
            System.out.println(owner + " ");
        }
    }

    public void showAgents(){
        for (Agent agent : agents) {
            System.out.println(agent + " ");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agency agency = (Agency) o;
        return phoneNumber == agency.phoneNumber && name.equals(agency.name) && address.equals(agency.address) && apartments.equals(agency.apartments) && customers.equals(agency.customers) && agents.equals(agency.agents) && owners.equals(agency.owners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, phoneNumber, apartments, customers, agents, owners);
    }

}

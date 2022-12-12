package solvd.agency.src.business;



import solvd.agency.src.exceptions.LocationException;
import solvd.agency.src.exceptions.RoomException;
import solvd.agency.src.interfaces.*;
import solvd.agency.src.persons.Agent;
import solvd.agency.src.persons.Customer;
import solvd.agency.src.persons.Owner;

import java.util.*;


public final class Agency implements IBuySearch, IRentSearch, IBuyContract, IRentContract, IGetApartment {
    private String name;
    private String address;
    private long phoneNumber;
    private ArrayList<Apartment> apartments = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Agent> agents = new ArrayList<>();
    private ArrayList<Owner> owners = new ArrayList<>();
    private ArrayList<Contract> contracts = new ArrayList<>();


    public Agency(String name, String address, long phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Apartment findApartmentWithId(int id) {
        Apartment apartmentFound = null;
        for (Apartment apartment: apartments) {
            if (id == apartment.getIdApartment()){
                apartmentFound = apartment;
            }
        };
        return apartmentFound;
    }

    @Override
    public ArrayList<Apartment> findApartmentWithLocation(String location) {
        ArrayList<Apartment> apartmentsFound = new ArrayList<>();
        for (Apartment apartment: this.apartments){
            if(location.toLowerCase().equals(apartment.getLocation())){
                apartmentsFound.add(apartment);
            }
        }
        return apartmentsFound;
    }

    @Override
    public void makeBuyContract(Customer customer, int idApartment, Agent agent) {
        Apartment thisApartment = this.findApartmentWithId(idApartment);
        if (thisApartment.getAvailable() && thisApartment.getRentOrBuy() == IBuyContract.TYPE_OF_CONTRACT){
            if (customer.getAmount() >= thisApartment.getPrice()) {
                Contract contract = new Contract();
                System.out.println("Customer " + customer.getFirstName() + " " + customer.getLastName()
                        + " ID: " + customer.getIdClient()
                        + " bought the apartment ID " + thisApartment.getIdApartment()
                        + " to the owner " + thisApartment.getOwner()
                        + ", throw the agent " + agent.getFirstName()
                        + " " + agent.getLastName()
                        + " ID: " + agent.getIdAgent()
                        + " Contract ID: " + contract.getIdContract()
                        + " Date of the Contract: " + contract.getDateOfContract()
                );
                agent.setSaleCommission((thisApartment.getPrice() * agent.getPercentageSaleCommission())/100);
                this.getApartments().remove(thisApartment);
            }
        } else{
            System.out.println("Apartment not available or not for sale");
            System.out.println(thisApartment);;
            System.out.println(thisApartment.getIdApartment());
        }
    }

    @Override
    public void makeRentContract(Customer customer, int idApartment, Agent agent) {
        Apartment thisApartment = this.findApartmentWithId(idApartment);
        if (thisApartment.getAvailable() &&
                thisApartment.getRentOrBuy() == IRentContract.TYPE_OF_CONTRACT){
            if (customer.getAmount() >= thisApartment.getPrice()) {
                Contract contract = new Contract();
                System.out.println("Customer " + customer.getFirstName() + " " + customer.getLastName()
                        + " ID: " + customer.getIdClient()
                        + " rented the apartment ID " + thisApartment.getIdApartment()
                        + " to the owner " + thisApartment.getOwner()
                        + ", throw the agent " + agent.getFirstName()
                        + " " + agent.getLastName()
                        + " ID: " + agent.getIdAgent()
                        + " Contract ID: " + contract.getIdContract()
                        + " Date of the Contract: " + contract.getDateOfContract()
                );
                agent.setSaleCommission((thisApartment.getPrice() * agent.getPercentageSaleCommission())/100);
                this.getApartments().remove(thisApartment);
            }
        } else{
            System.out.println("Apartment not available or not for sale");
            System.out.println(thisApartment);;
            System.out.println(thisApartment.getIdApartment());
        }
    }

    @Override
    public void buySearch(int rooms, String location, Customer customer) {
        int o = 1;
        if (rooms > 0) {
            if (!this.findApartmentWithLocation(location).isEmpty()){
                int i=0;
                for (Apartment apartment : this.apartments) {
                    if (apartment.getAvailable()) {
                        if (rooms == apartment.getNumberRooms()) {
                            if (location.toLowerCase().equals(apartment.getLocation())) {
                                if (customer.getAmount() >= apartment.getPrice()) {
                                    if (apartment.getRentOrBuy() == RentOrBuy.FOR_BUY) {
                                        System.out.println("Coincidence for buy " + (o++));
                                        System.out.println(apartment);
                                        i++;
                                    }
                                }
                            }
                        }
                    }
                } if (i == 0){
                    System.out.println("There is no apartments for buy available with this number " +
                            "of rooms, location or amount");
                }
            } else {
                throw new LocationException();
            }
        } else {
            throw new RoomException();
        }
    }

    @Override
    public void rentSearch(int rooms, String location, Customer customer) {
        int o = 1;
        if (rooms > 0){
            if (!this.findApartmentWithLocation(location).isEmpty()) {
                int i = 0;
                for (Apartment apartment : this.apartments) {
                    if (apartment.getAvailable()) {
                        if (rooms == apartment.getNumberRooms()) {
                            if (location.toLowerCase().equals(apartment.getLocation())) {
                                if (customer.getAmount() >= apartment.getPrice()) {
                                    if (apartment.getRentOrBuy() == RentOrBuy.FOR_RENT) {
                                        System.out.println("Coincidence for rent " + (o++));
                                        System.out.println(apartment);
                                        i++;
                                    }
                                }
                            }
                        }
                    }
                } if (i == 0){
                    System.out.println("There is no apartments for rent available with this number " +
                            "of rooms, location or amount");
                }
            } else{
                throw new LocationException();
            }
        } else {
            throw new RoomException();
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

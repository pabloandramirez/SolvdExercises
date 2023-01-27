package com.solvd.agency.business;


import com.solvd.agency.exceptions.*;
import com.solvd.agency.interfaces.*;
import com.solvd.agency.lambdas.Printable;
import com.solvd.agency.persons.Agent;
import com.solvd.agency.persons.Customer;
import com.solvd.agency.persons.Owner;
import com.solvd.agency.utils.CustomLinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;


public final class Agency implements IBuyContract,
        IRentContract, IGetApartment, ICheckNumberField, ICheckStringField {
    private String name;
    private String address;
    private String phoneNumber;
    private int percentageForBuyContract;
    private int percentageForRentContract;
    private int profitsPerBuyContract;
    private int profitsPerRentContract;

    private ArrayList<Apartment> apartments = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Agent> agents = new ArrayList<>();
    private ArrayList<Owner> owners = new ArrayList<>();
    private CustomLinkedList<Contract> contracts = new CustomLinkedList<>();

    private static final Logger LOGGER = LogManager.getLogger(Agency.class);
    private Scanner input = new Scanner(System.in);


    public Agency(String name, String address, String phoneNumber, int percentageForBuyContract, int percentageForRentContract) {
        setName(name);
        this.address = address;
        setPhoneNumber(phoneNumber);
        this.percentageForBuyContract = percentageForBuyContract;
        this.percentageForRentContract = percentageForRentContract;
    }

    @Override
    public Apartment findApartmentWithId(int id) {
        Apartment apartmentFound = null;
        for (Apartment apartment : apartments) {
            if (id == apartment.getIdApartment()) {
                apartmentFound = apartment;
            }
        }
        return apartmentFound;
    }

    @Override
    public ArrayList<Apartment> findApartmentWithLocation(Cities location) {
        ArrayList<Apartment> apartmentsFound = new ArrayList<>();
        for (Apartment apartment : this.apartments) {
            if (location==apartment.getLocation()) {
                apartmentsFound.add(apartment);
            }
        }
        if (apartmentsFound.isEmpty()) {
            throw new LocationException();
        }
        return apartmentsFound;
    }

    public boolean numberRooms(int rooms, int apartmentRooms) {
        boolean match = false;
        if (rooms <= 0) {
            throw new RoomException();
        } else {
            if (rooms == apartmentRooms) {
                match = true;
            }
        }
        return match;
    }

    public boolean compareAmount(Apartment apartment, Customer customer) {
        boolean compare = false;
        if (customer.getAmount() < 0) {
            throw new AmountException();
        } else {
            if (customer.getAmount() >= checkCurrencyForCustomer(apartment, customer)) {
                compare = true;
            }
        }
        return compare;
    }

    public double checkCurrencyForCustomer(Apartment apartment, Customer customer){
        double priceOfApartment;
        if (apartment.getCurrency()==customer.getCurrency()){
            priceOfApartment = apartment.getPrice();
        } else {
            priceOfApartment = Currency.convertCurrency(apartment, customer);
        }
        return priceOfApartment;
    }

    public boolean existsApartment(int idApartment, ArrayList<Apartment> apartments){
        boolean exists = false;
        for (Apartment apartment:
             apartments) {
            if (idApartment == apartment.getIdApartment()) {
                exists = true;
                break;
            }
        }
        if(!exists){
            throw new WrongIdApartmentException();
        }
        return exists;
    }

    @Override
    public void makeBuyContract(Customer customer, int idApartment, Agent agent, PaymentMethods method) throws RoomException,
            AmountException, WrongIdApartmentException {
        Apartment thisApartment = this.findApartmentWithId(idApartment);
        if (existsApartment(idApartment, this.getApartments())){
            if (thisApartment.getAvailable()
                    && thisApartment.getRentOrBuy() == IBuyContract.TYPE_OF_CONTRACT
                    && this.compareAmount(this.findApartmentWithId(idApartment),customer)) {
                Contract contract = new Contract(thisApartment.getIdApartment(),
                        thisApartment.getOwner().getFirstName() + " " + thisApartment.getOwner().getLastName(),
                        agent.getFirstName() + " " + agent.getLastName(), agent.getIdAgent(),
                        customer.getFirstName() + " " + customer.getLastName(), customer.getIdClient());
                LOGGER.info("Customer " + customer.getFirstName() + " " + customer.getLastName()
                        + " ID: " + customer.getIdClient()
                        + " bought the apartment ID " + thisApartment.getIdApartment()
                        + " to the owner " + thisApartment.getOwner()
                        + ", throw the agent " + agent.getFirstName()
                        + " " + agent.getLastName()
                        + " ID: " + agent.getIdAgent()
                        + " Contract ID: " + contract.getIdContract()
                        + " Date of the Contract: " + contract.getDateOfContract()
                        + " Payment method: " + method
                );
                this.addContract(contract);
                agent.setSaleCommission((thisApartment.getPrice() * agent.getPercentageSaleCommission()) / 100);
                this.findApartmentWithId(idApartment).setOwner(customer);
                customer.addApartments(this.findApartmentWithId(idApartment));
                this.findApartmentWithId(idApartment).setAvailable(false);
                agent.setSaleContractsCounter();
            } else {
                LOGGER.info("Apartment not available or not for sale");
            }
        } else {
            LOGGER.info("Apartment does not exists");
        }
    }

    @Override
    public void makeRentContract(Customer customer, int idApartment, Agent agent, PaymentMethods method) throws RoomException,
            AmountException, WrongIdApartmentException {
        Apartment thisApartment = this.findApartmentWithId(idApartment);
        if (existsApartment(idApartment, this.getApartments())){
            if (thisApartment.getAvailable()
                    && thisApartment.getRentOrBuy() == IRentContract.TYPE_OF_CONTRACT
                    && this.compareAmount(this.findApartmentWithId(idApartment),customer)) {
                Contract contract = new Contract(thisApartment.getIdApartment(),
                        thisApartment.getOwner().getFirstName() + " " + thisApartment.getOwner().getLastName(),
                        agent.getFirstName() + " " + agent.getLastName(), agent.getIdAgent(),
                        customer.getFirstName() + " " + customer.getLastName(), customer.getIdClient());
                LOGGER.info("Customer " + customer.getFirstName() + " " + customer.getLastName()
                        + " ID: " + customer.getIdClient()
                        + " rented the apartment ID " + thisApartment.getIdApartment()
                        + " to the owner " + thisApartment.getOwner().getFirstName()
                        + " " + thisApartment.getOwner().getLastName()
                        + ", throw the agent " + agent.getFirstName()
                        + " " + agent.getLastName()
                        + " ID: " + agent.getIdAgent()
                        + " Contract ID: " + contract.getIdContract()
                        + " Date of the Contract: " + contract.getDateOfContract()
                        + " Payment method: " + method
                );
                this.addContract(contract);
                agent.setRentCommission((thisApartment.getPrice() * agent.getPercentageRentCommission()) / 100);
                this.findApartmentWithId(idApartment).setAvailable(false);
                agent.setRentContractsCounter();
            } else {
                LOGGER.info("Apartment not available or not for sale");
            }
        } else {
            LOGGER.info("Apartment does not exists");
        }
    }


    public void addContract(Contract... contracts) {
        for (Contract contract:
                contracts) {
            this.contracts.insert(contract);
        }
    }


    public void addApartment(Apartment... apartments) {
        this.apartments.addAll(Arrays.asList(apartments));
    }

    public void addCustomer(Customer... customers) {
        Collections.addAll(this.customers, customers);
    }

    public void addAgent(Agent... agents) {
        this.agents.addAll(Arrays.asList(agents));
    }

    public void addOwner(Owner... owners) {
        Collections.addAll(this.owners, owners);
    }

    public ArrayList<Apartment> getApartments() {
        return apartments;
    }

    public void removeApartment(int idApartment) {
        apartments.removeIf(apartment -> idApartment == apartment.getIdApartment());
    }

    public void showApartments(ArrayList<Apartment> apartments, Printable<List> printer) {
        printer.print(apartments);
    }

    public void showCustomers() {
        customers.forEach(customer -> LOGGER.info(customer.toString()));
    }

    public void showOwners() {
        owners.forEach(owner -> LOGGER.info(owner.toString()));
    }

    public void showAgents() {
        agents.forEach(agent -> LOGGER.info(agent.toString()));
    }

    public void showContracts() {
        LOGGER.info(contracts.show());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        try {
            checkStringField(name);
            this.name = name;
        } catch (StringFieldException e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        try {
            checkNumberField(phoneNumber);
            this.phoneNumber = phoneNumber;
        } catch (NumberFieldException e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    public int getPercentageForBuyContract() {
        return percentageForBuyContract;
    }

    public void setPercentageForBuyContract(int percentageForBuyContract) {
        this.percentageForBuyContract = percentageForBuyContract;
    }

    public int getPercentageForRentContract() {
        return percentageForRentContract;
    }

    public void setPercentageForRentContract(int percentageForRentContract) {
        this.percentageForRentContract = percentageForRentContract;
    }

    public int getProfitsPerBuyContract() {
        return profitsPerBuyContract;
    }

    public void setProfitsPerBuyContract(int profitsPerBuyContract) {
        this.profitsPerBuyContract = profitsPerBuyContract;
    }

    public int getProfitsPerRentContract() {
        return profitsPerRentContract;
    }

    public void setProfitsPerRentContract(int profitsPerRentContract) {
        this.profitsPerRentContract = profitsPerRentContract;
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

    @Override
    public void checkNumberField(String number) {
        if (number.chars().anyMatch(Character::isAlphabetic)) {
            throw new NumberFieldException();
        }
    }

    @Override
    public void checkStringField(String field) {
        if (field.chars().anyMatch(Character::isDigit)) {
            throw new StringFieldException();
        }
    }
}

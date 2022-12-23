package com.solvd.agency.business;


import com.solvd.agency.exceptions.*;
import com.solvd.agency.interfaces.*;
import com.solvd.agency.persons.Agent;
import com.solvd.agency.persons.Customer;
import com.solvd.agency.persons.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.*;


public final class Agency implements IBuySearch, IRentSearch, IBuyContract, IRentContract, IGetApartment, ICheckNumberField, ICheckStringField {
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Apartment> apartments = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Agent> agents = new ArrayList<>();
    private ArrayList<Owner> owners = new ArrayList<>();
    private ArrayList<Contract> contracts = new ArrayList<>();

    public static final Logger LOGGER = (Logger) LogManager.getLogger(Agency.class);


    public Agency(String name, String address, String phoneNumber) {
        setName(name);
        this.address = address;
        setPhoneNumber(phoneNumber);
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
    public ArrayList<Apartment> findApartmentWithLocation(String location) {
        ArrayList<Apartment> apartmentsFound = new ArrayList<>();
        for (Apartment apartment : this.apartments) {
            if (location.toLowerCase().equals(apartment.getLocation())) {
                apartmentsFound.add(apartment);
            }
        }
        if (apartmentsFound.isEmpty()) {
            throw new LocationException();
        }
        return apartmentsFound;
    }

    public boolean apartmentFound(String location, Apartment apartment) {
        boolean apartmentFound = location.toLowerCase().equals(apartment.getLocation());
        if (!apartmentFound) {
            throw new LocationException();
        }
        return apartmentFound;
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

    public boolean compareAmount(float amount, float apartmentPrice) {
        boolean compare = false;
        if (amount < 0) {
            throw new AmountException();
        } else {
            if (amount >= apartmentPrice) {
                compare = true;
            }
        }
        return compare;
    }

    @Override
    public void makeBuyContract(Customer customer, int idApartment, Agent agent) throws RoomException, AmountException {
        Apartment thisApartment = this.findApartmentWithId(idApartment);
        if (thisApartment.getAvailable() && thisApartment.getRentOrBuy() == IBuyContract.TYPE_OF_CONTRACT) {
            if (this.compareAmount(customer.getAmount(), thisApartment.getPrice())) {
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
                );
                this.addContract(contract);
                agent.setSaleCommission((thisApartment.getPrice() * agent.getPercentageSaleCommission()) / 100);
                this.removeApartment(idApartment);
            }
        } else {
            LOGGER.info("Apartment not available or not for sale");
        }
    }

    @Override
    public void makeRentContract(Customer customer, int idApartment, Agent agent) throws RoomException, AmountException {
        Apartment thisApartment = this.findApartmentWithId(idApartment);
        if (thisApartment.getAvailable() &&
                thisApartment.getRentOrBuy() == IRentContract.TYPE_OF_CONTRACT) {
            if (this.compareAmount(customer.getAmount(), thisApartment.getPrice())) {
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
                );
                this.addContract(contract);
                agent.setRentCommission((thisApartment.getPrice() * agent.getPercentageRentCommission()) / 100);
                this.removeApartment(idApartment);
            }
        } else {
            LOGGER.info("Apartment not available or not for sale");
        }
    }

    @Override
    public void buySearch(int rooms, String location, Customer customer) {
        int o = 1;
        try {
            int i = 0;
            for (Apartment apartment : this.apartments) {
                if (apartment.getAvailable()) {
                    if (this.numberRooms(rooms, apartment.getNumberRooms())) {
                        if (this.compareAmount(customer.getAmount(), apartment.getPrice())) {
                            if (this.apartmentFound(location, apartment)) {
                                if (apartment.getRentOrBuy() == RentOrBuy.FOR_BUY) {
                                    LOGGER.info("Coincidence for buy " + (o++));
                                    LOGGER.info(apartment);
                                    i++;
                                }
                            }
                        }
                    }
                }
            }
            if (i == 0) {
                LOGGER.info("There is no apartments for buy available with this number " +
                        "of rooms, location or amount");
            }
        } catch (RoomException | AmountException | LocationException e) {
            LOGGER.warn(e.getMessage());
        }

    }

    @Override
    public void rentSearch(int rooms, String location, Customer customer) {
        int o = 1;
        try {
            int i = 0;
            for (Apartment apartment : this.apartments) {
                if (apartment.getAvailable()) {
                    if (this.numberRooms(rooms, apartment.getNumberRooms())) {
                        if (this.compareAmount(customer.getAmount(), apartment.getPrice())) {
                            if (this.apartmentFound(location, apartment)) {
                                if (apartment.getRentOrBuy() == RentOrBuy.FOR_RENT) {
                                    LOGGER.info("Coincidence for rent " + (o++));
                                    LOGGER.info(apartment);
                                    i++;
                                }
                            }
                        }
                    }
                }
            }
            if (i == 0) {
                LOGGER.info("There is no apartments for rent available with this number " +
                        "of rooms, location or amount");
            }
        } catch (RoomException | AmountException | LocationException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public void addContract(Contract... contracts) {
        this.contracts.addAll(Arrays.asList(contracts));
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

    public void showApartments() {
        for (Apartment apartment : apartments) {
            LOGGER.info(apartment + " ");
        }
    }

    public void showCustomers() {
        for (Customer customer : customers) {
            LOGGER.info(customer + " ");
        }
    }

    public void showOwners() {
        for (Owner owner : owners) {
            LOGGER.info(owner + " ");
        }
    }

    public void showAgents() {
        for (Agent agent : agents) {
            LOGGER.info(agent + " ");
        }
    }

    public void showContracts() {
        for (Contract contract : contracts) {
            LOGGER.info(contract + " ");
        }
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

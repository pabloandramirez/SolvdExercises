package solvd.agency.src.contracts;

import solvd.agency.src.business.Agency;
import solvd.agency.src.business.Apartment;
import solvd.agency.src.business.RentOrBuy;
import solvd.agency.src.interfaces.IContract;
import solvd.agency.src.persons.Agent;
import solvd.agency.src.persons.Customer;
import solvd.agency.src.persons.Owner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RentContract implements IContract {

    private final int idRentContract;

    public static int idCounter;

    private final String dateOfContract;
    public static final RentOrBuy TYPE_OF_CONTRACT = RentOrBuy.FOR_RENT;

    public RentContract() {
        this.idRentContract = ++idCounter;
        this.dateOfContract = dateFormatter(LocalDate.now());
    }

    public String dateFormatter(LocalDate dateOfContract){
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return dateOfContract.format(myFormat);
    }

    public void getIdRentContract() {
        System.out.println("The ID of this rent contract is: " + this.idRentContract);
    }

    public void getDateOfContract() {
        System.out.println("The date of this rent contract is: " + this.dateOfContract);
    }

    @Override
    public void iContract(Customer customer, Apartment apartment, Agent agent, Owner owner, Agency agency) {
        if (apartment.getAvailable() && apartment.getRentOrBuy() == TYPE_OF_CONTRACT){
            if (customer.getAmount() >= apartment.getPrice()) {
                System.out.println("Customer " + customer.getFirstName() + " " + customer.getLastName()
                        + " ID: " + customer.getIdClient()
                        + " rented the apartment ID " + apartment.getIdApartment()
                        + " to the owner " + apartment.getOwner()
                        + ", throw the agent " + agent.getFirstName()
                        + " " + agent.getLastName()
                        + " ID: " + agent.getIdAgent()
                        + apartment
                );
                agent.setSaleCommission((apartment.getPrice() * agent.getPercentageSaleCommission())/100);
                agency.getApartments().remove(apartment);
                apartment.setAvailable(false);
            }
        } else{
            System.out.println("Apartment not available or not for rent");
        }
    }


    @Override
    public String toString() {
        return "RentContract{" +
                "idRentContract=" + idRentContract +
                ", dateOfContract=" + dateOfContract +
                '}';
    }


}
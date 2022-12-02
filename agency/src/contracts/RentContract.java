package solvd.agency.src.contracts;

import solvd.agency.src.business.RentOrBuy;
import solvd.agency.src.persons.Agent;
import solvd.agency.src.business.Apartment;
import solvd.agency.src.persons.Customer;

public class RentContract extends Contract {

    public RentContract(Customer customer, Apartment apartment, Agent agent){
        super(customer, apartment, agent);
    }


    public void checkAvailable(Apartment apartment, RentOrBuy rentOrBuy){
        if (apartment.getAvailable() && rentOrBuy == RentOrBuy.ForRent){
            super.getAgent().setRentCommission((apartment.getPrice() * super.getAgent().getPercentageRentCommission())/100);
            apartment.setAvailable(false);
        } else{
            System.out.println("Apartment not available");
        }
    }

    @Override
    public String toString() {
        return "RentContract{" +
                ", contract=" + super.toString() +
                '}';
    }
}

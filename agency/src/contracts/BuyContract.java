package solvd.agency.src.contracts;

import solvd.agency.src.business.Apartment;
import solvd.agency.src.business.RentOrBuy;
import solvd.agency.src.persons.Agent;
import solvd.agency.src.persons.Customer;

public class BuyContract extends Contract {

    public BuyContract(Customer customer, Apartment apartment, Agent agent){
        super(customer, apartment, agent);
    }

    @Override
    void checkAvailable(Apartment apartment, RentOrBuy rentOrBuy){
        if (apartment.getAvailable() && rentOrBuy == RentOrBuy.ForBuy){
            super.getAgent().setSaleCommission((apartment.getPrice() * super.getAgent().getPercentageSaleCommission())/100);
            apartment.setAvailable(false);
        } else{
            System.out.println("Apartment not available");
        }
    }
    @Override
    public String toString() {
        return "BuyContract{" +
                ", contract=" + super.toString() +
                '}';
    }
}
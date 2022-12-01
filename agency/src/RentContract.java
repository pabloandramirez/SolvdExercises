package solvd.agency.src;

public class RentContract extends Contract{

    public RentContract(Customer customer, int idApartment, Agent agent){
        super(customer, idApartment, agent);
        checkAvailable(agent);
    }


    public void checkAvailable(Agent agent){
        if (agent.getAgency().getApartments()[super.getIdApartment()-1].getAvailable()){
            super.getAgent().setRentCommission((agent.getAgency().getApartments()[super.getIdApartment()-1].getPrice() * agent.getPercentageRentCommission())/100);
            agent.getAgency().getApartments()[super.getIdApartment()-1].setAvailable(false);
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

package solvd.agency.src;

public class SaleContract extends Contract{

    public SaleContract(Customer customer, int idApartment, Agent agent){
        super(customer, idApartment, agent);
        checkAvailable(agent);
    }

    public void checkAvailable(Agent agent){
        if (agent.getAgency().getApartments()[super.getIdApartment()-1].getAvailable()){
            super.getAgent().setSaleCommission((agent.getAgency().getApartments()[super.getIdApartment()-1].getPrice() * agent.getPercentageSaleCommission())/100);
            agent.getAgency().getApartments()[super.getIdApartment()-1].setAvailable(false);
        } else{
            System.out.println("Apartment not available");
        }
    }
    @Override
    public String toString() {
        return "SaleContract{" +
                ", contract=" + super.toString() +
                '}';
    }
}

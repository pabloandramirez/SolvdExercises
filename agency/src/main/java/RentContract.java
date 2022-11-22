public class RentContract extends Contract{
    private int idContract;
    private static int contractCounter;
    private Agency agency;

    public RentContract(Customer customer, int idApartment, Agent agent){
        super(customer, idApartment, agent);
        this.idContract = ++RentContract.contractCounter;
        if (agent.getAgency().getApartments()[idApartment-1].getAvailable()){
            super.getAgent().setRentCommission((agent.getAgency().getApartments()[idApartment-1].getPrice() * agent.getPercentageRentCommission())/100);
            agent.getAgency().getApartments()[idApartment-1].setAvailable(false);
        } else{
            System.out.println("Apartment not available");
        }

    }

    public int getIdContract() {
        return idContract;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @Override
    public String toString() {
        return "RentContract{" +
                "idContract=" + idContract +
                ", agency=" + agency +
                ", contract=" + super.toString() +
                '}';
    }
}

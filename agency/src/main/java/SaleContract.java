public class SaleContract extends Contract{
    private int idSale;
    private static int saleCounter;
    private Agency agency;


    public SaleContract(Customer customer, int idApartment, Agent agent){
        super(customer, idApartment, agent);
        this.idSale = ++SaleContract.saleCounter;
        super.getAgent().setSaleCommission((agent.getAgency().getApartments()[idApartment-1].getPrice()*agent.getPercentageSaleCommission()) / 100);
        agent.getAgency().getApartments()[idApartment-1].setAvailable(false);
    }

    public int getIdSale() {
        return idSale;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @Override
    public String toString() {
        return "SaleContract{" +
                "idSale=" + idSale +
                ", agency=" + agency +
                ", contract=" + super.toString() +
                '}';
    }
}

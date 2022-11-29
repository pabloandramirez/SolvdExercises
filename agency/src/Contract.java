package solvd.agency.src;

abstract class Contract {
    private int idContract;
    private Customer customer;
    private int idApartment;
    private Agent agent;
    private static int idCounter;

    public Contract(Customer customer, int idApartment, Agent agent) {
        this.idContract = ++Contract.idCounter;
        this.customer = customer;
        this.idApartment = idApartment;
        this.agent = agent;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getIdApartment() {
        return idApartment;
    }

    public void setIdApartment(int idApartment) {
        this.idApartment = idApartment;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public int getIdContract() {
        return idContract;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "customer=" + customer +
                ", idApartment=" + idApartment +
                ", agent=" + agent +
                '}';
    }
}

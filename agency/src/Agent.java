package solvd.agency.src;

public class Agent extends Person{
    private int idAgent;
    private float saleCommission;
    private float rentCommission;
    private static int idCounter;
    private Agency agency;
    private float percentageSaleCommission;
    private float percentageRentCommission;

    public Agent(String firstName, String lastName, long phoneNumber, Agency agency, float percentageSaleCommission, float percentageRentCommission){
        super(firstName, lastName, phoneNumber);
        this.idAgent = ++Agent.idCounter;
        this.agency = agency;
        this.percentageRentCommission = percentageRentCommission;
        this.percentageSaleCommission = percentageSaleCommission;
    }

    public float getRentCommission() {
        return rentCommission;
    }

    public void setRentCommission(float rentCommission) {
        this.rentCommission = rentCommission;
    }

    public float getSaleCommission() {
        return saleCommission;
    }

    public void setSaleCommission(float saleCommission) {
        this.saleCommission = saleCommission;
    }


    public int getIdAgent() {
        return this.idAgent;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public float getPercentageSaleCommission() {
        return percentageSaleCommission;
    }

    public void setPercentageSaleCommission(float percentageSaleCommission) {
        this.percentageSaleCommission = percentageSaleCommission;
    }

    public float getPercentageRentCommission() {
        return percentageRentCommission;
    }

    public void setPercentageRentCommission(float percentageRentCommission) {
        this.percentageRentCommission = percentageRentCommission;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "idAgent=" + idAgent +
                ", saleCommission=" + saleCommission +
                ", rentCommission=" + rentCommission +
                ", agency=" + agency +
                ", percentageSaleCommission=" + percentageSaleCommission +
                ", percentageRentCommission=" + percentageRentCommission +
                ", person=" + super.toString() +
                '}';
    }
}

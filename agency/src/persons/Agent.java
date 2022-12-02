package solvd.agency.src.persons;

import solvd.agency.src.persons.Person;

public class Agent extends Person {
    private int idAgent;
    private float saleCommission;
    private float rentCommission;
    private static int idCounter;
    private float percentageSaleCommission;
    private float percentageRentCommission;

    public Agent(String firstName, String lastName, long phoneNumber, float percentageSaleCommission, float percentageRentCommission){
        super(firstName, lastName, phoneNumber);
        this.idAgent = ++Agent.idCounter;
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
                ", percentageSaleCommission=" + percentageSaleCommission +
                ", percentageRentCommission=" + percentageRentCommission +
                ", person=" + super.toString() +
                '}';
    }
}

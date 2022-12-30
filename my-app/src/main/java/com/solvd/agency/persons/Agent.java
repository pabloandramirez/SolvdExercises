package com.solvd.agency.persons;

import java.util.Objects;

public final class Agent extends Person {
    private final int idAgent;
    private float saleCommission;
    private float rentCommission;
    private static int idCounter;
    private float percentageSaleCommission;
    private float percentageRentCommission;

    public Agent(String firstName, String lastName, String phoneNumber, float percentageSaleCommission, float percentageRentCommission) {
        super(firstName, lastName, phoneNumber);
        this.idAgent = ++Agent.idCounter;
        this.percentageRentCommission = percentageRentCommission;
        this.percentageSaleCommission = percentageSaleCommission;
    }

    public float getRentCommission() {
        return rentCommission;
    }

    public void setRentCommission(float rentCommission) {
        this.rentCommission += rentCommission;
    }

    public float getSaleCommission() {
        return saleCommission;
    }

    public void setSaleCommission(float saleCommission) {
        this.saleCommission += saleCommission;
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
                ", percentageSaleCommission=" + percentageSaleCommission +
                ", percentageRentCommission=" + percentageRentCommission +
                ", saleCommission=" + saleCommission +
                ", rentCommission=" + rentCommission +
                ", person=" + super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Agent agent = (Agent) o;
        return idAgent == agent.idAgent && Float.compare(agent.saleCommission, saleCommission) == 0 &&
                Float.compare(agent.rentCommission, rentCommission) == 0 &&
                Float.compare(agent.percentageSaleCommission, percentageSaleCommission) == 0 &&
                Float.compare(agent.percentageRentCommission, percentageRentCommission) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idAgent, saleCommission, rentCommission, percentageSaleCommission, percentageRentCommission);
    }

}

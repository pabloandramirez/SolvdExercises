package com.solvd.agency.business;

import com.solvd.agency.interfaces.IDateFormatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Contract implements IDateFormatter {
    private final int idContract;
    private int idApartment;
    private String ownerFullName;
    private String agentFullName;
    private int idAgent;
    private String customerFullName;
    private int idCustomer;

    public static int idCounter;

    private final String dateOfContract;

    public Contract(int idApartment, String ownerFullName, String agentFullName, int idAgent, String customerFullName, int idCustomer) {
        this.idApartment = idApartment;
        this.ownerFullName = ownerFullName;
        this.agentFullName = agentFullName;
        this.idAgent = idAgent;
        this.customerFullName = customerFullName;
        this.idCustomer = idCustomer;
        this.idContract = ++Contract.idCounter;
        this.dateOfContract = dateFormatter(LocalDate.now());
    }

    public String getIdContract() {
        return "" + idContract;
    }

    public String getDateOfContract() {
        return "" + dateOfContract;
    }

    public int getIdApartment() {
        return idApartment;
    }

    public void setIdApartment(int idApartment) {
        this.idApartment = idApartment;
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }

    public void setOwnerFullName(String ownerFullName) {
        this.ownerFullName = ownerFullName;
    }

    public String getAgentFullName() {
        return agentFullName;
    }

    public void setAgentFullName(String agentFullName) {
        this.agentFullName = agentFullName;
    }

    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public String dateFormatter(LocalDate dateOfContract) {
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return dateOfContract.format(myFormat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return idContract == contract.idContract && dateOfContract.equals(contract.dateOfContract);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContract, dateOfContract);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "idContract=" + idContract +
                ", idApartment=" + idApartment +
                ", ownerFullName='" + ownerFullName + '\'' +
                ", agentFullName='" + agentFullName + '\'' +
                ", idAgent=" + idAgent +
                ", customerFullName='" + customerFullName + '\'' +
                ", idCustomer=" + idCustomer +
                ", dateOfContract='" + dateOfContract + '\'' +
                '}';
    }
}

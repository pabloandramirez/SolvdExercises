package com.solvd.agency.business;

import com.solvd.agency.interfaces.IDateFormatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Contract implements IDateFormatter{
    private final int idRentContract;

    public static int idCounter;

    private final String dateOfContract;

    public Contract(){
        this.idRentContract = ++Contract.idCounter;
        this.dateOfContract = dateFormatter(LocalDate.now());
    }

    public String getIdContract() {
        return "" + idRentContract;
    }

    public String getDateOfContract() {
        return "" + dateOfContract;
    }

    @Override
    public String dateFormatter(LocalDate dateOfContract){
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return dateOfContract.format(myFormat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return idRentContract == contract.idRentContract && dateOfContract.equals(contract.dateOfContract);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRentContract, dateOfContract);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "idRentContract=" + idRentContract +
                ", dateOfContract='" + dateOfContract + '\'' +
                '}';
    }
}

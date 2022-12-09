package solvd.agency.src.persons;

import solvd.agency.src.business.Apartment;

import java.util.Objects;

public final class Owner extends Person {
    private int idOwner;
    private static int idCounter;
    private int apartmentCounter;

    public Owner(String firstName, String lastName, long phoneNumber){
        super(firstName, lastName, phoneNumber);
        this.idOwner = ++Owner.idCounter;
    }

    public int getIdOwner() {
        return idOwner;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "idOwner=" + idOwner +
                ", person=" + super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Owner owner = (Owner) o;
        return idOwner == owner.idOwner && apartmentCounter == owner.apartmentCounter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idOwner, apartmentCounter);
    }
}

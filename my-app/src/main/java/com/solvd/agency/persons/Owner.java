package com.solvd.agency.persons;


import java.util.Objects;

public final class Owner extends Person {
    private final int idOwner;
    private static int idCounter;

    public Owner(String firstName, String lastName, String phoneNumber) {
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
        return idOwner == owner.idOwner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idOwner);
    }
}

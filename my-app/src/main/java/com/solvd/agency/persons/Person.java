package com.solvd.agency.persons;

import com.solvd.agency.exceptions.FieldException;
import com.solvd.agency.interfaces.ICheckStringField;

import java.util.Objects;

import static com.solvd.agency.business.Agency.LOGGER;

abstract class Person implements ICheckStringField {
    private String firstName;
    private String lastName;
    private long phoneNumber;

    public Person(String firstName, String lastName, long phoneNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        try {
            checkStringField(firstName);
            this.firstName = firstName;
        } catch (FieldException e){
            LOGGER.warn(e.getMessage(), e);
        }
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        try {
            checkStringField(lastName);
            this.lastName = lastName;
        } catch (FieldException e){
            LOGGER.warn(e.getMessage(), e);
        }
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void checkStringField(String field){
        if (field.chars().anyMatch(Character::isDigit)){
            throw new FieldException();
        }
    }


    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return phoneNumber == person.phoneNumber && firstName.equals(person.firstName) && lastName.equals(person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber);
    }

}

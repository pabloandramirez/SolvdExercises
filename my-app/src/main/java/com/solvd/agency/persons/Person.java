package com.solvd.agency.persons;

import com.solvd.agency.exceptions.NumberFieldException;
import com.solvd.agency.exceptions.StringFieldException;
import com.solvd.agency.interfaces.ICheckNumberField;
import com.solvd.agency.interfaces.ICheckStringField;

import java.util.Objects;

import static com.solvd.agency.business.Agency.LOGGER;

abstract class Person implements ICheckStringField, ICheckNumberField {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Person(String firstName, String lastName, String phoneNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        try {
            checkStringField(firstName);
            this.firstName = firstName;
        } catch (StringFieldException e){
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
        } catch (StringFieldException e){
            LOGGER.warn(e.getMessage(), e);
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        try {
            checkNumberField(phoneNumber);
            this.phoneNumber = phoneNumber;
        } catch (NumberFieldException e){
            LOGGER.warn(e.getMessage(), e);
        }
    }

    @Override
    public void checkNumberField(String number){
        if (number.chars().anyMatch(Character::isAlphabetic)){
            throw new NumberFieldException();
        }
    }

    @Override
    public void checkStringField(String field){
        if (field.chars().anyMatch(Character::isDigit)){
            throw new StringFieldException();
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

package com.solvd.agency.persons;

import com.solvd.agency.exceptions.NullFieldException;
import com.solvd.agency.exceptions.NumberFieldException;
import com.solvd.agency.exceptions.StringFieldException;
import com.solvd.agency.interfaces.ICheckField;
import com.solvd.agency.interfaces.ICheckNumberField;
import com.solvd.agency.interfaces.ICheckStringField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;


public abstract class Person implements ICheckStringField, ICheckNumberField, ICheckField {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private static final Logger LOGGER = LogManager.getLogger(Person.class);


    public Person(String firstName, String lastName, String phoneNumber) {
        try {
            setFirstName(firstName);
            setLastName(lastName);
            setPhoneNumber(phoneNumber);
            checkNoNullsFields();
        } catch (NullFieldException e){
            LOGGER.warn(e.getMessage());
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        try {
            checkStringField(firstName);
            this.firstName = firstName;
        } catch (StringFieldException e) {
            LOGGER.warn(e.getMessage());
        }
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        try {
            checkStringField(lastName);
            this.lastName = lastName;
        } catch (StringFieldException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        try {
            checkNumberField(phoneNumber);
            this.phoneNumber = phoneNumber;
        } catch (NumberFieldException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    @Override
    public void checkNumberField(String number) {
        if (number.chars().anyMatch(Character::isAlphabetic)) {
            throw new NumberFieldException();
        }
    }

    @Override
    public void checkNoNullsFields() {
        if (Objects.isNull(this.getFirstName()) || Objects.isNull(this.getLastName()) || Objects.isNull(this.getPhoneNumber())) {
            throw new NullFieldException();
        }
    }

    @Override
    public void checkStringField(String field) {
        if (field.chars().anyMatch(Character::isDigit)) {
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
        return Objects.equals(phoneNumber, person.phoneNumber) && firstName.equals(person.firstName) && lastName.equals(person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber);
    }

}

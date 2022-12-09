package solvd.agency.src.interfaces;

import solvd.agency.src.persons.Customer;


public interface IRentSearch {
    void rentSearch(int rooms, String location, Customer customer);
}

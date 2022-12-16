package com.solvd.agency.interfaces;

import com.solvd.agency.persons.Customer;


public interface IRentSearch {
    void rentSearch(int rooms, String location, Customer customer);
}

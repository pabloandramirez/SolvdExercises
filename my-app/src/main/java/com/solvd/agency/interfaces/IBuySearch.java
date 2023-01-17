package com.solvd.agency.interfaces;

import com.solvd.agency.persons.Customer;

@FunctionalInterface
public interface IBuySearch {

    void buySearch(int rooms, String location, Customer customer);

}

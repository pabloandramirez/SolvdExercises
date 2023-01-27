package com.solvd.agency.lambdas;

@FunctionalInterface
public interface ISearchApartment<Apartment, Customer> {

    boolean searchApartment(Apartment apartment, Customer customer);

}

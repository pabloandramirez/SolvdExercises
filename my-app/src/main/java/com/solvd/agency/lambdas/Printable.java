package com.solvd.agency.lambdas;

@FunctionalInterface
public interface Printable<T> {

    void print(T t);
}

package com.solvd.agency.interfaces;

import java.time.LocalDate;
@FunctionalInterface
public interface IDateFormatter {

    String dateFormatter(LocalDate dateOfContract);
}

package com.artiomastashonak.schoolaccountingstudio.interests;

import java.time.Duration;
import java.time.LocalDate;

public class InterestHandler {

    private double capital = 0;
    private long days = 0;
    private long months = 0;
    private long years = 0;
    private double quote = 0;
    private boolean isLeapYear = false;

    public InterestHandler() { }

    public double calculate() {

        return 1;
    }

    public void reset() {
        this.days = 0;
        this.months = 0;
        this.years = 0;
        this.quote = 0;
        this.isLeapYear = false;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public long getDays() {
        return days;
    }

    public void setDays(long days) {
        this.days = days;
    }

    public void setDays(LocalDate initDate, LocalDate endDate) {
        this.days = Duration.between(initDate, endDate).toDays();
    }

    public long getMonths() {
        return months;
    }

    public void setMonths(long months) {
        this.months = months;
    }

    public void setMonths(LocalDate initDate, LocalDate endDate) {
        this.months = Duration.between(initDate, endDate).toDays() / 30;
    }

    public long getYears() {
        return years;
    }

    public void setYears(long years) {
        this.years = years;
    }

    public void setYears(LocalDate initDate, LocalDate endDate) {
        this.years = Duration.between(initDate, endDate).toDays() / 365;
    }

    public double getQuote() {
        return quote;
    }

    public void setQuote(double quote) {
        this.quote = quote;
    }

    public boolean isLeapYear() {
        return isLeapYear;
    }

    public void setLeapYear(boolean isLeapYear) {
        this.isLeapYear = isLeapYear;
    }
}
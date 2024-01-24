package com.artiomastashonak.schoolaccountingstudio.discount;

public class PresentValueHandler {

    private final int DAYS_CALCULATION_MODE = 0;
    private final int MONTHS_CALCULATION_MODE = 1;
    private final int YEARS_CALCULATION_MODE = 2;
    private final int CALCULATION_ERROR = -1;

    private double capital = 0;
    private long time = 0;
    private double quote = 0;
    private double presentValue = 0;
    private boolean isLeapYear = false;

    public PresentValueHandler() { }

    public double calculate(int mode) {
        if (capital == 0) return calculateCapital(mode);
        if (time == 0) return calculateTime(mode);
        if (quote == 0) return calculateQuote(mode);
        if (presentValue == 0) return calculatePresentValue(mode);
        return CALCULATION_ERROR;
    }

    private double calculatePresentValue(int mode) {
        if (mode == DAYS_CALCULATION_MODE) {
            if (isLeapYear) return Math.round(((capital * (36600 - time * quote)) / 36600) * 100.0) / 100.0;
            return Math.round(((capital * (36500 - time * quote)) / 36500) * 100.0) / 100.0;
        }
        if (mode == MONTHS_CALCULATION_MODE) return Math.round(((capital * (1200 - time * quote)) / 1200) * 100.0) / 100.0;
        if (mode == YEARS_CALCULATION_MODE) return Math.round(((capital * (100 - time * quote)) / 100) * 100.0) / 100.0;
        return CALCULATION_ERROR;
    }

    private double calculateCapital(int mode) {
        if (mode == DAYS_CALCULATION_MODE) {
            if (isLeapYear) return Math.round(((36600 * presentValue) / (36600 - time * quote)) * 100.0) / 100.0;
            return Math.round(((36500 * presentValue) / (36500 - time * quote)) * 100.0) / 100.0;
        }
        if (mode == MONTHS_CALCULATION_MODE) return Math.round(((1200 * presentValue) / (1200 - time * quote)) * 100.0) / 100.0;
        if (mode == YEARS_CALCULATION_MODE) return Math.round(((100 * presentValue) / (100 - time * quote)) * 100.0) / 100.0;
        return CALCULATION_ERROR;
    }

    private double calculateTime(int mode) {
        if (mode == DAYS_CALCULATION_MODE) {
            if (isLeapYear) return Math.round(((((36600 * presentValue) / capital) - 36600) / -quote) * 100.0) / 100.0;
            return Math.round(((((36500 * presentValue) / capital) - 36500) / -quote) * 100.0) / 100.0;
        }
        if (mode == MONTHS_CALCULATION_MODE) return Math.round(((((1200 * presentValue) / capital) - 1200) / -quote) * 100.0) / 100.0;
        if (mode == YEARS_CALCULATION_MODE) return Math.round(((((100 * presentValue) / capital) - 100) / -quote) * 100.0) / 100.0;
        return CALCULATION_ERROR;
    }

    private double calculateQuote(int mode) {
        if (mode == DAYS_CALCULATION_MODE) {
            if (isLeapYear) return Math.round(((((36600 * presentValue) / capital) - 36600) / -time) * 100.0) / 100.0;
            return Math.round(((((36500 * presentValue) / capital) - 36500) / -time) * 100.0) / 100.0;
        }
        if (mode == MONTHS_CALCULATION_MODE) return Math.round(((((1200 * presentValue) / capital) - 1200) / -time) * 100.0) / 100.0;
        if (mode == YEARS_CALCULATION_MODE) return Math.round(((((100 * presentValue) / capital) - 100) / -time) * 100.0) / 100.0;
        return CALCULATION_ERROR;
    }

    public void reset() {
        this.capital = 0;
        this.time = 0;
        this.quote = 0;
        this.presentValue = 0;
        this.isLeapYear = false;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getQuote() {
        return quote;
    }

    public void setQuote(double quote) {
        this.quote = quote;
    }

    public double getPresentValue() {
        return presentValue;
    }

    public void setPresentValue(double presentValue) {
        this.presentValue = presentValue;
    }

    public boolean isLeapYear() {
        return isLeapYear;
    }

    public void setLeapYear(boolean leapYear) {
        isLeapYear = leapYear;
    }
}
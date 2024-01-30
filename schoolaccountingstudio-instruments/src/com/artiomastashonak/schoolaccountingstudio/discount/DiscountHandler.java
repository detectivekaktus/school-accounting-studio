package com.artiomastashonak.schoolaccountingstudio.discount;

public class DiscountHandler {
  private final int DAYS_CALCULATION_MODE = 0;
  private final int MONTHS_CALCULATION_MODE = 1;
  private final int YEARS_CALCULATION_MODE = 2;
  private final int CALCULATION_ERROR = -1;

  private double capital = 0;
  private long time = 0;
  private double quote = 0;
  private double discount = 0;
  private boolean isLeapYear = false;

  public DiscountHandler() { }

  public double calculate(int mode) {
    if (capital == 0) return calculateCapital(mode);
    if (time == 0) return calculateTime(mode);
    if (quote == 0) return calculateQuote(mode);
    if (discount == 0) return calculateDiscount(mode);
    return CALCULATION_ERROR;
  }

  private double calculateDiscount(int mode) {
    if (mode == DAYS_CALCULATION_MODE) {
      if (isLeapYear) return Math.round(((capital * quote * time) / 36600) * 100.0) / 100.0;
      return Math.round(((capital * quote * time) / 36500) * 100.0) / 100.0;
    }
    if (mode == MONTHS_CALCULATION_MODE) return Math.round(((capital * quote * time) / 1200) * 100.0) / 100.0;
    if (mode == YEARS_CALCULATION_MODE) return Math.round(((capital * quote * time) / 100) * 100.0) / 100.0;
    return CALCULATION_ERROR;
  }

  private double calculateCapital(int mode) {
    if (mode == DAYS_CALCULATION_MODE) {
      if (isLeapYear) return Math.round(((discount * 36600) / (quote * time)) * 100.0) / 100.0;
      return Math.round(((discount * 36500) / (quote * time)) * 100.0) / 100.0;
    }
    if (mode == MONTHS_CALCULATION_MODE) return Math.round(((discount * 1200) / (quote * time)) * 100.0) / 100.0;
    if (mode == YEARS_CALCULATION_MODE) return Math.round(((discount * 100) / (quote * time)) * 100.0) / 100.0;
    return CALCULATION_ERROR;
  }

  private double calculateQuote(int mode) {
    if (mode == DAYS_CALCULATION_MODE) {
      if (isLeapYear) return Math.round(((discount * 36600) / (capital * time)) * 100.0) / 100.0;
      return Math.round(((discount * 36500) / (capital * time)) * 100.0) / 100.0;
    }
    if (mode == MONTHS_CALCULATION_MODE) return Math.round(((discount * 1200) / (capital * time)) * 100.0) / 100.0;
    if (mode == YEARS_CALCULATION_MODE) return Math.round(((discount * 100) / (capital * time)) * 100.0) / 100.0;
    return CALCULATION_ERROR;
  }

  private double calculateTime(int mode) {
    if (mode == DAYS_CALCULATION_MODE) {
      if (isLeapYear) return Math.round(((discount * 36600) / (capital * quote)) * 100.0) / 100.0;
      return Math.round(((discount * 36500) / (capital * quote)) * 100.0) / 100.0;
    }
    if (mode == MONTHS_CALCULATION_MODE) return Math.round(((discount * 1200) / (capital * quote)) * 100.0) / 100.0;
    if (mode == YEARS_CALCULATION_MODE) return Math.round(((discount * 100) / (capital * quote)) * 100.0) / 100.0;
    return CALCULATION_ERROR;
  }

  public void reset() {
    this.time = 0;
    this.quote = 0;
    this.discount = 0;
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

  public double getDiscount() {
    return discount;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }

  public boolean isLeapYear() {
    return isLeapYear;
  }

  public void setLeapYear(boolean isLeapYear) {
    this.isLeapYear = isLeapYear;
  }
}
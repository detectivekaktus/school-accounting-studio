package com.artiomastashonak.schoolaccountingstudio.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PresentValueHandlerTest {
  private long validateTime(String input) {
    String timeRegex = "^((0[1-9]|[1-2]\\d|3[0-1])/(0[1-9]|1[0-2])/(\\d{4}))\\s-\\s((0[1-9]|[1-2]\\d|3[0-1])/(0[1-9]|1[0-2])/(\\d{4}))$";
    Pattern pattern = Pattern.compile(timeRegex);
    Matcher matcher = pattern.matcher(input);
    if (matcher.matches()) {
      LocalDate initDate = LocalDate.of(Integer.parseInt(input.substring(6, 10)), Integer.parseInt(input.substring(3, 5)), Integer.parseInt(input.substring(0, 2)));
      LocalDate endDate = LocalDate.of(Integer.parseInt(input.substring(19, 23)), Integer.parseInt(input.substring(16, 18)), Integer.parseInt(input.substring(13, 15)));
      return ChronoUnit.DAYS.between(initDate, endDate);
    }
    return Long.parseLong(input);
  }

  @DisplayName("Expected result: 17716.05")
  @Test
  void firstPresentValueCalculationTest() {
    PresentValueHandler handler = new PresentValueHandler();
    handler.setCapital(17820);
    handler.setQuote(3.5);
    handler.setTime(2);
    handler.setLeapYear(false);
    Assertions.assertEquals(17716.05, handler.calculate(1));
  }

  @DisplayName("Expected result: 47229.00")
  @Test
  void secondPresentValueCalculationTest() {
    PresentValueHandler handler = new PresentValueHandler();
    handler.setCapital(47580);
    handler.setQuote(4.5);
    handler.setTime(validateTime("11/02/2024 - 11/04/2024"));
    handler.setLeapYear(true);
    Assertions.assertEquals(47229, handler.calculate(0));
  }

  @DisplayName("Expected result: 14575.00")
  @Test
  void thirdPresentValueCalculationTest() {
    PresentValueHandler handler = new PresentValueHandler();
    handler.setCapital(14600);
    handler.setQuote(2.5);
    handler.setTime(validateTime("26/04/2024 - 21/05/2024"));
    handler.setLeapYear(false);
    Assertions.assertEquals(14575, handler.calculate(0));
  }

  @DisplayName("Expected result: 23971.20")
  @Test
  void fourthPresentValueCalculationTest() {
    PresentValueHandler handler = new PresentValueHandler();
    handler.setCapital(24090);
    handler.setQuote(3);
    handler.setTime(validateTime("27/05/2024 - 26/07/2024"));
    handler.setLeapYear(false);
    Assertions.assertEquals(23971.2, handler.calculate(0));
  }

  @DisplayName("Expected result: 13140.00")
  @Test
  void firstCapitalCalculationTest() {
    PresentValueHandler handler = new PresentValueHandler();
    handler.setPresentValue(13056.3);
    handler.setQuote(3.75);
    handler.setTime(validateTime("04/10/2024 - 05/12/2024"));
    handler.setLeapYear(false);
    Assertions.assertEquals(13140, handler.calculate(0));
  }

  @DisplayName("Expected result: 4380.00")
  @Test
  void secondCapitalCalculationTest() {
    PresentValueHandler handler = new PresentValueHandler();
    handler.setPresentValue(4365.6);
    handler.setQuote(3);
    handler.setTime(40);
    handler.setLeapYear(false);
    Assertions.assertEquals(4380, handler.calculate(0));
  }

  @DisplayName("Expected result: 76800.00")
  @Test
  void thirdCapitalCalculationTest() {
    PresentValueHandler handler = new PresentValueHandler();
    handler.setPresentValue(75968);
    handler.setQuote(3.25);
    handler.setTime(4);
    handler.setLeapYear(false);
    Assertions.assertEquals(76800, handler.calculate(1));
  }

  @DisplayName("Expected result: 4")
  @Test
  void firstTimeCalculationTest() {
    PresentValueHandler handler = new PresentValueHandler();
    handler.setCapital(222000);
    handler.setPresentValue(220890);
    handler.setQuote(1.5);
    handler.setLeapYear(false);
    Assertions.assertEquals(4, handler.calculate(1));
  }

  @DisplayName("Expected result: 40")
  @Test
  void secondTimeCalculationTest() {
    PresentValueHandler handler = new PresentValueHandler();
    handler.setCapital(7971.6);
    handler.setPresentValue(7949.76);
    handler.setQuote(2.5);
    handler.setLeapYear(false);
    Assertions.assertEquals(40, handler.calculate(0));
  }

  @DisplayName("Expected result: 4")
  @Test
  void firstQuoteCalculationTest() {
    PresentValueHandler handler = new PresentValueHandler();
    handler.setCapital(23725);
    handler.setPresentValue(23634);
    handler.setTime(validateTime("24/10/2024 - 28/11/2024"));
    handler.setLeapYear(false);
    Assertions.assertEquals(4, handler.calculate(0));
  }
}
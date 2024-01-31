package com.artiomastashonak.schoolaccountingstudio.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DiscountHandlerTest {
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

  @DisplayName("Expected result: 24.75")
  @Test
  void firstDiscountCalculationTest() {
    DiscountHandler handler = new DiscountHandler();
    handler.setCapital(8030);
    handler.setQuote(2.5);
    handler.setTime(validateTime("04/08/2024 - 18/09/2024"));
    handler.setLeapYear(false);
    Assertions.assertEquals(24.75, handler.calculate(0));
  }

  @DisplayName("Expected result: 100.80")
  @Test
  void secondDiscountCalculationTest() {
    DiscountHandler handler = new DiscountHandler();
    handler.setCapital(15330);
    handler.setQuote(4);
    handler.setTime(validateTime("04/02/2023 - 05/04/2023"));
    handler.setLeapYear(false);
    Assertions.assertEquals(100.8, handler.calculate(0));
  }

  @DisplayName("Expected result: 175.50")
  @Test
  void thirdDiscountCalculationTest() {
    DiscountHandler handler = new DiscountHandler();
    handler.setCapital(23790);
    handler.setQuote(3);
    handler.setTime(validateTime("03/01/2024 - 02/04/2024"));
    handler.setLeapYear(true);
    Assertions.assertEquals(175.5, handler.calculate(0));
  }

  @DisplayName("Expected result: 94.08")
  @Test
  void fourthDiscountCalculationTest() {
    DiscountHandler handler = new DiscountHandler();
    handler.setCapital(12264);
    handler.setQuote(4);
    handler.setTime(validateTime("20/06/2024 - 29/08/2024"));
    handler.setLeapYear(false);
    Assertions.assertEquals(94.08, handler.calculate(0));
  }

  @DisplayName("Expected result: 40.32")
  @Test
  void fifthDiscountCalculationTest() {
    DiscountHandler handler = new DiscountHandler();
    handler.setCapital(8176);
    handler.setQuote(4);
    handler.setTime(validateTime("20/06/2024 - 04/08/2024"));
    handler.setLeapYear(false);
    Assertions.assertEquals(40.32, handler.calculate(0));
  }

  @DisplayName("Expected result: 80.64")
  @Test
  void sixthDiscountCalculationTest() {
    DiscountHandler handler = new DiscountHandler();
    handler.setCapital(24528);
    handler.setQuote(4);
    handler.setTime(validateTime("20/06/2024 - 20/07/2024"));
    handler.setLeapYear(false);
    Assertions.assertEquals(80.64, handler.calculate(0));
  }

  @DisplayName("Expected result: 331.52")
  @Test
  void seventhDiscountCalculationTest() {
    DiscountHandler handler = new DiscountHandler();
    handler.setCapital(40880);
    handler.setQuote(4);
    handler.setTime(validateTime("20/06/2024 - 02/09/2024"));
    handler.setLeapYear(false);
    Assertions.assertEquals(331.52, handler.calculate(0));
  }

  @DisplayName("Expected result: 23725.00")
  @Test
  void firstCapitalCalculationTest() {
    DiscountHandler handler = new DiscountHandler();
    handler.setDiscount(130);
    handler.setQuote(2.5);
    handler.setTime(80);
    handler.setLeapYear(false);
    Assertions.assertEquals(23725, handler.calculate(0));
  }

  @DisplayName("Expected result: 3650.00")
  @Test
  void secondCapitalCalculationTest() {
    DiscountHandler handler = new DiscountHandler();
    handler.setDiscount(12.4);
    handler.setQuote(2);
    handler.setTime(validateTime("10/07/2024 - 10/09/2024"));
    handler.setLeapYear(false);
    Assertions.assertEquals(3650, handler.calculate(0));
  }

  @DisplayName("Expected result: 2482.00")
  @Test
  void thirdCapitalCalculationTest() {
    DiscountHandler handler = new DiscountHandler();
    handler.setDiscount(12.24);
    handler.setQuote(3);
    handler.setTime(60);
    handler.setLeapYear(false);
    Assertions.assertEquals(2482, handler.calculate(0));
  }

  @DisplayName("Expected result: 3")
  @Test
  void firstTimeCalculationTest() {
    DiscountHandler handler = new DiscountHandler();
    handler.setCapital(50000);
    handler.setDiscount(437.5);
    handler.setQuote(3.5);
    handler.setLeapYear(false);
    Assertions.assertEquals(3, handler.calculate(1));
  }

  @DisplayName("Expected result: 40")
  @Test
  void secondTimeCalculationTest() {
    DiscountHandler handler = new DiscountHandler();
    handler.setCapital(82125);
    handler.setDiscount(337.5);
    handler.setQuote(3.75);
    handler.setLeapYear(false);
    Assertions.assertEquals(40, handler.calculate(0));
  }

  @DisplayName("Expected result: 45")
  @Test
  void thirdTimeCalculationTest() {
    DiscountHandler handler = new DiscountHandler();
    handler.setCapital(43800);
    handler.setDiscount(108);
    handler.setQuote(2);
    handler.setLeapYear(false);
    Assertions.assertEquals(45, handler.calculate(0));
  }

  @DisplayName("Expected result: 3")
  @Test
  void firstQuoteCalculationTest() {
    DiscountHandler handler = new DiscountHandler();
    handler.setCapital(27375);
    handler.setDiscount(103.5);
    handler.setTime(validateTime("18/01/2023 - 05/03/2023"));
    handler.setLeapYear(false);
    Assertions.assertEquals(3, handler.calculate(0));
  }

  @DisplayName("Expected result: 2.75")
  @Test
  void secondQuoteCalculationTest() {
    DiscountHandler handler = new DiscountHandler();
    handler.setCapital(33600);
    handler.setDiscount(308);
    handler.setTime(4);
    handler.setLeapYear(false);
    Assertions.assertEquals(2.75, handler.calculate(1));
  }

  @DisplayName("Expected result: 2")
  @Test
  void thirdQuoteCalculationTest() {
    DiscountHandler handler = new DiscountHandler();
    handler.setCapital(50764.2);
    handler.setDiscount(139.08);
    handler.setTime(validateTime("26/08/2024 - 15/10/2024"));
    handler.setLeapYear(false);
    Assertions.assertEquals(2, handler.calculate(0));
  }
}
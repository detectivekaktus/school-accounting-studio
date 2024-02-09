package com.artiomastashonak.schoolaccountingstudio.time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TimeValidatorTest {
  @DisplayName("Should throw NumberFormatException")
  @Test
  void firstNumberFormatExceptionTest() {
    Assertions.assertThrows(NumberFormatException.class, () -> TimeValidator.DAYS.valueOrBetween(""));
  }

  @DisplayName("Should throw NumberFormatException")
  @Test
  void secondNumberFormatExceptionTest() {
    Assertions.assertThrows(NumberFormatException.class, () -> TimeValidator.DAYS.valueOrBetween("12/"));
  }

  @DisplayName("Should throw NumberFormatException")
  @Test
  void thirdNumberFormatExceptionTest() {
    Assertions.assertThrows(NumberFormatException.class, () -> TimeValidator.MONTHS.valueOrBetween(""));
  }

  @DisplayName("Should throw NumberFormatException")
  @Test
  void fourthNumberFormatExceptionTest() {
    Assertions.assertThrows(NumberFormatException.class, () -> TimeValidator.YEARS.valueOrBetween(""));
  }

  @DisplayName("Should throw NumberFormatException")
  @Test
  void fifthNumberFormatExceptionTest() {
    Assertions.assertThrows(NumberFormatException.class, () -> TimeValidator.YEARS.valueOrBetween("12/12"));
  }

  @DisplayName("Should throw NumberFormatException")
  @Test
  void sixthNumberFormatExceptionTest() {
    Assertions.assertThrows(NumberFormatException.class, () -> TimeValidator.YEARS.valueOrBetween("12/12/2029"));
  }

  @DisplayName("Should throw NumberFormatException")
  @Test
  void seventhNumberFormatExceptionTest() {
    Assertions.assertThrows(NumberFormatException.class, () -> TimeValidator.YEARS.valueOrBetween("12/12/2029 - 05/13/2030"));
  }

  @DisplayName("Should throw NumberFormatException")
  @Test
  void eighthNumberFormatExceptionTest() {
    Assertions.assertThrows(NumberFormatException.class, () -> TimeValidator.YEARS.valueOrBetween(" - 05/13/2030"));
  }

  @DisplayName("Should return 1")
  @Test
  void firstDaysTest() {
    Assertions.assertEquals(1, TimeValidator.DAYS.valueOrBetween("09/02/2024 - 10/02/2024"));
  }

  @DisplayName("Should return 30")
  @Test
  void secondDaysTest() {
    Assertions.assertEquals(30, TimeValidator.DAYS.valueOrBetween("09/02/2024 - 10/03/2024"));
  }

  @DisplayName("Should return 45")
  @Test
  void thirdDaysTest() {
    Assertions.assertEquals(45, TimeValidator.DAYS.valueOrBetween("09/02/2024 - 25/03/2024"));
  }

  @DisplayName("Should return 118")
  @Test
  void fourthDaysTest() {
    Assertions.assertEquals(118, TimeValidator.DAYS.valueOrBetween("09/02/2024 - 06/06/2024"));
  }

  @DisplayName("Should return 1")
  @Test
  void firstMonthTest() {
    Assertions.assertEquals(1, TimeValidator.MONTHS.valueOrBetween("09/02/2024 - 09/03/2024"));
  }

  @DisplayName("Should return 10")
  @Test
  void secondMonthTest() {
    Assertions.assertEquals(10, TimeValidator.MONTHS.valueOrBetween("09/02/2024 - 09/12/2024"));
  }

  @DisplayName("Should return 12")
  @Test
  void thirdMonthTest() {
    Assertions.assertEquals(12, TimeValidator.MONTHS.valueOrBetween("09/02/2024 - 09/02/2025"));
  }

  @DisplayName("Should return 8")
  @Test
  void fourthMonthTest() {
    Assertions.assertEquals(8, TimeValidator.MONTHS.valueOrBetween("09/02/2024 - 09/10/2024"));
  }

  @DisplayName("Should return 0")
  @Test
  void firstYearsTest() {
    Assertions.assertEquals(0, TimeValidator.YEARS.valueOrBetween("09/02/2024 - 09/10/2024"));
  }

  @DisplayName("Should return 2")
  @Test
  void secondYearsTest() {
    Assertions.assertEquals(2, TimeValidator.YEARS.valueOrBetween("09/02/2024 - 09/10/2026"));
  }

  @DisplayName("Should return 38")
  @Test
  void thirdYearsTest() {
    Assertions.assertEquals(38, TimeValidator.YEARS.valueOrBetween("09/02/2024 - 09/10/2062"));
  }

  @DisplayName("Should return 15")
  @Test
  void fourthYearsTest() {
    Assertions.assertEquals(15, TimeValidator.YEARS.valueOrBetween("09/02/2024 - 09/10/2039"));
  }
}
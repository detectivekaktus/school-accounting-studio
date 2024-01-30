package com.artiomastashonak.schoolaccountingstudio.interest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InterestTotAmountDialogTest {
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

  @DisplayName("Expected result: 173")
  @Test
  void firstRegExTest() {
    Assertions.assertEquals(173L, validateTime("22/01/2024 - 13/07/2024"));
  }

  @DisplayName("Expected result: 2")
  @Test
  void secondRegExTest() {
    Assertions.assertEquals(2L, validateTime("01/01/2025 - 03/01/2025"));
  }

  @DisplayName("Expected result: 234")
  @Test
  void thirdRegExTest() {
    Assertions.assertEquals(234L, validateTime("22/01/2024 - 12/09/2024"));
  }

  @DisplayName("Expected result: 2171")
  @Test
  void fourthRegExTest() {
    Assertions.assertEquals(2171L, validateTime("22/01/2024 - 01/01/2030"));
  }

  @DisplayName("Expected result: 365")
  @Test
  void fifthRegExTest() {
    Assertions.assertEquals(365L, validateTime("01/01/2024 - 31/12/2024"));
  }

  @DisplayName("Expected result: 52")
  @Test
  void sixthRegExTest() {
    Assertions.assertEquals(52L, validateTime("01/01/2024 - 22/02/2024"));
  }

  @DisplayName("Expected result: 52")
  @Test
  void firstPlainTextTest() {
    Assertions.assertEquals(52L, validateTime("52"));
  }

  @DisplayName("Expected result: 500")
  @Test
  void secondPlainTextTest() {
    Assertions.assertEquals(500L, validateTime("500"));
  }

  @DisplayName("Expected result: 269")
  @Test
  void thirdPlainTextTest() {
    Assertions.assertEquals(269L, validateTime("269"));
  }

  @DisplayName("Expected result: 1")
  @Test
  void fourthPlainTextTest() {
    Assertions.assertEquals(1L, validateTime("1"));
  }

  @DisplayName("Expected result: 32")
  @Test
  void fifthPlainTextTest() {
    Assertions.assertEquals(32L, validateTime("32"));
  }

  @DisplayName("Expected result: NumberFormatException")
  @Test
  void firstExceptionTest() {
    Assertions.assertThrows(NumberFormatException.class, () -> validateTime("12/"));
  }

  @DisplayName("Expected result: NumberFormatException")
  @Test
  void secondExceptionTest() {
    Assertions.assertThrows(NumberFormatException.class, () -> validateTime("12/01/2025"));
  }

  @DisplayName("Expected result: NumberFormatException")
  @Test
  void thirdExceptionTest() {
    Assertions.assertThrows(NumberFormatException.class, () -> validateTime("12/11/2024 - 1/12/2024"));
  }

  @DisplayName("Expected result: NumberFormatException")
  @Test
  void fourthExceptionTest() {
    Assertions.assertThrows(NumberFormatException.class, () -> validateTime("05/10/2030 -"));
  }
}
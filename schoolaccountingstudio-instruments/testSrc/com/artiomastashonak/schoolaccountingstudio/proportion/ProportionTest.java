package com.artiomastashonak.schoolaccountingstudio.proportion;

import com.artiomastashonak.schoolaccountingstudio.exceptions.NoSolutionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProportionTest {
  @DisplayName("Excepted result: 6390")
  @Test
  void firstCalculationTest() {
    try {
      Assertions.assertEquals(6390, new Proportion(35500, 0, 100, 18).solve());
    } catch (NoSolutionException ignored) { }
  }

  @DisplayName("Excepted result: 10.5")
  @Test
  void secondCalculationTest() {
    try {
      Assertions.assertEquals(10.5, new Proportion(0, 4200, 2.5, 1000).solve());
    } catch (NoSolutionException ignored) { }
  }

  @DisplayName("Excepted result: 158.7")
  @Test
  void thirdCalculationTest() {
    try {
      Assertions.assertEquals(158.7, new Proportion(100, 4.6, 3450, 0).solve());
    } catch (NoSolutionException ignored) { }
  }

  @DisplayName("Excepted result: 405")
  @Test
  void fourthCalculationTest() {
    try {
      Assertions.assertEquals(405, new Proportion(2.5, 100, 0, 16200).solve());
    } catch (NoSolutionException ignored) { }
  }

  @DisplayName("Excepted result: 23.1")
  @Test
  void fifthCalculationTest() {
    try {
      Assertions.assertEquals(23.1, new Proportion(165, 0, 100, 14).solve());
    } catch (NoSolutionException ignored) { }
  }

  @DisplayName("Excepted result: NoSolutionException")
  @Test
  void firstNoSolutionException() {
    Assertions.assertThrows(NoSolutionException.class, () -> new Proportion(0, 0, 0, 0).solve());
  }

  @DisplayName("Excepted result: NoSolutionException")
  @Test
  void secondNoSolutionException() {
    Assertions.assertThrows(NoSolutionException.class, () -> new Proportion(1, 2, 0, 0).solve());
  }

  @DisplayName("Excepted result: NoSolutionException")
  @Test
  void thirdNoSolutionException() {
    Assertions.assertThrows(NoSolutionException.class, () -> new Proportion(1, 0, 1, 0).solve());
  }

  @DisplayName("Excepted result: Infinity")
  @Test
  void firstPositiveInfinity() {
    try {
      Assertions.assertEquals(Double.POSITIVE_INFINITY, new Proportion(0, 10, 20, 0).solve());
    } catch (NoSolutionException ignored) { }
  }

  @DisplayName("Excepted result: Infinity")
  @Test
  void secondPositiveInfinity() {
    try {
      Assertions.assertEquals(Double.POSITIVE_INFINITY, new Proportion(1, 0, 10, 0).solve());
    } catch (NoSolutionException ignored) { }
  }
}
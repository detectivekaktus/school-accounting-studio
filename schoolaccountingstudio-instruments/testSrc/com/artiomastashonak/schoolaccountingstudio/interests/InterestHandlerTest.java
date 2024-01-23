package com.artiomastashonak.schoolaccountingstudio.interests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InterestHandlerTest {

    private long validateTime(String input) {
        String timeRegex = "^((0[1-9]|[1-2]\\d|3[0-1])/(0[1-9]|1[0-2])/(\\d{4}))\\s-\\s((0[1-9]|[1-2]\\d|3[0-1])/(0[1-9]|1[0-2])/(\\d{4}))$";
        Pattern pattern = Pattern.compile(timeRegex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            LocalDate initDate = LocalDate.of(Integer.parseInt(input.substring(6, 10)),
                    Integer.parseInt(input.substring(3, 5)),
                    Integer.parseInt(input.substring(0, 2)));
            LocalDate endDate = LocalDate.of(Integer.parseInt(input.substring(19, 23)),
                    Integer.parseInt(input.substring(16, 18)),
                    Integer.parseInt(input.substring(13, 15)));
            return ChronoUnit.DAYS.between(initDate, endDate);
        }
        return Long.parseLong(input);
    }

    @DisplayName("Expected result: 214.50")
    @Test
    void firstInterestCalculationTest() {
        InterestHandler handler = new InterestHandler();
        handler.setCapital(31200);
        handler.setTime(3);
        handler.setQuote(2.75);
        handler.setLeapYear(false);
        Assertions.assertEquals(214.50, handler.calculate(1));
    }

    @DisplayName("Expected result: 540.00")
    @Test
    void secondInterestCalculationTest() {
        InterestHandler handler = new InterestHandler();
        handler.setCapital(54750);
        handler.setTime(validateTime("22/01/2023 - 22/04/2023"));
        handler.setQuote(4);
        handler.setLeapYear(false);
        Assertions.assertEquals(540, handler.calculate(0));
    }

    @DisplayName("Expected result: 257.25")
    @Test
    void thirdInterestCalculationTest() {
        InterestHandler handler = new InterestHandler();
        handler.setCapital(38430);
        handler.setTime(validateTime("04/02/2024 - 14/04/2024"));
        handler.setQuote(3.5);
        handler.setLeapYear(true);
        Assertions.assertEquals(257.25, handler.calculate(0));
    }

    @DisplayName("Expected result: 68.25")
    @Test
    void fourthInterestCalculationTest() {
        InterestHandler handler = new InterestHandler();
        handler.setCapital(12810);
        handler.setTime(validateTime("21/01/2024 - 26/03/2024"));
        handler.setQuote(3);
        handler.setLeapYear(true);
        Assertions.assertEquals(68.25, handler.calculate(0));
    }

    @DisplayName("Expected result: 107.10")
    @Test
    void fifthInterestCalculationTest() {
        InterestHandler handler = new InterestHandler();
        handler.setCapital(18615);
        handler.setTime(validateTime("60"));
        handler.setQuote(3.5);
        handler.setLeapYear(false);
        Assertions.assertEquals(107.1, handler.calculate(0));
    }

    @DisplayName("Expected result: 1485.00")
    @Test
    void sixthInterestCalculationTest() {
        InterestHandler handler = new InterestHandler();
        handler.setCapital(80300);
        handler.setTime(validateTime("150"));
        handler.setQuote(4.5);
        handler.setLeapYear(false);
        Assertions.assertEquals(1485, handler.calculate(0));
    }

    @DisplayName("Expected result: 97.60")
    @Test
    void seventhInterestCalculationTest() {
        InterestHandler handler = new InterestHandler();
        handler.setCapital(19520);
        handler.setTime(validateTime("2"));
        handler.setQuote(3);
        handler.setLeapYear(false);
        Assertions.assertEquals(97.6, handler.calculate(1));
    }

    @DisplayName("Expected result: 8280.00")
    @Test
    void firstCapitalCalculationTest() {
        InterestHandler handler = new InterestHandler();
        handler.setInterest(234.6);
        handler.setTime(validateTime("4"));
        handler.setQuote(8.5);
        handler.setLeapYear(false);
        Assertions.assertEquals(8280, handler.calculate(1));
    }

    @DisplayName("Expected result: 22630.00")
    @Test
    void secondCapitalCalculationTest() {
        InterestHandler handler = new InterestHandler();
        handler.setInterest(327.36);
        handler.setTime(validateTime("88"));
        handler.setQuote(6);
        handler.setLeapYear(false);
        Assertions.assertEquals(22630, handler.calculate(0));
    }

    @DisplayName("Expected result: 32850.00")
    @Test
    void thirdCapitalCalculationTest() {
        InterestHandler handler = new InterestHandler();
        handler.setInterest(504);
        handler.setTime(validateTime("70"));
        handler.setQuote(8);
        handler.setLeapYear(false);
        Assertions.assertEquals(32850, handler.calculate(0));
    }

    @DisplayName("Expected result: 9.00")
    @Test
    void firstQuoteCalculationTest() {
        InterestHandler handler = new InterestHandler();
        handler.setCapital(21900);
        handler.setInterest(334.8);
        handler.setTime(validateTime("62"));
        handler.setLeapYear(false);
        Assertions.assertEquals(9, handler.calculate(0));
    }

    @DisplayName("Expected result: 8.00")
    @Test
    void secondQuoteCalculationTest() {
        InterestHandler handler = new InterestHandler();
        handler.setCapital(27600);
        handler.setInterest(1288);
        handler.setTime(validateTime("7"));
        handler.setLeapYear(false);
        Assertions.assertEquals(8, handler.calculate(1));
    }

    @DisplayName("Expected result: 4.25")
    @Test
    void thirdQuoteCalculationTest() {
        InterestHandler handler = new InterestHandler();
        handler.setCapital(69350);
        handler.setInterest(726.75);
        handler.setTime(validateTime("90"));
        handler.setLeapYear(false);
        Assertions.assertEquals(4.25, handler.calculate(0));
    }

    @DisplayName("Expected result: 3.00")
    @Test
    void firstTimeCalculationTest() {
        InterestHandler handler = new InterestHandler();
        handler.setCapital(9960);
        handler.setInterest(174.3);
        handler.setQuote(7);
        handler.setLeapYear(false);
        Assertions.assertEquals(3, handler.calculate(1));
    }

    @DisplayName("Expected result: 120.00")
    @Test
    void secondTimeCalculationTest() {
        InterestHandler handler = new InterestHandler();
        handler.setCapital(71175);
        handler.setInterest(1404);
        handler.setQuote(6);
        handler.setLeapYear(false);
        Assertions.assertEquals(120, handler.calculate(0));
    }

    @DisplayName("Expected result: 60.00")
    @Test
    void thirdTimeCalculationTest() {
        InterestHandler handler = new InterestHandler();
        handler.setCapital(29280);
        handler.setInterest(456);
        handler.setQuote(9.5);
        handler.setLeapYear(true);
        Assertions.assertEquals(60, handler.calculate(0));
    }
}
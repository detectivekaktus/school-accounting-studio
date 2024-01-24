package com.artiomastashonak.schoolaccountingstudio.interest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TotalAmountHandlerTest {

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

    @DisplayName("Expected result: 14957.25")
    @Test
    void firstTotalAmountCalculationTest() {
        TotalAmountHandler handler = new TotalAmountHandler();
        handler.setCapital(14700);
        handler.setTime(7);
        handler.setQuote(3);
        handler.setLeapYear(false);
        Assertions.assertEquals(14957.25, handler.calculate(1));
    }

    @DisplayName("Expected result: 11439.00")
    @Test
    void secondTotalAmountCalculationTest() {
        TotalAmountHandler handler = new TotalAmountHandler();
        handler.setCapital(11315);
        handler.setTime(100);
        handler.setQuote(4);
        handler.setLeapYear(false);
        Assertions.assertEquals(11439, handler.calculate(0));
    }

    @DisplayName("Expected result: 16167.80")
    @Test
    void thirdTotalAmountCalculationTest() {
        TotalAmountHandler handler = new TotalAmountHandler();
        handler.setCapital(16060);
        handler.setTime(70);
        handler.setQuote(3.5);
        handler.setLeapYear(false);
        Assertions.assertEquals(16167.8, handler.calculate(0));
    }

    @DisplayName("Expected result: 56580.00")
    @Test
    void fourthTotalAmountCalculationTest() {
        TotalAmountHandler handler = new TotalAmountHandler();
        handler.setCapital(55200);
        handler.setTime(6);
        handler.setQuote(5);
        handler.setLeapYear(false);
        Assertions.assertEquals(56580, handler.calculate(1));
    }

    @DisplayName("Expected result: 13557.50")
    @Test
    void fifthTotalAmountCalculationTest() {
        TotalAmountHandler handler = new TotalAmountHandler();
        handler.setCapital(13200);
        handler.setTime(10);
        handler.setQuote(3.25);
        handler.setLeapYear(false);
        Assertions.assertEquals(13557.5, handler.calculate(1));
    }

    @DisplayName("Expected result: 18237.92")
    @Test
    void sixthTotalAmountCalculationTest() {
        TotalAmountHandler handler = new TotalAmountHandler();
        handler.setCapital(18104);
        handler.setTime(90);
        handler.setQuote(3);
        handler.setLeapYear(false);
        Assertions.assertEquals(18237.92, handler.calculate(0));
    }

    @DisplayName("Expected result: 44376.00")
    @Test
    void seventhTotalAmountCalculationTest() {
        TotalAmountHandler handler = new TotalAmountHandler();
        handler.setCapital(43800);
        handler.setTime(validateTime("18/06/2024 - 16/10/2024"));
        handler.setQuote(4);
        handler.setLeapYear(false);
        Assertions.assertEquals(44376, handler.calculate(0));
    }

    @DisplayName("Expected result: 29200.00")
    @Test
    void firstCapitalCalculationTest() {
        TotalAmountHandler handler = new TotalAmountHandler();
        handler.setTotalAmount(29486);
        handler.setTime(validateTime("19/06/2024 - 07/10/2024"));
        handler.setQuote(3.25);
        handler.setLeapYear(false);
        Assertions.assertEquals(29200, handler.calculate(0));
    }

    @DisplayName("Expected result: 147825.00")
    @Test
    void secondCapitalCalculationTest() {
        TotalAmountHandler handler = new TotalAmountHandler();
        handler.setTotalAmount(150255);
        handler.setTime(150);
        handler.setQuote(4);
        handler.setLeapYear(false);
        Assertions.assertEquals(147825, handler.calculate(0));
    }

    @DisplayName("Expected result: 18250.00")
    @Test
    void thirdCapitalCalculationTest() {
        TotalAmountHandler handler = new TotalAmountHandler();
        handler.setTotalAmount(18386);
        handler.setTime(68);
        handler.setQuote(4);
        handler.setLeapYear(false);
        Assertions.assertEquals(18250, handler.calculate(0));
    }

    @DisplayName("Expected result: 6")
    @Test
    void firstTimeCalculationTest() {
        TotalAmountHandler handler = new TotalAmountHandler();
        handler.setTotalAmount(20245.5);
        handler.setCapital(19800);
        handler.setQuote(4.5);
        handler.setLeapYear(false);
        Assertions.assertEquals(6, handler.calculate(1));
    }

    @DisplayName("Expected result: 200")
    @Test
    void secondTimeCalculationTest() {
        TotalAmountHandler handler = new TotalAmountHandler();
        handler.setTotalAmount(49980);
        handler.setCapital(49640);
        handler.setQuote(1.25);
        handler.setLeapYear(false);
        Assertions.assertEquals(200, handler.calculate(0));
    }

    @DisplayName("Expected result: 100")
    @Test
    void thirdTimeCalculationTest() {
        TotalAmountHandler handler = new TotalAmountHandler();
        handler.setTotalAmount(22452.3);
        handler.setCapital(22119);
        handler.setQuote(5.5);
        handler.setLeapYear(false);
        Assertions.assertEquals(100, handler.calculate(0));
    }

    @DisplayName("Expected result: 3.5")
    @Test
    void firstQuoteCalculationTest() {
        TotalAmountHandler handler = new TotalAmountHandler();
        handler.setTotalAmount(4345.2);
        handler.setCapital(4320);
        handler.setTime(2);
        handler.setLeapYear(false);
        Assertions.assertEquals(3.5, handler.calculate(1));
    }

    @DisplayName("Expected result: 5")
    @Test
    void secondQuoteCalculationTest() {
        TotalAmountHandler handler = new TotalAmountHandler();
        handler.setTotalAmount(22119);
        handler.setCapital(21900);
        handler.setTime(validateTime("10/01/2023 - 24/03/2023"));
        handler.setLeapYear(false);
        Assertions.assertEquals(5, handler.calculate(0));
    }

    @DisplayName("Expected result: 5")
    @Test
    void thirdQuoteCalculationTest() {
        TotalAmountHandler handler = new TotalAmountHandler();
        handler.setTotalAmount(20652.5);
        handler.setCapital(20075);
        handler.setTime(210);
        handler.setLeapYear(false);
        Assertions.assertEquals(5, handler.calculate(0));
    }
}
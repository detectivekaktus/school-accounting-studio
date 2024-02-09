package com.artiomastashonak.schoolaccountingstudio.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TimeValidator {
  public static final class DAYS {
    public static long valueOrBetween(String text) throws NumberFormatException {
      String timeRegex = "^((0[1-9]|[1-2]\\d|3[0-1])/(0[1-9]|1[0-2])/(\\d{4}))\\s-\\s((0[1-9]|[1-2]\\d|3[0-1])/(0[1-9]|1[0-2])/(\\d{4}))$";
      Pattern pattern = Pattern.compile(timeRegex);
      Matcher matcher = pattern.matcher(text);
      if (matcher.matches()) {
        return ChronoUnit.DAYS.between(LocalDate.of(Integer.parseInt(text.substring(6, 10)), Integer.parseInt(text.substring(3, 5)), Integer.parseInt(text.substring(0, 2))),
          LocalDate.of(Integer.parseInt(text.substring(19, 23)), Integer.parseInt(text.substring(16, 18)), Integer.parseInt(text.substring(13, 15))));
      }
      return Long.parseLong(text);
    }
  }

  public static final class MONTHS {
    public static long valueOrBetween(String text) throws NumberFormatException {
      String timeRegex = "^((0[1-9]|[1-2]\\d|3[0-1])/(0[1-9]|1[0-2])/(\\d{4}))\\s-\\s((0[1-9]|[1-2]\\d|3[0-1])/(0[1-9]|1[0-2])/(\\d{4}))$";
      Pattern pattern = Pattern.compile(timeRegex);
      Matcher matcher = pattern.matcher(text);
      if (matcher.matches()) {
        return ChronoUnit.MONTHS.between(LocalDate.of(Integer.parseInt(text.substring(6, 10)), Integer.parseInt(text.substring(3, 5)), Integer.parseInt(text.substring(0, 2))),
          LocalDate.of(Integer.parseInt(text.substring(19, 23)), Integer.parseInt(text.substring(16, 18)), Integer.parseInt(text.substring(13, 15))));
      }
      return Long.parseLong(text);
    }
  }

  public static final class YEARS {
    public static long valueOrBetween(String text) throws NumberFormatException {
      String timeRegex = "^((0[1-9]|[1-2]\\d|3[0-1])/(0[1-9]|1[0-2])/(\\d{4}))\\s-\\s((0[1-9]|[1-2]\\d|3[0-1])/(0[1-9]|1[0-2])/(\\d{4}))$";
      Pattern pattern = Pattern.compile(timeRegex);
      Matcher matcher = pattern.matcher(text);
      if (matcher.matches()) {
        return ChronoUnit.YEARS.between(LocalDate.of(Integer.parseInt(text.substring(6, 10)), Integer.parseInt(text.substring(3, 5)), Integer.parseInt(text.substring(0, 2))),
          LocalDate.of(Integer.parseInt(text.substring(19, 23)), Integer.parseInt(text.substring(16, 18)), Integer.parseInt(text.substring(13, 15))));
      }
      return Long.parseLong(text);
    }
  }
  private TimeValidator() {}
}
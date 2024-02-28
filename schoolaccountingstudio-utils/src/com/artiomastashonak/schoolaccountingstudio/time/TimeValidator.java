// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The {@code TimeValidator} object is a helper instance that allows to perform
 * input time validations on user prompts entered via the graphical user
 * interface components of the application.
 *
 * @see DAYS
 * @see MONTHS
 * @see YEARS
 *
 * @author Artiom Astashonak
 */
public final class TimeValidator {
  /**
   * The {@code DAYS} inner instance of the {@link TimeValidator} is a helper
   * object that allows to perform time validations on the user input and get
   * results formatted in the days.
   */
  public static final class DAYS {
    /**
     * Checks if user input matches the pattern <strong>dd/mm/yyyy - dd/mm/yyyy</strong>
     * or is a number of days itself.
     *
     * @param text user input
     *
     * @return number of days between the two dates specified by the user or the number the {@code text} is
     *
     * @throws NumberFormatException if {@code text} doesn't match the pattern <strong>dd/mm/yyyy - dd/mm/yyyy</strong> or isn't a number
     */
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

  /**
   * The {@code MONTHS} inner instance of the {@link TimeValidator} is a helper
   * object that allows to perform time validations on the user input and get
   * results formatted in the months.
   */
  public static final class MONTHS {
    /**
     * Checks if user input matches the pattern <strong>dd/mm/yyyy - dd/mm/yyyy</strong>
     * or is a number of months itself.
     *
     * @param text user input
     *
     * @return number of months between the two dates specified by the user or the number the {@code text} is
     * @throws NumberFormatException if {@code text} doesn't match the pattern <strong>dd/mm/yyyy - dd/mm/yyyy</strong> or isn't a number
     */
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

  /**
   * The {@code YEARS} inner instance of the {@link TimeValidator} is a helper
   * object that allows to perform time validations on the user input and get
   * results formatted in the years.
   */
  public static final class YEARS {
    /**
     * Checks if user input matches the pattern <strong>dd/mm/yyyy - dd/mm/yyyy</strong>
     * or is a number of years itself.
     *
     * @param text user input
     *
     * @return number of years between the two dates specified by the user or the number {@code text} is
     *
     * @throws NumberFormatException if {@code text} doesn't match the pattern <strong>dd/mm/yyyy - dd/mm/yyyy</strong> or isn't a number
     */
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
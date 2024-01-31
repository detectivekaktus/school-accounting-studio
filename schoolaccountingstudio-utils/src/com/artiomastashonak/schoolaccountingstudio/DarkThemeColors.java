package com.artiomastashonak.schoolaccountingstudio;

import java.awt.Color;

public enum DarkThemeColors {
  MAIN_WINDOW_BACKGROUND_COLOR(new Color(54, 54, 54)),
  MENU_BAR_BACKGROUND_COLOR(new Color(37, 37, 37)),
  POP_UP_WINDOW_BACKGROUND_COLOR(new Color(71, 71, 71)),
  BUTTON_BACKGROUND_COLOR(new Color(90, 90, 90)),
  SELECTED_BUTTON_BACKGROUND_COLOR(new Color(95, 95, 95)),
  TEXT_ENTRY_BACKGROUND_COLOR(new Color(56, 56, 56)),

  PRIMARY_TEXT_COLOR(new Color(255, 255, 255)),
  SECONDARY_TEXT_COLOR(new Color(155, 155, 155)),
  TERTIARY_TEXT_COLOR(new Color(207, 207, 207)),

  VIOLET_PRIMARY_ACCENT_COLOR(new Color(149, 88, 249)),
  VIOLET_SECONDARY_ACCENT_COLOR(new Color(194, 156, 255)),

  DANGER_COLOR(new Color(255, 89, 89));

  public final Color color;

  DarkThemeColors(Color color) {
    this.color = color;
  }
}
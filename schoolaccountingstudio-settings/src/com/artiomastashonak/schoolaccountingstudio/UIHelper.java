package com.artiomastashonak.schoolaccountingstudio;

import java.awt.*;

public final class UIHelper {
  private static final Color MAIN_WINDOW_COLOR = new Color(54, 54, 54);
  private static final Color MENU_BAR_COLOR = new Color(37, 37, 37);
  private static final Color BRIGHT_BUTTON_COLOR = new Color(90, 90, 90);
  private static final Color DARK_BUTTON_COLOR = new Color(56, 56, 56);
  private static final Color PRIMARY_TEXT_COLOR = new Color(255, 255, 255);
  private static final Color VIOLET_PRIMARY_COLOR = new Color(149, 88, 249);

  private static final String FONT_NAME = "sans-serif";
  private static final Font SECTION_TITLE_FONT = new Font(FONT_NAME, Font.BOLD, 50);
  private static final Font SUBSECTION_TITLE_FONT = new Font(FONT_NAME, Font.BOLD, 40);
  private static final Font ELEMENT_TITLE_FONT = new Font(FONT_NAME, Font.PLAIN, 27);
  private static final Font INPUT_FONT = new Font(FONT_NAME, Font.PLAIN, 18);
  private static final Font MENU_BAR_FONT = new Font(FONT_NAME, Font.PLAIN, 16);

  private UIHelper() { }

  public static Color getMainWindowColor() {
    return MAIN_WINDOW_COLOR;
  }

  public static Color getMenuBarColor() {
    return MENU_BAR_COLOR;
  }

  public static Color getBrightButtonColor() {
    return BRIGHT_BUTTON_COLOR;
  }

  public static Color getDarkButtonColor() {
    return DARK_BUTTON_COLOR;
  }

  public static Color getPrimaryTextColor() {
    return PRIMARY_TEXT_COLOR;
  }

  public static Color getVioletPrimaryColor() {
    return VIOLET_PRIMARY_COLOR;
  }

  public static Font getSectionTitleFont() {
    return SECTION_TITLE_FONT;
  }

  public static Font getSubsectionTitleFont() {
    return SUBSECTION_TITLE_FONT;
  }

  public static Font getElementTitleFont() {
    return ELEMENT_TITLE_FONT;
  }

  public static Font getInputFont() {
    return INPUT_FONT;
  }

  public static Font getMenuBarFont() {
    return MENU_BAR_FONT;
  }
}
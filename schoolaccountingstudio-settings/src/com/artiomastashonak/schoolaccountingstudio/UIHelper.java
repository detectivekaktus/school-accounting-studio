// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio;

import java.awt.*;

/**
 * The {@code UIHelper} class creates a globally defined object containing
 * graphical user interface constant class values to construct new components to
 * be placed on the user's screen.
 * <p>
 * All the properties stored in this object are accessible through getter methods.
 * The properties of {@code UIHelper} can't be changed during the runtime.
 *
 * @author Artiom Astashonak
 */
public final class UIHelper {
  /**
   * Main color fond the windows' background.
   */
  private static final Color MAIN_WINDOW_COLOR = new Color(54, 54, 54);
  /**
   * Main color for the {@link MenuBar} displayed at top of the program.
   */
  private static final Color MENU_BAR_COLOR = new Color(37, 37, 37);
  /**
   * Main color for the {@link Button} components on the screen.
   */
  private static final Color BRIGHT_BUTTON_COLOR = new Color(90, 90, 90);
  /**
   * Darker version of the main color for the {@link Button} components on the screen.
   */
  private static final Color DARK_BUTTON_COLOR = new Color(56, 56, 56);
  /**
   * Main color for the text-based components on the screen.
   */
  private static final Color PRIMARY_TEXT_COLOR = new Color(255, 255, 255);
  /**
   * Main accent color for the text-based components on the screen.
   */
  private static final Color VIOLET_PRIMARY_COLOR = new Color(149, 88, 249);

  /**
   * The font name for all text-based components on the screen.
   */
  private static final String FONT_NAME = "sans-serif";
  /**
   * 50 pixels wide and bold font.
   */
  private static final Font SECTION_TITLE_FONT = new Font(FONT_NAME, Font.BOLD, 50);
  /**
   * 40 pixels wide and bold font.
   */
  private static final Font SUBSECTION_TITLE_FONT = new Font(FONT_NAME, Font.BOLD, 40);
  /**
   * 27 pixels wide and plain font.
   */
  private static final Font ELEMENT_TITLE_FONT = new Font(FONT_NAME, Font.PLAIN, 27);
  /**
   * 18 pixels wide and plain font.
   */
  private static final Font INPUT_FONT = new Font(FONT_NAME, Font.PLAIN, 18);
  /**
   * 16 pixels wide and plain font.
   */
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
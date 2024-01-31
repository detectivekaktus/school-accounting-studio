package com.artiomastashonak.schoolaccountingstudio;

public enum TextSizes {
  SECTION_TITLE_TEXT_SIZE(50),
  WELCOME_ACTION_BUTTONS_TEXT_SIZE(35),
  SUBSECTION_TITLE_TEXT_SIZE(40),
  ELEMENT_TITLE_TEXT_SIZE(27),
  DIALOG_ELEMENT_TITLE_TEXT_SIZE(22),
  BUTTON_TEXT_SIZE(18),
  MENU_BAR_TEXT_SIZE(15);

  public final int size;

  TextSizes(int size) {
    this.size = size;
  }
}
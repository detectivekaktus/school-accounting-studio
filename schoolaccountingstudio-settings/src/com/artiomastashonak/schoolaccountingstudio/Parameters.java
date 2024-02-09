package com.artiomastashonak.schoolaccountingstudio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public final class Parameters {
  private static ResourceBundle BUNDLE;
  private static Properties CONFIG;
  private static MenuBar MENU_BAR;

  private Parameters() { }

  public static void initialize() {
    setupConfig();
    setupBundle();
    setupMenuBar();
  }

  private static void setupConfig() {
    try {
      CONFIG = new Properties();
      CONFIG.load(new FileInputStream("config.properties"));
    } catch (IOException ignored) { }
  }

  private static void setupBundle() {
    BUNDLE = ResourceBundle.getBundle("strings/strings", Locale.of(CONFIG.get("language").toString()));
  }

  public static void updateConfig() {
    try {
      CONFIG.store(new FileOutputStream("config.properties"), "Configuration update caused by user action.");
    } catch (IOException ignored) { }
  }

  private static void setupMenuBar() {
    MENU_BAR = new MenuBar();
  }

  public static ResourceBundle getBundle() {
    return BUNDLE;
  }

  public static Properties getConfig() {
    return CONFIG;
  }

  public static MenuBar getMenuBar() {
    return MENU_BAR;
  }
}
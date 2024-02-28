// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * The {@code Parameters} class represents a set of constant and global symbols
 * for application components to be utilized during the runtime.
 * <p>
 * The {@code Parameters} contains three children: {@link ResourceBundle} {@code BUNDLE},
 * {@link Properties} {@code CONFIG}, and {@link MenuBar} {@code MENU_BAR}, each having
 * its own purpose and methods associated with it. These children are accessible via
 * getter methods.
 *
 * @see ResourceBundle
 * @see Properties
 * @see MenuBar
 *
 * @author Artiom Astashonak
 */
public final class Parameters {
  /**
   * Stores all string references found in the resources/string directory.
   */
  private static ResourceBundle BUNDLE;
  /**
   * Stores all application properties utilized by other components.
   */
  private static Properties CONFIG;
  /**
   * Stores the current unique instance of a {@link MenuBar} object.
   */
  private static MenuBar MENU_BAR;

  private Parameters() { }

  /**
   * Initializes and indexes all child variables to be accessible.
   */
  public static void initialize() {
    setupConfig();
    setupBundle();
    setupMenuBar();
  }

  /**
   * Reads the config.properties file in the source directory and assigns all its contents
   * to the {@code CONFIG} class variable.
   */
  private static void setupConfig() {
    try {
      CONFIG = new Properties();
      CONFIG.load(new FileInputStream("config.properties"));
    } catch (IOException ignored) { }
  }

  /**
   * Reads the resources/strings/string_<strong>LOCALE</strong> file and gets
   * a {@link ResourceBundle} out of it. The {@link Locale} specified to the
   * {@code getBundle()} method is gotten via the {@code CONFIG} class variable.
   */
  private static void setupBundle() {
    BUNDLE = ResourceBundle.getBundle("strings/strings", Locale.of(CONFIG.get("language").toString()));
  }

  /**
   * Applies changes to the config, writing them into the config.properties
   * file in the source directory.
   */
  public static void updateConfig() {
    try {
      CONFIG.store(new FileOutputStream("config.properties"), "Configuration update caused by user action.");
    } catch (IOException ignored) { }
  }

  /**
   * Creates a new instance of {@link MenuBar} class.
   */
  private static void setupMenuBar() {
    MENU_BAR = new MenuBar();
  }

  /**
   * @return resource bundle with string values
   */
  public static ResourceBundle getBundle() {
    return BUNDLE;
  }

  /**
   * @return properties with application settings
   */
  public static Properties getConfig() {
    return CONFIG;
  }

  /**
   * @return current menu bar
   */
  public static MenuBar getMenuBar() {
    return MENU_BAR;
  }
}
# School Accounting Studio
***THE PROJECT IS NO LONGER MAINTAINED! Consider forking this repository to continue working on it.***
School Accounting Studio is a free and open-source accounting software primarily for school students to learn and practice their accounting skills. It's distributed under the **Apache License 2.0** (can be found as `LICENSE` file inside the project directory).

The program is available in six different languages: English, Italian, Spanish, Albanian, Russian and Arabic.

You can fork and modify the code inside this GitHub repository, however, you want, keeping the original's author name.

## Installation
To install School Accounting Studio, head over the release tab on the right side of the repository you are currently in and click on the desired version of the program to be downloaded.

Download the `build_0.0.x.zip` archive. Once done, extract all the content of the archive in a desired directory; at this point you'll have School Accounting Studio installed on your machine.

## Project structure
Down below, you can see a described representation of the project structure.
```
  |- .github                                GitHub related files
  |- .idea                                  IntellijIDEA IDE related files
  |- lib                                    Dependencies and modules
  |- resources                              Non-code resources
  |  |- img                                 All format images
  |  |- printing                            Printing templates
  |  |- strings                             Locale string values
  |- schoolaccountingstudio-instruments     UI components combined with logic
  |- schoolaccountingstudio-settings        Set of constant values and settings for the application
  |- schoolaccountingstudio-ui              UI components
  |- schoolaccountingstudio-utils           Utility classes, enums and data
  |- src                                    Source folder for the main class
```

## Dependencies
The project relies on the following dependencies to be developed and driven or function properly without errors or unexpected behavior.

| ***Dependency name*** | ***Dependency description*** | ***Dependency version*** |
| --- | --- | --- |
| Jupiter JUnit | JUnit is a Java unit testing framework, developed by the junit-team, that provides different tools to test and configure the application during the development. | 5.8.1 |
| JetBrains Annotations Pack | JetBrains Annotations is a library that provides different annotations for JVM-driven languages. | - |

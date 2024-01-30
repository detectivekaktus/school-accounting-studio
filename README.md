# School Accounting Studio
School Accounting Studio is a free and open-source accounting software primarily for school students to learn and practice their accounting skills. It's distributed under the **Apache License 2.0** (can be found as `LICENSE` file inside the project directory).

It's developed with the Java programing language and its eventual built-in libraries and tools due to the language's platform independence and C-like consistent code style and implementations.

The major issue of the current version is the `Java Swing` Graphical User Interface implementation. The project is going to migrate to other libraries anytime soon, so future contributors have to keep it in mind.

The program is available in six different languages: English, Italian, Spanish, Albanian, Russian and Arabic.

You can fork and modify the code inside this GitHub repository, however, you want, keeping the original's author name.

## Installation
The installation process does not depend on the platform your PC is based, so both methods shown should be equal, no matter if you run Microsoft Windows, macOS or Linux.

### GitHub releases
To install School Accounting Studio, head over the release tab on the right side of the repository you are currently in and click on the desired version of the program to be downloaded.

Download the `build_0.0.x.zip` archive. Once done, extract all the content of the archive in a desired directory; at this point you'll have School Accounting Studio installed on your machine.

### Git
School Accounting Studio is recommended to be installed with `git` client on your machine to provide you full access and control over the compilation and building process.

To start, you have to have JDK installed on your computer. Notice that the program requires at least version 18 of JDK.
### Windows
```shell
winget install Oracle.JDK.18
```

### macOS
```shell
brew install java
```

### Linux (Debian distributions)
```shell
sudo apt update
sudo apt upgrade -y
sudo apt install openjdk-18
```
Then in the same terminal you can type the following command specifying the `YourDirectory` path:
```shell
git clone https://github.com/Artiom-Astashonak/school-accounting-studio.git YourDirectory
```

Once done, you will have source code of the program that can be run with your preferred IDE or can be built from source to satisfy your own requirements.

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
  |- schoolaccountingstudio-ui              UI components
  |- schoolaccountingstudio-utils           Utility classes, enums and data
  |- src                                    Source folder for the main class
```

## Requirements
| ***Module name*** | ***Description*** | ***Use case*** | ***Version*** |
| --- | --- | --- | --- |
| Java Development Kit | Java Development Kit offers the Java Virtual Machine, Java Runtime Environment and tons of tools and support libraries to write and debug Java code. | Application development on any platform | 18.0.0+       |

## Dependencies
The project relies on the following dependencies to be developed and driven or function properly without errors or unexpected behavior.

| ***Dependency name*** | ***Dependency description*** | ***Dependency version*** |
| --- | --- | --- |
| Jupiter JUnit | JUnit is a Java unit testing framework, developed by the junit-team, that provides different tools to test and configure the application during the development. | 5.8.1 |
| JetBrains Annotations Pack | JetBrains Annotations is a library that provides different annotations for JVM-driven languages. | - |

## Contribution
Before contributing to the source code of the application, it's necessary to read the [contribution guideline](https://github.com/Artiom-Astashonak/school-accounting-studio/blob/master/CONTRIBUTING.md) on the GitHub repository that's available for everyone. The guideline represents the style and requirements for the codebase of the project.

Cases that don't follow the contribution guidelines are going to be asked to be refactored and reformatted. A pull request can be merged only, and only if it respects the guidelines and gets a code review.

The main developer and owner of the project is [Artiom Astashonak](https://github.com/Artiom-Astashonak). Any questions relayed on the project implementations and ideas can be managed directly to him.

You can find the list of all other contributors in the `CREDITS.txt` file. Anyone supporting and maintaining this project can include their name and e-mail address in the format specified in the same file.

## Already known issues
Here you can find a list of issues already known to the developers, so you don't need to open a new issue or submit a pull request yourself.

## Social media
The project has a [Telegram channel](https://t.me/schoolaccountingstudio) with fresh news and announces of the project features and decisions made by the owner.
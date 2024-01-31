# School Accounting Studio Coding Guidelines
School Accounting Studio is an open-source project, in which every enthusiast can participate, constantly improving the project's functionality and simplifying its operation.

However, for your pull request to be reviewed and ultimately merged into the main branch, it is necessary to follow simple and straightforward code writing rules.

Every developer who opens a pull request agrees to and accepts all the rules written below.

## Communication
All changes, from writing code to documentation and creating a pull request, must be made exclusively in the English language.

## Use the latest code version
When developing your own functionality for the product, always use the latest available code version located on the `master` branch. This ensures 100% compatibility and the absence of old bugs and errors previously present in the code.

In case the master branch is updated during the development of your ideas, it is necessary to obtain the data from it using `git pull` and continue your work.

## Documentation of new features
The code you write should be documented in the JavaDoc format. This rule applies especially to universal components that may be used by various packages.

Commenting is considered an undesirable practice for the project, especially if the comments do not contain any non-obvious and important information.

## Writing Tests
New project implementations must be tested using appropriate tools (JUnit 5.8.1). Mandatory for testing is the scope of application of the new code chunk and its compatibility with previously created components of the project.

This part ensures the elimination of simple errors and prevents code regression during the development stage.

## Formatting
Code formatting is a crucial part of the project. The following sub-rules of this section are listed below:
* Use 2 spaces instead of tabs for indentation.
* Constants must be written in uppercase following the snake case style.

## Commits
To avoid unnecessary comments during the commit review stage, it is recommended to follow the following simple rules that will expedite the verdict process:
* **Description of changes**. You should list all the changes you made without going into details.
* **Work breakdown**. Do not try to fix more than one issue within a single commit.
* **Configuration files**. Do not modify configuration files unless it is necessary to achieve the desired result.
* **Miscellaneous**. Try to avoid renaming variables, as well as changing the location of files and project dependencies.

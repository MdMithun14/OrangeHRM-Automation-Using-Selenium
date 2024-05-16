## OrangeHRM Management System Automation
This project aims to automate the testing of OrangeHRM management system using Selenium WebDriver and TestNG, with reporting done using Allure. It covers various scenarios such as admin login, employee creation, searching for employees, updating employee information, and more.

 ## Overview
 This project automates the testing of an HR management system, covering various functionalities such as admin login, employee creation, employee search, and profile updates. It uses Selenium WebDriver for browser automation, TestNG for test case management and assertions, and Allure for reporting.

# Installation
1.Clone this repository to your local machine.<br>
2.Ensure you have Java Development Kit (JDK) installed.<br>
3.Install Gradle if not already installed.<br>
4.Install TestNG plugin for your IDE (if using IntelliJ IDEA or Eclipse)..<br>
5.Install Allure command-line tool for generating reports..<br>
## Usage
1. Navigate to the project directory..<br>

2.Run the following command to install dependencies:.<br>

3.Execute the test scripts by running: gradle clean install

## Generating Allure Report
# After running the tests, execute the following command to generate the Allure report:

1.allure generate allure-results --clean -output.<br>
2.allure serve allure-results.<br>
## Screenshots
<img width="923" alt="alluretest1" src="https://github.com/MdMithun14/OrangeHRM-Automation-Using-Selenium/assets/159123567/20e52ff7-45f5-4880-9ec5-309140f2ca97">
<img width="514" alt="alluretest2" src="https://github.com/MdMithun14/OrangeHRM-Automation-Using-Selenium/assets/159123567/cc3a232e-58a4-4bc4-9d16-f7e7f0418383">

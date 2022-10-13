# Project README

# Overview
This project houses end-to-end tests for a vodacom website: https://www.vodacom.co.za/
It uses Selenium with Java as the core technologies for building tests. The test framework being used is TestNG with added reporting capabilities (e.g. HTML reports) from extent reports.

# Development Dependencies and Packages
Dependencies:
- Java SDK must be installed in your machine and a JAVA_HOME environment variable must be added pointing to java installation on Windows: https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html
- An IDE of your choice that supports Java development must be installed: this project was build using IntelliJ

Packages:
You do not need to any packages as these are already added in the POM.xml file. For your info, the following packages were used:
- selenium-java
- testng
- extentreports
- selenium-edge-driver

# How to run test
- Add a class name to the TestNG.xml file
  - Right-click on the TestNG file and select Run or Debug tests

# Reporting
- There should be some type of reporting either on the terminal or runner for whatever IDE you're using for development purposes
- For looking at the report outcome in a more user-friendly way, an HTML report is generated and can be found on the following location: ./target/extent-reports/extent-report.html 
# Gopuff_Code_Challenge

# Over view

These tests are built using Selenium and Java. They are run and results are recored with TestNG. The current test suite will execute in parallel. 


# Development environment

* Eclipse - Latest
* TestNG - Latest
* Selenium - 3.141.59
* ChromeDriver -  92.0.4515.43
* jdk - 12.0.1 


# Run environment

* jdk - 12.0.1 
* Chrome - 92
* Windows OS

# How to run

There is a zip file in the repository named test.zip. The zip file contains the compiled binaries and all of the needed libraries to run the tests.

* 1) Extract the zip file test.zip to any location
* 2) Open a command prompt and navigate to the folder "test"
* 3) Use this command to run the tests : java -cp .;./lib/*;./lib/selenium/*;./lib/selenium/libs/*;./bin org.testng.TestNG allTests.xml

Results will be in the "Test results" folder. Open "index.html" so see them.  

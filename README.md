# test-sbt
This example reads data from src\main\testfile, represents it as an list of arithmetical operations
(ASCII UTF-8 text file, filled with strings: operand1; operand2; operation; result) and tests if
operations result fields are valid.

To run application:
mvn clean test

Test results are generated as Yandex Allure .xml files in target\allure-results\.

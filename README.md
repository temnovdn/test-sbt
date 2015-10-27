# test-sbt
This example reads data from src\main\testfile, represents it as an list of arithmetical operations
(ASCII UTF-8 text file, filled with strings: operand1; operand2; operation; result) and tests if
operations result fields are valid.

Operands and result are integer numbers, operations are presented by +, -, * and / symbols.
Result could be /0 if operand2 equals 0 and operation is division (/).

To run application:
mvn clean test

Test results are generated as Yandex Allure .xml files in target\allure-results\.

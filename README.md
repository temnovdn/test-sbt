Тестовое задание Java

Дано

Дан файл вида: 

data file

operand1;operand2;operation;result

operand1;operand2;operation;result

operand1;operand2;operation;result

operand1;operand2;operation;result

каждая строка описывает арифметическое действие. 

·        operand1 и operand2 - операнды, целые числа

·        operation - арифметическое действие + - / *

·        result - результат операции operation над operand1 и operand2

В файле могут содержаться любые значения полей

Требуется

·        Реализовать юнит (JUnit) тесты арифметических действий.

·         Каждое действие должно выглядеть в отчете как отдельный тестовый сценарий

·        Результатом выполнения должен быть Yandex.Allure отчет

·        Операнды, операция и результат должны быть представлены в отчете как параметры теста

·        Проект должен быть оформлен как артефакт Maven

·        Исходный код проекта должен быть выложен на github или bitbucket


# test-sbt
This example reads data from src\main\testfile, represents it as an list of arithmetical operations
(ASCII UTF-8 text file, filled with strings: operand1; operand2; operation; result) and tests if
operations result fields are valid.

Operands and result are integer numbers, operations are presented by +, -, * and / symbols.
Result could be /0 if operand2 equals 0 and operation is division (/).

To run application:
mvn clean test

Test results are generated as Yandex Allure .xml files in target\allure-results\.

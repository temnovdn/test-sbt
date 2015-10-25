package com.github.temnovdn.steps;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Everyone on 25.10.2015.
 */
public final class AllureSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(AllureSteps.class);
    private static final String ACTUAL_RESULT = "Actual result: ";

    private AllureSteps() {
    }

    @Step
    public static void addTest(final String operand1, final String operand2, final String result) {
        LOGGER.info(String.format("Testing: %s + %s = %s", operand1, operand2, result));
        final int expectedResult = Integer.parseInt(result);
        final int actualResult = Integer.parseInt(operand1) + Integer.parseInt(operand2);
        LOGGER.info(ACTUAL_RESULT + actualResult);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Step
    public static void subtractTest(final String operand1, final String operand2, final String result) {
        LOGGER.info(String.format("Testing: %s - %s = %s", operand1, operand2, result));
        final int expectedResult = Integer.parseInt(result);
        final int actualResult = Integer.parseInt(operand1) - Integer.parseInt(operand2);
        LOGGER.info(ACTUAL_RESULT + actualResult);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Step
    public static void multiplyingTest(final String operand1, final String operand2, final String result) {
        LOGGER.info(String.format("Testing: %s * %s = %s", operand1, operand2, result));
        final int expectedResult = Integer.parseInt(result);
        final int actualResult = Integer.parseInt(operand1) * Integer.parseInt(operand2);
        LOGGER.info(ACTUAL_RESULT + actualResult);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Step
    public static void divisionTest(final String operand1, final String operand2, final String result) {
        LOGGER.info(String.format("Testing: %s / %s = %s", operand1, operand2, result));
        final int expectedResult = Integer.parseInt(result);
        final int actualResult;
        try {
            actualResult = Integer.parseInt(operand1) / Integer.parseInt(operand2);
            LOGGER.info(ACTUAL_RESULT + actualResult);
            Assert.assertEquals(expectedResult, actualResult);
        } catch (ArithmeticException ex) {
            Assert.assertEquals(ex.getMessage(), "/ by zero");
            LOGGER.info("Divide by zero exception caught");
        }
    }
}

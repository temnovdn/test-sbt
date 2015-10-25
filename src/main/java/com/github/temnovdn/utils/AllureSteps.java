package com.github.temnovdn.utils;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Everyone on 25.10.2015.
 */
public class AllureSteps {
    public final Logger LOGGER = LoggerFactory.getLogger(AllureSteps.class);

    @Step
    public void addTest(final String operand1, final String operand2, final String result) {
        int expectedResult = Integer.parseInt(result);
        int actualResult = Integer.parseInt(operand1) + Integer.parseInt(operand2);
        LOGGER.info(String.format("Actual result: %s", result));
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Step
    public void subtractTest(final String operand1, final String operand2, final String result) {
        int expectedResult = Integer.parseInt(result);
        int actualResult = Integer.parseInt(operand1) - Integer.parseInt(operand2);
        LOGGER.info(String.format("Actual result: %s", result));
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Step
    public void multiplyingTest(final String operand1, final String operand2, final String result) {
        int expectedResult = Integer.parseInt(result);
        int actualResult = Integer.parseInt(operand1) * Integer.parseInt(operand2);
        LOGGER.info(String.format("Actual result: %s", result));
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Step
    public void divisionTest(final String operand1, final String operand2, final String result) {
        float expectedResult = Float.parseFloat(result);
        float actualResult;
        try {
            actualResult = Integer.parseInt(operand1) / Integer.parseInt(operand2);
            LOGGER.info(String.format("Actual result: %s", result));
            Assert.assertEquals(expectedResult, actualResult, 1e-10);
        } catch (ArithmeticException ex) {
            LOGGER.info("Actual result: / by zero exception caught");
            Assert.assertEquals(ex.getMessage(), "/ by zero");
        }
    }
}

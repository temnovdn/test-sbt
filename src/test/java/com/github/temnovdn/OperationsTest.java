package com.github.temnovdn;

import com.github.temnovdn.utils.FileReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by dmitrytemnov on 16/10/15.
 */
@RunWith(value = Parameterized.class)
public class OperationsTest {
    private String operand1;
    private String operand2;
    private String operation;
    private String result;

    private static final Logger LOGGER = LoggerFactory.getLogger(OperationsTest.class);

    public OperationsTest(String operand1, String operand2, String operation, String result) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.result = result;
    }

    @Parameterized.Parameters
    public static List<String[]> testData() {

        final ArrayList<String[]> data = FileReader.readFile("src/main/resourses/testfile");

        return data;
    }

    @Test
    public void test() {

        LOGGER.info(String.format("Testing: %s %s %s = %s", operand1, operation, operand2, result));

        if (operation.equals("+")) {
            int expectedResult = Integer.parseInt(result);
            int actualResult = Integer.parseInt(operand1) + Integer.parseInt(operand2);
            LOGGER.info(String.format("Actual result: %s", result));
            Assert.assertEquals(expectedResult, actualResult);

        } else if (operation.equals("-")) {
            int expectedResult = Integer.parseInt(result);
            int actualResult = Integer.parseInt(operand1) - Integer.parseInt(operand2);
            LOGGER.info(String.format("Actual result: %s", result));
            Assert.assertEquals(expectedResult, actualResult);

        } else if (operation.equals("*")) {
            int expectedResult = Integer.parseInt(result);
            int actualResult = Integer.parseInt(operand1) * Integer.parseInt(operand2);
            LOGGER.info(String.format("Actual result: %s", result));
            Assert.assertEquals(expectedResult, actualResult);

        } else if (operation.equals("/")) {
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

        } else {
            LOGGER.info("Wrong operation type");
        }
    }
}

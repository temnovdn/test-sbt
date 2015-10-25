package com.github.temnovdn;

import com.github.temnovdn.steps.AllureSteps;
import com.github.temnovdn.utils.FileReader;
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

        if (operation.equals("+")) {
            AllureSteps.addTest(operand1, operand2, result);

        } else if (operation.equals("-")) {
            AllureSteps.subtractTest(operand1, operand2, result);

        } else if (operation.equals("*")) {
            AllureSteps.multiplyingTest(operand1, operand2, result);

        } else if (operation.equals("/")) {
            AllureSteps.divisionTest(operand1, operand2, result);

        } else {
            LOGGER.info("Wrong operation type");
        }
    }
}

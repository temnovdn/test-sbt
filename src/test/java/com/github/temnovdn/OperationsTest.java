package com.github.temnovdn;

import com.github.temnovdn.utils.FileReader;
import org.junit.Test;

import java.util.ArrayList;

import com.github.temnovdn.AssertWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by dmitrytemnov on 16/10/15.
 */
public class OperationsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(OperationsTest.class);

    @Test
    public void test() {
        final ArrayList<String[]> operations = FileReader.readFile("src/main/resourses/testfile");

        for (String[] row: operations ) {
            Integer operand1 = Integer.parseInt(row[0]);
            Integer operand2 = Integer.parseInt(row[1]);
            char operation = row[2].charAt(0);
                double result = Double.valueOf(row[3]);

            switch (operation) {
                case '+':
                    AssertWrapper.plusAndAssert(operand1, operand2, result);
                    break;
                case '-':
                    AssertWrapper.minusAndAssert(operand1, operand2, result);
                    break;
                case '*':
                    AssertWrapper.multiplyAndAssert(operand1, operand2, result);
                    break;
                case '/':
                    AssertWrapper.divideAndAssert(operand1, operand2, result);
            }
        }

    }
}

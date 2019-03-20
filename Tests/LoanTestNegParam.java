import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class LoanTestNegParam {


    private double amount;
    private int period;

    public LoanTestNegParam( double amount, int period) {
        this.amount = amount;
        this.period = period;

    }

    @Parameterized.Parameters(name = "{index}: checkRate(IllegalArgumentException)={0}")
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][]{
                {9999.99, 6}, //Out of bounds should pass but doesn't. - FAIL
                {500.01, 0},    //Out of bounds should pass but doesn't. - FAIL
                {499.99, 1}, //Correct - Pass
                {10000.01, 5}, //Correct - Pass
                {6000, 'b'}, //Character in period section should pass but doesn't so according to the code it's valid! - FAIL
                {'X', 1}, //Correct - Pass
                {null,2}, //Says java.lang.IllegalArguementException but doesn't pass the test. - FAIL
                {599.99,null}, //Says java.lang.IllegalArguementException but doesn't pass the test. - FAIL
                {5000.01,3}, // Correct - Pass
                {5000.99,4}, //Correct - Pass

                // 5 out of 10 tests run successfully
        });
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRate() {
        Loan loan = new Loan(amount, period);

    }

}
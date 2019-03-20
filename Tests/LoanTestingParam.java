import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class LoanTestingParam {

    private double expected;
    private double amount;
    private int period;

    public LoanTestingParam(int expected, double amount, int period) {
        this.expected = expected;
        this.amount = amount;
        this.period = period;

    }

    @Parameterized.Parameters(name = "{index}: checkRate({1})={0}")
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][]{

                {5, 10000, 5}, //Pass - Correct
                {10, 500, 1}, //Pass - Correct
                {5, 5001.01, 4}, //Pass - Correct
                {8, 5001, 2}, //Pass - Correct
                {10, 4999.99, 3}, //Pass - Correct
                {6, 5000, 4}, //Pass - Correct
                {8, 9999.99, 3}, //Pass - Correct
                {6, 500.01, 5}, // Pass - Correct

        });
    }

    @Test
    public void testRate() {
        Loan loan = new Loan(amount, period);
        assertEquals(expected, loan.getRate(), 0.00);
    }
}
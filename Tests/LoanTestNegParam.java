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

    @Parameterized.Parameters(name = "{index}: checkRate(IllegalArgumentExeption)={0}")
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][]{
                {9999.99, 6},
                {500.01, 0},
                {499.99, 1},
                {10000.01, 5},
                {6000, 'b'},
                {'X', 1},
                {null,2},
                {599.99,null},
        });
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRate() {
        Loan loan = new Loan(amount, period);
    }
}
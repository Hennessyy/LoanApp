import org.junit.Test;

import static org.junit.Assert.*;

public class LoanTesting {


    Loan loan = new Loan(500,1);


    @Test
    public void testLoanInstance() {

        assertEquals(500,(double)loan.getAmount(),0.00);
        assertEquals(1,loan.getPeriod());

    }


    //If if I comment out the setPeriod and setRate in the constructor this will turn to be positive otherwise it is negative

    @Test
    public void testLoanGetAmount(){
        assertEquals(500,loan.getAmount(),0.00);
    }

    @Test
    public void testLoanGetPeriod(){
        assertEquals(1,loan.getPeriod());
    }

    @Test
    public void testLoanGetRate(){
        assertEquals(10,loan.getRate(),0.00);
    }

    @Test
    public void testLoanMonthlyPayment(){
        assertEquals(43.95,loan.getMonthlyPayment(),0.01);
    }

    @Test
    public void testLoanTotalPayment(){
        assertEquals(550,loan.getTotalPayment(),0.00);
    }
}

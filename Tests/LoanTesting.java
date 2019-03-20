import org.junit.Test;

import static org.junit.Assert.*;

public class LoanTesting {


    Loan loan = new Loan(500,1);
    Loan secondLoan = new Loan (10000,5);


    @Test
    public void testLoanInstance() {

        assertEquals(500,loan.getAmount(),0.00);
        assertEquals(1,loan.getPeriod());
        assertEquals(10000,secondLoan.getAmount(),0.00);
        assertEquals(5,secondLoan.getPeriod(),0.00);

    }


    //If if I comment out the setPeriod and setRate in the constructor this will turn to be positive otherwise it is negative

    @Test
    public void testLoanGetAmount(){
        assertEquals(500,loan.getAmount(),0.00);
    }

    @Test
    public void testLoanGetAmountTwo(){
        assertEquals(10000,secondLoan.getAmount(),0.00);
    }

    @Test
    public void testLoanGetPeriod(){
        assertEquals(1,loan.getPeriod());
    }

    @Test
    public void testLoanGetPeriodTwo(){
        assertEquals(5,secondLoan.getPeriod(),0.00);
    }

    @Test
    public void testLoanGetRate(){
        assertEquals(10,loan.getRate(),0.00);
    }

    @Test
    public void testLoanGetRateTwo(){assertEquals(5,secondLoan.getRate(),0.00);}

    @Test
    public void testLoanMonthlyPayment(){
        assertEquals(43.95,loan.getMonthlyPayment(),0.01);
    }

    @Test
    public void testLoanMonthlyPaymentTwo(){
        assertEquals(188.71,secondLoan.getMonthlyPayment(),0.01);
    }

    @Test
    public void testLoanTotalPayment(){
        assertEquals(527.49,loan.getTotalPayment(),0.01);
    }

    @Test
    public void testLoanTotalPaymentTwo(){
        assertEquals(11322.74,secondLoan.getTotalPayment(),0.01);
    }
}

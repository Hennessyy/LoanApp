import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static junit.framework.TestCase.assertEquals;
import static org.easymock.EasyMock.expect;
import static org.powermock.api.easymock.PowerMock.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Customer.class)

public class CustomerTest {
    @Test
    public void testGetMonthlyPayments() throws Exception {
        //Creating customer
        Customer customer = new Customer("Leon");
        customer.takeoutloan();

        //Creating mock objects
        Loan mockLoan = EasyMock.createMock(Loan.class);
        Customer mockCust = EasyMock.createMock(Customer.class);

        PowerMock.expectNew(Loan.class, (double)5000,5).andReturn(mockLoan);

        mockCust.takeoutloan();
        //Expected Result
        expect(mockCust.getMonthlypayments()).andReturn(96.66);


        PowerMock.replay(mockCust,Customer.class);
        PowerMock.replay(mockLoan, Loan.class);


        double expected = customer.getMonthlypayments();
        double result = mockCust.getMonthlypayments();

        //Expecting a result of 96.66 based off a €5000 loan over 5 years from the Customer takeoutloan method

        assertEquals(expected, result, 0.01);

        verify(mockLoan, Customer.class);

    }
}
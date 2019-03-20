import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.TestCase.assertEquals;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.powermock.api.easymock.PowerMock.replay;
import static org.powermock.api.easymock.PowerMock.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Customer.class)

public class CustomerTest {
    @Test
    public void testGetMonthlyPayments() throws Exception {
        Customer customer = new Customer("Leon");
        customer.takeoutloan();


        Loan mockLoan = EasyMock.createMock(Loan.class);
        Customer mockCust = EasyMock.createMock(Customer.class);

        PowerMock.expectNew(Loan.class, (double)5000,5).andReturn(mockLoan);

        mockCust.takeoutloan();
        expect(mockCust.getMonthlypayments()).andReturn(96.66);


        PowerMock.replay(mockCust,Customer.class);
        PowerMock.replay(mockLoan, Loan.class);


        double expected = customer.getMonthlypayments();
        double result = mockCust.getMonthlypayments();

        assertEquals(expected, result, 0.01);

        verify(mockLoan, Customer.class);

    }
}
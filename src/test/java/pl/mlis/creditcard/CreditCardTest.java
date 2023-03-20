package pl.mlis.creditcard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class CreditCardTest {
    @Test
    void itAllowsToAssignCreditLimit() {
        //Arrange
        CreditCard card = new CreditCard("1234-5678");
        //Act
        card.assignCredit(BigDecimal.valueOf(1000));
        //Assert
        assertEquals(BigDecimal.valueOf(1000), card.getBalance());
        assert card.getBalance().equals(BigDecimal.valueOf(1000));
    }

    @Test
    void itAllowsToAssignDifferentCreditLimit() {
        //Arrange
        CreditCard card1 = new CreditCard("12345-56789");
        CreditCard card2 = new CreditCard("98765-54321");
        //Act
        card1.assignCredit(BigDecimal.valueOf(1000));
        card2.assignCredit(BigDecimal.valueOf(1100));
        //Assert
        assertEquals(BigDecimal.valueOf(1000), card1.getBalance());
        assertEquals(BigDecimal.valueOf(1100), card2.getBalance());

    }

    @Test
    void itCanAssignLimitBelow100V1() {
        CreditCard card = new CreditCard("1234-4567");

        try {
            card.assignCredit(BigDecimal.valueOf(50));
            fail("Should throw exception");
        } catch (CreditBelowThresholdException e) {
            assertTrue(true);
        }

    }

    @Test
    void itCanAssignLimitBelow100() {
        CreditCard card1 = new CreditCard("1234-4567");
        CreditCard card2 = new CreditCard("12345-56789");
        CreditCard card3 = new CreditCard("98765-54321");

        assertThrows(CreditBelowThresholdException.class,
                () -> card1.assignCredit(BigDecimal.valueOf(10)));

        assertThrows(CreditBelowThresholdException.class,
                () -> card2.assignCredit(BigDecimal.valueOf(99)));

        assertDoesNotThrow(() -> card3.assignCredit(BigDecimal.valueOf(100)));
    }

    @Test
    void itCannotAssignLimitTwice() {
        CreditCard card = new CreditCard("1234-4567");
        CreditCard card2 = new CreditCard("12345-56789");
        CreditCard card3 = new CreditCard("98765-54321");

        card.assignCredit(BigDecimal.valueOf(1000));

        assertThrows (
                LimitAssignedTwiceException.class,
                () -> card.assignCredit(BigDecimal.valueOf(1100))
        );
    }

    @Test
    void itAllowsToWithdraw() {
        CreditCard card = new CreditCard("1234-4567");
        card.assignCredit(BigDecimal.valueOf(1000));

        card.withdraw(BigDecimal.valueOf(100));

        assertEquals(BigDecimal.valueOf(900), card.getBalance());
    }

    @Test
    void testDoubleAndFloat() {
        /*
        double x1 = 0.03;
        double x2 = 0.01;

        double result = x1-x2;

        System.out.println(result);
         */
    }
}

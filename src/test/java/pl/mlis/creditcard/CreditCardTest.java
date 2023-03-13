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
        card.assignLimit(BigDecimal.valueOf(1000));
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
        card1.assignLimit(BigDecimal.valueOf(1000));
        card2.assignLimit(BigDecimal.valueOf(1100));
        //Assert
        assertEquals(BigDecimal.valueOf(1000), card1.getBalance());
        assertEquals(BigDecimal.valueOf(1000), card2.getBalance());

    }

    @Test
    void itCanAssignLimitBelow100() {
        CreditCard card = new CreditCard("1234-4567");

        try {
            card.assignLimit(BigDecimal.valueOf(50));
            fail("Should throw exception");
        } catch (CreditBelowThresholdException e) {
            assertTrue(true);
        }

        assertThrows(CreditBelowThresholdException.class,
                () -> card.assignLimit(BigDecimal.valueOf(10)));

        assertThrows(CreditBelowThresholdException.class,
                () -> card.assignLimit(BigDecimal.valueOf(99)));
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

package pl.mlis.creditcard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class CreditCardTest {
    /*@Test
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
        assertEquals(BigDecimal.valueOf(1100), card2.getBalance());

    }

    @Test
    void itCanAssignLimitBelow100V1() {
        CreditCard card = new CreditCard("1234-4567");

        try {
            card.reassignLimit(BigDecimal.valueOf(50));
            fail("Should throw exception");
        } catch (CreditBelowThresholdException e) {
            assertTrue(true);
        }

    }*/

    @Test //punkt 1
    void cannotAssignLimitBelow100() {
        CreditCard card1 = new CreditCard("1234-4567");
        CreditCard card2 = new CreditCard("12345-56789");
        CreditCard card3 = new CreditCard("98765-54321");

        assertThrows(CreditBelowThresholdException.class,
                () -> card1.assignLimit(BigDecimal.valueOf(10)));

        assertThrows(CreditBelowThresholdException.class,
                () -> card2.assignLimit(BigDecimal.valueOf(99)));

        assertDoesNotThrow(() -> card3.assignLimit(BigDecimal.valueOf(100)));
    }

    @Test //punkt 1
    void itCannotAssignLimitTwice() {
        CreditCard card = new CreditCard("1234-4567");

        card.assignLimit(BigDecimal.valueOf(1000));

        assertThrows (
                LimitAssignedTwiceException.class,
                () -> card.assignLimit(BigDecimal.valueOf(1100))
        );
    }

    @Test //punkt 2
    void cantReassignLimitBelow100(){
        CreditCard card = new CreditCard("1234-4567");

        assertThrows(CreditBelowThresholdException.class,
                () -> card.reassignLimit(BigDecimal.valueOf(10)));

        assertThrows(CreditBelowThresholdException.class,
                () -> card.reassignLimit(BigDecimal.valueOf(99)));

        assertDoesNotThrow(() -> card.reassignLimit(BigDecimal.valueOf(100)));
    }

    /*@Test
    void itAllowsToWithdraw() {
        CreditCard card = new CreditCard("1234-4567");
        card.assignCredit(BigDecimal.valueOf(1000));

        card.withdraw(BigDecimal.valueOf(100));

        assertEquals(BigDecimal.valueOf(900), card.getBalance());
    }*/

    @Test //punkt 3
    void cannotWithdrawOverLimit(){
        CreditCard card = new CreditCard("1234-4567");

        card.assignCredit(BigDecimal.valueOf(10));
        assertThrows(NotEnoughMoneyException.class, () -> card.withdraw(BigDecimal.valueOf(50)));
    }

    @Test //punkt 3
    void cannotWithdrawNotEnoughMoney(){
        CreditCard card = new CreditCard("1234-4567");

        card.assignCredit(BigDecimal.valueOf(10));
        assertThrows(NotEnoughMoneyException.class, () -> card.withdraw(BigDecimal.valueOf(50)));
    }

    @Test //punkt 3
    void cannotWithdrawMoreThan10Times(){
        CreditCard card = new CreditCard("1234-4567");

        card.assignCredit(BigDecimal.valueOf(1000));
        for (int i = 0; i <= 10; i ++){
            assertDoesNotThrow(() -> card.withdraw(BigDecimal.valueOf(10)));
        }
        assertThrows(TooManyWithdrawalsInOneCycle.class, () -> card.withdraw(BigDecimal.valueOf(10)));
    }

}

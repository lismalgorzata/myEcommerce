package pl.mlis.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    String cardNumber;
    BigDecimal balance;
    BigDecimal limit;
    boolean isAssigned;
    BigDecimal withdrawCycle;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
        this.withdrawCycle = BigDecimal.valueOf(0);
        this.isAssigned = false;
    }

    public void assignLimit(BigDecimal creditAmount) {

        if (this.isAssigned) {
            throw new LimitAssignedTwiceException();
        }

        if (isBelowCreditThreshold(creditAmount)) {
            throw new CreditBelowThresholdException();
        }

        this.limit = creditAmount;
        this.isAssigned = true;
    }

    private static boolean isBelowCreditThreshold(BigDecimal creditAmount) {
        return creditAmount.compareTo(BigDecimal.valueOf(100)) < 0;
    }

    public void assignCredit(BigDecimal creditAmount) {
        this.balance = creditAmount;
    }

    public void reassignLimit(BigDecimal creditAmount) {
        if (creditAmount.compareTo(BigDecimal.valueOf(100)) < 0) {
            throw new CreditBelowThresholdException();
        }
        this.limit = creditAmount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void withdraw(BigDecimal withdrawal) {

        if (this.balance.compareTo(withdrawal) < 0){
            throw new NotEnoughMoneyException();
        }

        if (withdrawal.compareTo(BigDecimal.valueOf(100)) > 0){
            throw new TooMuchToWithdrawException();
        }

        if (withdrawCycle.compareTo(BigDecimal.valueOf(10)) > 0){
            throw new TooManyWithdrawalsInOneCycle();
        }

        this.balance = balance.subtract(withdrawal);
        this.withdrawCycle = this.withdrawCycle.add(BigDecimal.valueOf(1));

    }
}

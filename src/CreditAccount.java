// information from credit account is made here

public class CreditAccount extends Account {
    protected double creditLimit;
    protected double interestRate;

    public CreditAccount(double limit, double interestRate) {
        super(0);
        this.creditLimit = limit;
        this.interestRate = interestRate;
    }

    public void useCredit(double amount) {
        if (balance + amount <= creditLimit) {
            balance += amount;
            System.out.println("Charged $" + amount + " to credit account.");
        } else {
            System.out.println("Credit limit exceeded.");
        }
    }

    public void makePayment(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Paid $" + amount + " toward credit balance.");
        } else {
            System.out.println("Payment exceeds balance.");
        }
    }

    /** Getter for the credit limit, used in MenuUtils */
    public double getCreditLimit() {
        return creditLimit;
    }

    @Override
    public String toString() {
        return String.format(
                "[Credit] Balance: $%.2f | Limit: $%.2f | APR: %.2f%%",
                balance, creditLimit, interestRate * 100
        );
    }
}

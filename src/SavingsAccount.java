// simple savings with daily interest
public class SavingsAccount extends Account {
    private double interestRate; // e.g. 0.02 = 2% // also encapsulation req 18
// // This constructor calls the superclass constructor to set the initial balance.
    public SavingsAccount(double initialBalance, double interestRate) {
        super(initialBalance); // // Call to abstract superclass Account to set the balance | 16
        this.interestRate = interestRate;
    }

    // Abstraction,  method implements the abstract applyInterest() method from the Account class.
    // In the Account class, the method is declared abstract, but in the SavingsAccount, we define the logic
    // for how interest is applied specifically for a savings account.
    // Call this method each day to apply interest to the account.
    public void applyInterest() {
        double interest = balance * interestRate / 365;
        deposit(interest, "Interest");
    }

    @Override
    public String toString() {
        return String.format("[Savings] %s | APR: %.2f%%",
                super.toString(), interestRate * 100);
    }
}

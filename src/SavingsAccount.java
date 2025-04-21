// simple savings with daily interest
public class SavingsAccount extends Account {
    private double interestRate; // e.g. 0.02 = 2%

    public SavingsAccount(double initialBalance, double interestRate) {
        super(initialBalance);
        this.interestRate = interestRate;
    }

    // call this each day
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

import java.time.LocalDate;

// handles credit balance, limit, APR, due dates, etc.
public class CreditAccount extends Account {
    protected double creditLimit;
    protected double interestRate;
    private LocalDate closingDate;  // next statement closing
    private LocalDate dueDate;      // next minimum due

    public CreditAccount(double limit, double interestRate) {
        super(0);
        this.creditLimit = limit;
        this.interestRate = interestRate;
        // assume cycle closes in 30 days, due 5 days later
        this.closingDate = LocalDate.now().plusDays(30);
        this.dueDate     = closingDate.plusDays(5);
    }

    // use your credit card
    public void useCredit(double amount) {
        if (balance + amount <= creditLimit) {
            balance += amount;
            System.out.println("Charged $" + amount + " to credit account.");
        } else {
            System.out.println("Credit limit exceeded.");
        }
    }

    // pay off some or all
    public void makePayment(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Paid $" + amount + " toward credit balance.");
        } else {
            System.out.println("Payment exceeds balance.");
        }
    }

    // helper: minimum due = 5% of balance
    public double getMinimumDue() {
        return Math.max(25, balance * 0.05);
    }

    // how much credit you still have left
    public double getAvailableCredit() {
        return creditLimit - balance;
    }

    public LocalDate getClosingDate() { return closingDate; }
    public LocalDate getDueDate()     { return dueDate;     }

    @Override
    public String toString() {
        return String.format(
                "[Credit] Balance: $%.2f | Limit: $%.2f | APR: %.2f%%",
                balance, creditLimit, interestRate * 100
        );
    }
}

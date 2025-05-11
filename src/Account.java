import java.util.Random; // Requirement 19: Using Java library class

// this is the Account class: stores balance & a 6-digit ID to make account number "realistic", random gen
public class Account { // Requirement 17: Inheritance (Base class)
    protected double balance; // Requirement 2: Variable
    protected String accountId;

    // Requirement 14: Constructor
    public Account(double initialBalance) {
        this.balance = initialBalance; // Requirement 21: this Keyword
        // Requirement 19: Random for account ID
        this.accountId = String.format("%06d", new Random().nextInt(1_000_000)); // Requirement 6: String method (format)
    }

    // Requirement 10: Method overloading (overloaded deposit method)
    public void deposit(double amount) { // Requirement 9: Passing argument by value
        deposit(amount, "General");
    }

    public void deposit(double amount, String source) {
        balance += amount; // Requirement 5: Assignment & arithmetical operator
        System.out.println("Deposited $" + amount + " (" + source + ")"); // Requirement 23: println
    }

    public void withdraw(double amount) {
        // Requirement 5: Logical operator
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public String toString() {
        // Requirement 23: printf-style format using String.format
        return String.format("Account ID: %s | Balance: $%.2f", accountId, balance);
    }
}

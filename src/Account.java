import java.util.Random;

// this is the  Account class: stores balance & a 6‑digit ID to make account number "realistic", random gen
public class Account {
    protected double balance;
    protected String accountId;

    public Account(double initialBalance) {
        // set up initial balance
        this.balance = initialBalance;
        // random 6‑digit ID, set to 6 digits for aesthetic reasons, dont want it too long,
        this.accountId = String.format("%06d", new Random().nextInt(1_000_000));
    }

    // deposit without source  just calls the other one
    public void deposit(double amount) {
        deposit(amount, "General");
    }

    // deposit with a  note
    public void deposit(double amount, String source) {
        balance += amount;
        System.out.println("Deposited $" + amount + " (" + source + ")");
    }

    // take money out if you have it
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public String toString() {
        return String.format("Account ID: %s | Balance: $%.2f", accountId, balance);
    }
}

// CreditAccount.java
// Information from credit account is made here

public class CreditAccount extends Account { // Requirement 17: Inheritance (Child class)
    protected double creditLimit; // Requirement 2: Variable
    protected double interestRate;

    public CreditAccount(double limit, double interestRate) {
        super(0); // Requirement 15: super Keyword usage
        this.creditLimit = limit; // Requirement 21: this keyword
        this.interestRate = interestRate;
    }

    // Requirement 9: Passing by value
    public void useCredit(double amount) {
        // Requirement 5: Logical operator
        if (balance + amount <= creditLimit) {
            balance += amount; // Assignment and arithmetical operator
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

    // Requirement 10: Method overloading
    public void makePayment(double amount, String note) {
        makePayment(amount); // calls the basic method
        System.out.println("Note: " + note); // Requirement 23: println
    }

    /** Getter for the credit limit, used in MenuUtils */
    public double getCreditLimit() {
        return creditLimit;
    }

    // Utility method to demonstrate Requirement 8 (Loop) and 11 (Array)
    public void printRecentTransactions() {
        String[] recent = {"$50 Gas", "$100 Groceries", "$25 Subscription"};
        for (String item : recent) {
            System.out.println("Transaction: " + item); // Requirement 23
        }
    }

    @Override
    public String toString() {
        // Requirement 4: Conditional operator (e.g., warn if high usage)
        String status = (balance / creditLimit > 0.8) ? "High Usage" : "OK";

        // Requirement 6: String class method (format)
        return String.format(
                "[Credit] Balance: $%.2f | Limit: $%.2f | APR: %.2f%% | Status: %s",
                balance, creditLimit, interestRate * 100, status
        );
    }
}

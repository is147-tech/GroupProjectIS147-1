// CheckingAccount.java
// checking account: no fees or interest for now (which is how basic checking accounts work)

public class CheckingAccount extends Account { // Requirement 17: Inheritance (Child class)

    private static final String ACCOUNT_TYPE = "Checking"; // Requirement 2: Constant

    public CheckingAccount(double initialBalance) {
        super(initialBalance); // Requirement 15: super Keyword usage
    }

    // Additional method to demonstrate Requirement 8: Loop
    public void printSampleDeposits() {
        double[] samples = {100, 200, 300}; // Requirement 11: Array
        for (double amount : samples) { // Requirement 8: Loop
            System.out.println("Sample deposit: $" + amount); // Requirement 23: println
        }
    }

    @Override
    public String toString() {
        return "[" + ACCOUNT_TYPE + "] " + super.toString(); // Requirement 6: String class method (concat)
    }
}

// CheckingAccount.java
// checking account: no fees or interest for now (which is how basic checking accounts work)

public class CheckingAccount extends Account { // Requirement 17: Inheritance (Child class)

    private static final String ACCOUNT_TYPE = "Checking"; // Requirement 2: Constant

    public CheckingAccount(double initialBalance) {
        super(initialBalance); // Requirement 15: super Keyword usage
    }

    @Override
    public String toString() {
        return "[" + ACCOUNT_TYPE + "] " + super.toString(); // Requirement 6: String class method (concat)
    }
}

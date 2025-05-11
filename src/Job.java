public class Job {
    private String title;                // Requirement 2: Variable
    private double payAmount;           // Requirement 2: Variable
    private int payInterval;            // days between paychecks
    private int daysUntilPay;           // Requirement 2: Variable

    // Requirement 14: Constructor
    public Job(String title, double payAmount, int intervalDays) {
        this.title = title;              // Requirement 21: this keyword
        this.payAmount = payAmount;     // Requirement 21
        this.payInterval = intervalDays;
        this.daysUntilPay = intervalDays;
    }

    public String getTitle() {
        return title;
    }

    // Requirement 5: Logical, arithmetic, and assignment operators
    public void progressDay(User user) {
        daysUntilPay--; // arithmetic & assignment
        if (daysUntilPay <= 0) { // logical
            user.getCheckingAccount().deposit(payAmount, title + " Pay");
            daysUntilPay = payInterval;
        }
    }

    // Requirement 10: Method overloading (alternative string view)
    public String toString(boolean upperCase) {
        String base = this.toString(); // this keyword, Requirement 21
        return upperCase ? base.toUpperCase() : base; // Requirement 4: Conditional operator
    }

    // Requirement 6: String method (used in overloaded toString)
    @Override
    public String toString() {
        return String.format(
                "%s: $%.2f every %d days (next in %d)",
                title, payAmount, payInterval, daysUntilPay
        );
    }
}

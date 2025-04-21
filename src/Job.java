// jobs pay you every few days, can quit job
public class Job {
    private String title;
    private double payAmount;
    private int payInterval;   // days between paychecks
    private int daysUntilPay;  // counts down

    public Job(String title, double payAmount, int intervalDays) {
        this.title = title;
        this.payAmount = payAmount;
        this.payInterval = intervalDays;
        this.daysUntilPay = intervalDays;
    }

    public String getTitle() { return title; }

    // calls this once per “day”
    public void progressDay(User user) {
        daysUntilPay--;
        if (daysUntilPay <= 0) {
            user.getCheckingAccount().deposit(payAmount, title + " Pay");
            daysUntilPay = payInterval;
        }
    }

    @Override
    public String toString() {
        return String.format(
                "%s: $%.2f every %d days (next in %d)",
                title, payAmount, payInterval, daysUntilPay
        );
    }
}

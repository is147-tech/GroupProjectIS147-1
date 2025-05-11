import java.util.ArrayList;
import java.util.List;

// user holds all their accounts, jobs, etc.
public class User {
    private String firstName, lastName, password;
    private SavingsAccount savings;
    private CheckingAccount checking;
    private CreditCard creditCard;      // chosen card
    private List<Job> jobs;

    public User(String fName, String lName, String pwd) {
        this.firstName = fName;
        this.lastName  = lName;
        this.password  = pwd;
        this.savings   = new SavingsAccount(0, 0.02);
        this.checking  = new CheckingAccount(0);
        this.creditCard = null;
        this.jobs      = new ArrayList<>();
    }

    public boolean checkPassword(String input) {
        return password.equals(input);
    }

    public SavingsAccount getSavingsAccount() { return savings; }
    public void setSavingsAccount(SavingsAccount s) { this.savings = s; }
    public CheckingAccount getCheckingAccount() { return checking; }
    public CreditCard getCreditCard() { return creditCard; }
    public void setCreditCard(CreditCard c) { this.creditCard = c; }
    public void addJob(Job j) { jobs.add(j); }
    public void removeJob(int idx) { jobs.remove(idx); }
    public boolean hasJobs() { return !jobs.isEmpty(); }
    public List<Job> getJobs() { return jobs; }

    // apply interest + pay jobs
    public void progressDay() {
        savings.applyInterest();
        for (Job j : jobs) j.progressDay(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // creating an obect requirement 13
        sb.append("User: ").append(firstName).append(" ").append(lastName).append("\n");
        sb.append(checking).append("\n");
        sb.append(savings).append("\n");
        sb.append(creditCard != null ? creditCard : "No credit card selected").append("\n");
        sb.append("Current Jobs: ");
        if (jobs.isEmpty()) sb.append("None\n");
        else {
            for (int i = 0; i < jobs.size(); i++) {
                sb.append(jobs.get(i).getTitle());
                if (i < jobs.size()-1) sb.append(", ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

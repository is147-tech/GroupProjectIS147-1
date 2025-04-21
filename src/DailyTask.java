import java.util.Random;

// finance‑focused chores that pay up to $60 randomly
public class DailyTask {
    private String description;

    public DailyTask(String description) {
        this.description = description;
    }

    public String getDescription() { return description; }

    public void perform(User user) {
        // if it’s the special “explain” task
        if (description.startsWith("Explain")) {
            System.out.println("To pay off your credit card: prioritize high-interest debts, pay above the minimum, avoid new charges.");
            return;
        }
        // otherwise random reward up to $60
        double reward = new Random().nextInt(61);
        user.getCheckingAccount().deposit(reward, "Task Reward");
        System.out.println("Completed: " + description + " → +$" + reward);
    }
}

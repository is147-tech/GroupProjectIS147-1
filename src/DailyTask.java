import java.util.Random;
import java.util.Scanner;

// finance‑focused tasks that teach you something and pay up to $60
public class DailyTask {
    private String name;    // menu label
    private String info;    // educational content

    public DailyTask(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    /**
     * Show the advice/info; if the person confirms, award a random $0–60. just something for aesthetic
     */
    public void perform(User user, Scanner scanner) {
        System.out.println("\n--- " + name + " ---");
        System.out.println(info);
        System.out.print("Learned something? (y/n): ");
        String ans = scanner.nextLine().trim().toLowerCase();
        if (ans.equals("y")) {
            int reward = new Random().nextInt(61);
            user.getCheckingAccount().deposit(reward, "Task Reward");
            System.out.println("You earned $" + reward + "!");
        } else {
            System.out.println("No reward this time.");
        }
    }
}

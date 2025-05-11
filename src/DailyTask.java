import java.util.Random;  // Requirement 19: Java library class
import java.util.Scanner; // Requirement 1: Scanner Class

// Finance-focused tasks that teach you something and pay up to $60
public class DailyTask {
    private String name;       // Requirement 2: Variable
    private String info;       // Requirement 2: Variable
    private static final int MAX_REWARD = 60; // Requirement 2: Constant

    // Requirement 14: Constructor
    public DailyTask(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    /**
     * Show the advice/info; if the person confirms, award a random $0–60.
     */
    public void perform(User user, Scanner scanner) { // Requirement 9: Passing by value
        System.out.println("\n--- " + name + " ---"); // Requirement 23
        System.out.println(info); // Requirement 23
        System.out.print("Learned something? (y/n): "); // Requirement 23

        String ans = scanner.nextLine().trim().toLowerCase(); // Requirement 6: String class method
        // Requirement 4: Conditional operator
        String result = ans.equals("y") ? "Great job!" : "Maybe next time!";
        System.out.println(result);

        if (ans.equals("y")) { // Requirement 5: Logical operator
            int reward = new Random().nextInt(MAX_REWARD + 1); // Requirement 19: Random
            user.getCheckingAccount().deposit(reward, "Task Reward"); // Uses method from another class
            System.out.println("You earned $" + reward + "!"); // Requirement 23
        } else {
            System.out.println("No reward this time.");
        }
    }

    // Requirement 10: Method Overloading
    public void perform(User user) {
        Scanner scanner = new Scanner(System.in);
        perform(user, scanner);
        scanner.close();
    }

    // Bonus Requirement 8 & 11: Loop + Array usage
    public void miniQuiz() {
        String[] questions = {
                "What is APR?",
                "What does a budget help with?",
                "Name one type of bank account."
        }; // Requirement 11: Array

        for (String q : questions) { // Requirement 8: Loop
            System.out.println("Quiz Question: " + q); // Requirement 23
        }
    }
}

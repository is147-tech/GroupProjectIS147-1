/*
The code included in this project was created by Alim Raji | araji1@umbc.edu
For a project based on finances for IS147 Class
*/
import java.util.Random; // Requirement 19
import java.util.Scanner; // Requirement 1

public class FinanceApp {
    public static Scanner scanner = new Scanner(System.in); // Requirement 1
    public static Random random = new Random(); // Requirement 19
    public static User currentUser; // Requirement 2: Variable

    public static Job[] jobOptions = { // Requirement 2: Variable (Array)
            new Job("Barista", 75, 3),
            new Job("Tutor", 100, 5),
            new Job("Internship", 150, 7)
    };

    public static DailyTask[] tasks = { // Requirement 2
            new DailyTask("Read about bad credit cards", "Bad credit cards often have high APRs and hidden fees."),
            new DailyTask("Learn about stocks", "Stocks represent ownership in companies."),
            new DailyTask("Learn about retirement plans", "401(k), IRA, Roth IRA each have different tax rules."),
            new DailyTask("Explain how to pay off credit card", "Pay more than minimum, avoid new charges.")
    };

    public static CreditCard[] creditOptions = {
            new CreditCard("Basic Card", 500, 0.18, "No annual fee; beginner"),
            new CreditCard("Gold Card", 2000, 0.15, "Rewards on groceries & gas"),
            new CreditCard("Platinum Card", 5000, 0.12, "Premium perks; annual fee applies")
    };

    public static String[] hysaNames = { // Requirement 11: Array
            "Standard HYSA (2%)", "Premium HYSA (3%)", "Ultra HYSA (4%)"
    };

    public static double[] hysaRates = { 0.02, 0.03, 0.04 }; // Requirement 11

    public static void main(String[] args) { // Requirement 20: Static Method
        while (true) { // Requirement 8: Loop
            MenuUtils.showAuthMenu(); // Static Method usage
            MenuUtils.showMainMenu();


        }
    }

    // Requirement 9: Method returning a value
    private static int getRandomChoice() {
        return random.nextInt(3) + 1; // random 1–3
    }
}

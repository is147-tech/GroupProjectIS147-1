/*
The code included in this project was created by Alim Raji | araji1@umbc.edu
For a project based on finances for IS147 Class
 */
// main code, calls everything and stuff
import java.util.Random; // Requirement 19: Java Library Class (Random)
import java.util.Scanner; // Requirement 1: Scanner Class

public class FinanceApp {
    public static Scanner scanner = new Scanner(System.in); // Requirement 1: Scanner Class (usage)
    public static Random random = new Random(); // Requirement 19: Random Class (usage)
    public static User currentUser; // Requirement 2: Variable
    //  simple jobs, common college student jobs
    public static Job[] jobOptions = { // Requirement 2: Variable (Array of Objects)
            new Job("Barista", 75, 3),
            new Job("Tutor", 100, 5),
            new Job("Internship", 150, 7)
    };
    // daily tasks, main area where I teach users about their finances, basic right now, need more research to add here
    public static DailyTask[] tasks = { // Requirement 2: Variable (Array of Objects)
            new DailyTask(
                    "Read about bad credit cards",
                    "Bad credit cards often have high APRs and hidden fees that can trap you in debt."
            ),
            new DailyTask(
                    "Learn about stocks",
                    "Stocks represent ownership in companies; their prices go up and down with performance."
            ),
            new DailyTask(
                    "Learn about different retirement plans",
                    "401(k), traditional IRA, and Roth IRA each have different tax rules and limits."
            ),
            new DailyTask(
                    "Explain how to pay off credit card",
                    "Pay more than the minimum, target high‑interest balances first, and avoid new charges."
            )
    };
    // where I can update description for credit cards, might change format but need to explain more about it, just base examples rn?
    public static CreditCard[] creditOptions = { // Requirement 2: Variable (Array of Objects)
            new CreditCard("Basic Card",    500, 0.18, "No annual fee; beginner"),
            new CreditCard("Gold Card",    2000, 0.15, "Rewards on groceries & gas"),
            new CreditCard("Platinum Card",5000, 0.12, "Premium perks; annual fee applies")
    };
    // HYSA offers better interest rates than regular banks
    // these names arent the best but the point to realize you can get more from letting your money sit
    public static String[] hysaNames = { // Requirement 11: Array (String)
            "Standard HYSA (2%)",
            "Premium HYSA (3%)",
            "Ultra HYSA (4%)"
    };
    public static double[] hysaRates = { // Requirement 11: Array (Primitive double)
            0.02, 0.03, 0.04
    };
    // function is to call the menus and loop them, you'd see a bunch of cases in here if a menu utils wasn't created
    public static void main(String[] args) { // Requirement 20: Static Method
        while (true) { // Requirement 8: Loop
            MenuUtils.showAuthMenu(); // Requirement 20: Static Method usage
            MenuUtils.showMainMenu(); // Requirement 20: Static Method usage
        }
    }
}

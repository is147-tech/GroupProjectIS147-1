import java.util.Random;
import java.util.Scanner;

public class FinanceApp {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static User currentUser;

    public static Job[] jobOptions = {
            new Job("Barista", 75, 3),
            new Job("Tutor", 100, 5),
            new Job("Internship", 150, 7)
    };

    public static DailyTask[] tasks = {
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

    public static CreditCard[] creditOptions = {
            new CreditCard("Basic Card",    500, 0.18, "No annual fee; beginner"),
            new CreditCard("Gold Card",    2000, 0.15, "Rewards on groceries & gas"),
            new CreditCard("Platinum Card",5000, 0.12, "Premium perks; annual fee applies")
    };

    public static String[] hysaNames = {
            "Standard HYSA (2%)",
            "Premium HYSA (3%)",
            "Ultra HYSA (4%)"
    };
    public static double[] hysaRates = {
            0.02, 0.03, 0.04
    };

    public static void main(String[] args) {
        while (true) {
            MenuUtils.showAuthMenu();
            MenuUtils.showMainMenu();
        }
    }
}

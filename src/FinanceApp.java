import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// holds all the menu options
public class FinanceApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random     = new Random();
    private static User currentUser;

    // some predefined options
    private static Job[] jobOptions = {
            new Job("Barista",    75, 3),
            new Job("Tutor",     100, 5),
            new Job("Internship",150, 7)
    };

    private static DailyTask[] tasks = {
            new DailyTask("Read about bad credit cards"),
            new DailyTask("Learn about stocks"),
            new DailyTask("Learn about different retirement plans"),
            new DailyTask("Explain how to pay off credit card")
    };

    private static CreditCard[] creditOptions = {
            new CreditCard("Basic Card",    500, 0.18, "No annual fee; beginner"),
            new CreditCard("Gold Card",    2000, 0.15, "Rewards on groceries/gas"),
            new CreditCard("Platinum Card",5000, 0.12, "Premium perks; fee")
    };

    private static String[] hysaNames = {
            "Standard HYSA (2%)", "Premium HYSA (3%)", "Ultra HYSA (4%)"
    };
    private static double[] hysaRates = {0.02, 0.03, 0.04};

    public static void main(String[] args) {
        while (true) {
            showAuthMenu();   // login loop
            showMainMenu();   // everything else
        }
    }

    private static void showAuthMenu() {
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("\nWelcome: 1) Create  2) Login  3) Exit");
            int c = scanner.nextInt(); scanner.nextLine();
            switch (c) {
                case 1:
                    System.out.print("First name (no spaces): ");
                    String f = scanner.nextLine();
                    if (f.contains(" ")) { System.out.println("Invalid."); break; }
                    System.out.print("Last name (no spaces): ");
                    String l = scanner.nextLine();
                    if (l.contains(" ")) { System.out.println("Invalid."); break; }
                    System.out.print("Choose password: ");
                    String p = scanner.nextLine();
                    currentUser = new User(f, l, p);
                    System.out.println("Account created.");
                    loggedIn = true;
                    break;
                case 2:
                    if (currentUser == null) {
                        System.out.println("No account yet."); break;
                    }
                    System.out.print("Password: ");
                    if (currentUser.checkPassword(scanner.nextLine())) {
                        System.out.println("Logged in.");
                        loggedIn = true;
                    } else System.out.println("Wrong.");
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid.");
            }
        }
    }
// this happens after logining in, once logged in the loop starts -- code doesn't have an end unless exited
    private static void showMainMenu() {
        boolean session = true;
        while (session) {
            System.out.println("\nMain Menu:");
            System.out.println("1) View Accounts");
            System.out.println("2) Deposit to Savings");
            System.out.println("3) " + (currentUser.hasJobs() ? "Quit Job" : "Select Job"));
            System.out.println("4) Get a HYSA");
            System.out.println("5) Your Credit Card");
            System.out.println("6) Store");
            System.out.println("7) Do Task");
            System.out.println("8) Progress Day");
            System.out.println("9) Logout");
            System.out.println("10) Exit");
            // self-explanatory, 10 cases for each menu option
            int choice = scanner.nextInt(); scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println(currentUser);
                    break;
                case 2:
                    System.out.print("Amount to deposit: $");
                    double amt = scanner.nextDouble(); scanner.nextLine();
                    currentUser.getSavingsAccount().deposit(amt, "Manual deposit");
                    break;
                case 3:
                    if (!currentUser.hasJobs()) {
                        for (int i=0; i<jobOptions.length; i++)
                            System.out.printf("%d) %s%n", i+1, jobOptions[i]);
                        System.out.print("Pick job or 0: ");
                        int j = scanner.nextInt(); scanner.nextLine();
                        if (j>0 && j<=jobOptions.length) {
                            currentUser.addJob(jobOptions[j-1]);
                            System.out.println("Job added.");
                        }
                    } else {
                        List<Job> js = currentUser.getJobs();
                        for (int i=0; i<js.size(); i++)
                            System.out.printf("%d) %s%n", i+1, js.get(i));
                        System.out.print("Quit job or 0: ");
                        int q = scanner.nextInt(); scanner.nextLine();
                        if (q>0 && q<=js.size()) {
                            currentUser.removeJob(q-1);
                            System.out.println("Job removed.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("HYSA Options:");
                    for (int i=0; i<hysaNames.length; i++)
                        System.out.printf("%d) %s%n", i+1, hysaNames[i]);
                    System.out.print("Pick HYSA or 0: ");
                    int h = scanner.nextInt(); scanner.nextLine();
                    if (h>0 && h<=hysaRates.length) {
                        double bal = currentUser.getSavingsAccount().balance;
                        currentUser.setSavingsAccount(
                                new SavingsAccount(bal, hysaRates[h-1])
                        );
                        System.out.println(hysaNames[h-1] + " selected.");
                    }
                    break;
                case 5:
                    if (currentUser.getCreditCard()==null) {
                        System.out.println("No card selected.");
                        break;
                    }
                    showCreditMenu();
                    break;
                case 6:
                    System.out.println("Store: 1) Burger $10  2) Coffee $5  3) Cancel");
                    int s = scanner.nextInt(); scanner.nextLine();
                    if (s==1||s==2) {
                        double cost = (s==1?10:5);
                        System.out.print("Use 1) Debit  2) Credit: ");
                        int m = scanner.nextInt(); scanner.nextLine();
                        if (m==1) {
                            currentUser.getCheckingAccount().withdraw(cost);
                        } else {
                            if (currentUser.getCreditCard() != null) {
                                currentUser.getCreditCard().useCredit(cost);
                            } else {
                                System.out.println("No credit card selected.");
                            }
                        }
                    }
                    break;
                case 7:
                    System.out.println("Tasks:");
                    for (int i=0; i<tasks.length; i++)
                        System.out.printf("%d) %s%n", i+1, tasks[i].getDescription());
                    System.out.print("Pick task: ");
                    int t = scanner.nextInt(); scanner.nextLine();
                    if (t>0 && t<=tasks.length)
                        tasks[t-1].perform(currentUser);
                    break;
                case 8:
                    currentUser.progressDay();
                    System.out.println("Day progressed.");
                    break;
                case 9:
                    System.out.println("Logging out...");
                    session = false;
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("Invalid.");
            }
        }
    }

    // a like "submenu" for credit info & about
    private static void showCreditMenu() {
        CreditCard cc = currentUser.getCreditCard();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println("\n1) Status  2) About card  3) Back");
        int c = scanner.nextInt(); scanner.nextLine();
        switch (c) {
            case 1:
                System.out.printf("Owe: $%.2f%n", cc.balance);
                System.out.printf("Available: $%.2f%n", cc.getAvailableCredit());
                System.out.println("Closing date: " + cc.getClosingDate().format(fmt));
                System.out.println("Minimum due ($" + String.format("%.2f", cc.getMinimumDue())
                        + ") by " + cc.getDueDate().format(fmt));
                break;
            case 2:
                System.out.println("Minimum payment: 5% of balance or $25, whichever is greater.");
                System.out.println("APR: " + (cc.interestRate*100) + "% annually.");
                System.out.println("Closing date: statement posts; due date follows 5 days later.");
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid.");
        }
    }
}

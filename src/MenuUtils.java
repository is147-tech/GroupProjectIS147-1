

import java.util.List;
import java.util.Scanner;
// this holds all the menus, financial app calls this and loops
public class MenuUtils {
    public static Scanner scanner = FinanceApp.scanner;

    public static void showAuthMenu() {
        boolean loggedIn = false;
        while (!loggedIn) {
            // here are the cases, each option has a number and this is what happens when each is clicked
            System.out.println("\nWelcome: 1) Create  2) Login  3) Exit");
            int c = scanner.nextInt(); scanner.nextLine();
            switch (c) {
                // create account case, makes boolean loggedIn true so the loop knows to start
                case 1:
                    System.out.print("First name (no spaces): ");
                    String f = scanner.nextLine();
                    if (f.contains(" ")) { System.out.println("Invalid."); break; }
                    System.out.print("Last name (no spaces): ");
                    String l = scanner.nextLine();

                    if (l.contains(" ")) { System.out.println("Invalid."); break; }
                    System.out.print("Choose password: ");
                    String p = scanner.nextLine();
                    FinanceApp.currentUser = new User(f, l, p);
                    System.out.println("Account created.");

                    loggedIn = true;
                    break;
                    // logout and log back in case, you cant login with out a account
                // have to login with same password
                case 2:
                    if (FinanceApp.currentUser == null) {
                        System.out.println("No account exists. Create one first.");
                        break;
                    }
                    System.out.print("Password: ");
                    if (FinanceApp.currentUser.checkPassword(scanner.nextLine())) {
                        System.out.println("Logged in.");
                        loggedIn = true;
                    } else {
                        System.out.println("Wrong password.");
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
// here is the main menu, after login then the user can access their "account" and stuff
    public static void showMainMenu() {
        boolean session = true;
        while (session) {
            // This is like my layout I drew,
            /*
            So basically this is a simple way of managing finaces and doing different tasks and seeing its affects
            High yield savings account, more interest than the regular you start with
            view and choose different credit cards, how a job affects savings and managing money
            not sure how much tasks or what the job working will be like
            code loops so needs an exit/logout
            maybe a store to buy things ( not sure what yet) could evolve into a sub menu with name brand stores
            everything affects each other
             */
            System.out.println("\nMain Menu:");
            System.out.println("1) View Accounts");
            System.out.println("2) Deposit to Savings");
            System.out.println("3) " + (FinanceApp.currentUser.hasJobs() ? "Quit Job" : "Select Job"));
            System.out.println("4) Get a HYSA");
            System.out.println("5) Get a Credit Card");
            System.out.println("6) Your Credit Card Info");
            System.out.println("7) Store");
            System.out.println("8) Do Task");
            System.out.println("9) Progress Day");
            System.out.println("10) Logout");
            System.out.println("11) Exit");
            // self explanatory, each case has its own actions not written in the case for obvious readability
            int choice = scanner.nextInt(); scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println(FinanceApp.currentUser);
                    break;
                case 2:
                    depositToSavings();
                    break;
                case 3:
                    handleJobMenu();
                    break;
                case 4:
                    handleHysaMenu();
                    break;
                case 5:
                    showCreditApplicationMenu();
                    break;
                case 6:
                    showCreditMenu();
                    break;
                case 7:
                    handleStoreMenu();
                    break;
                case 8:
                    handleTaskMenu();  // now matches our method name
                    break;
                case 9:
                    FinanceApp.currentUser.progressDay();
                    System.out.println("Day progressed.");
                    break;
                case 10:
                    session = false;
                    break;
                case 11:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void depositToSavings() {
        System.out.print("Amount to deposit: $");
        double amt = scanner.nextDouble(); scanner.nextLine();
        FinanceApp.currentUser.getSavingsAccount().deposit(amt, "Manual deposit");
    }

    private static void handleJobMenu() {
        if (!FinanceApp.currentUser.hasJobs()) {
            System.out.println("Available Jobs:");
            for (int i = 0; i < FinanceApp.jobOptions.length; i++) {
                System.out.printf("%d) %s%n", i+1, FinanceApp.jobOptions[i]);
            }
            System.out.print("Pick a job or 0 to cancel: ");
            int j = scanner.nextInt(); scanner.nextLine();
            if (j > 0 && j <= FinanceApp.jobOptions.length) {
                FinanceApp.currentUser.addJob(FinanceApp.jobOptions[j-1]);
                System.out.println("Job added.");
            }
        } else {
            System.out.println("Your Jobs:");
            List<Job> js = FinanceApp.currentUser.getJobs();
            for (int i = 0; i < js.size(); i++) {
                System.out.printf("%d) %s%n", i+1, js.get(i));
            }
            System.out.print("Quit a job or 0 to cancel: ");
            int q = scanner.nextInt(); scanner.nextLine();
            if (q > 0 && q <= js.size()) {
                FinanceApp.currentUser.removeJob(q-1);
                System.out.println("Job removed.");
            }
        }
    }

    private static void handleHysaMenu() {
        System.out.println("HYSA Options:");
        for (int i = 0; i < FinanceApp.hysaNames.length; i++) {
            System.out.printf("%d) %s%n", i+1, FinanceApp.hysaNames[i]);
        }
        System.out.print("Pick HYSA or 0 to cancel: ");
        int h = scanner.nextInt(); scanner.nextLine();
        if (h > 0 && h <= FinanceApp.hysaRates.length) {
            double bal = FinanceApp.currentUser.getSavingsAccount().balance;
            FinanceApp.currentUser.setSavingsAccount(
                    new SavingsAccount(bal, FinanceApp.hysaRates[h-1])
            );
            System.out.println(FinanceApp.hysaNames[h-1] + " selected.");
        }
    }

    private static void showCreditApplicationMenu() {
        while (true) {
            System.out.println("\nCredit Card Offers:");
            for (int i = 0; i < FinanceApp.creditOptions.length; i++) {
                CreditCard c = FinanceApp.creditOptions[i];
                System.out.printf("%d) %s%n", i+1, c.getCardName());
            }
            System.out.println("0) Back");
            System.out.print("Pick a card: ");
            int sel = scanner.nextInt(); scanner.nextLine();
            if (sel == 0) return;
            if (sel > 0 && sel <= FinanceApp.creditOptions.length) {
                CreditCard offer = FinanceApp.creditOptions[sel-1];
                System.out.println("\n" + offer.getCardName() + ": " + offer.getDescription());
                System.out.println("1) Apply  2) Back");
                int opt = scanner.nextInt(); scanner.nextLine();
                if (opt == 1) {
                    FinanceApp.currentUser.setCreditCard(offer);
                    System.out.println("You now have the " + offer.getCardName());
                    return;
                }
            }
        }
    }

    private static void showCreditMenu() {
        CreditCard cc = FinanceApp.currentUser.getCreditCard();
        if (cc == null) {
            System.out.println("No credit card selected.");
            return;
        }
        System.out.println("\n1) Status   2) About   3) Back");
        int opt = scanner.nextInt(); scanner.nextLine();
        switch (opt) {
            case 1:
                System.out.printf("Owe: $%.2f%n", cc.balance);
                System.out.printf("Available: $%.2f%n", cc.getCreditLimit() - cc.balance);
                System.out.println("Closing date: in 30 days");
                System.out.println("Due date: in 35 days");
                break;
            case 2:
                System.out.println("Minimum payment: 5% of balance or $25.");
                System.out.println("APR: " + (cc.interestRate * 100) + "%");
                System.out.println("Statement closes every 30 days; due date 5 days later.");
                break;
            case 3:
            default:
                break;
        }
    }

    private static void handleStoreMenu() {
        System.out.println("\nStore:");
        System.out.println("1) Burger - $10");
        System.out.println("2) Coffee - $5");
        System.out.println("3) Cancel");
        System.out.print("Pick an item: ");
        int s = scanner.nextInt(); scanner.nextLine();
        if (s == 1 || s == 2) {
            double cost = (s == 1 ? 10 : 5);
            System.out.print("Pay with: 1) Debit  2) Credit: ");
            int m = scanner.nextInt(); scanner.nextLine();
            if (m == 1) {
                FinanceApp.currentUser.getCheckingAccount().withdraw(cost);
            } else {
                CreditCard cc = FinanceApp.currentUser.getCreditCard();
                if (cc != null) cc.useCredit(cost);
                else System.out.println("No credit card selected.");
            }
        }
    }

    private static void handleTaskMenu() {
        System.out.println("\nTasks:");
        for (int i = 0; i < FinanceApp.tasks.length; i++) {
            System.out.printf("%d) %s%n", i+1, FinanceApp.tasks[i].getName());
        }
        System.out.print("Pick a task: ");
        int t = scanner.nextInt(); scanner.nextLine();
        if (t > 0 && t <= FinanceApp.tasks.length) {
            FinanceApp.tasks[t-1].perform(FinanceApp.currentUser, scanner);
        }
    }
}

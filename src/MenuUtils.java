import java.util.List;
import java.util.Scanner;
// contains a bunch of cases for the different menus
public class MenuUtils {
    public static Scanner scanner = FinanceApp.scanner;

    public static void showAuthMenu() {
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
                    FinanceApp.currentUser = new User(f, l, p);
                    System.out.println("Account created.");
                    loggedIn = true;
                    break;
                case 2:
                    if (FinanceApp.currentUser == null) {
                        System.out.println("No account yet."); break;
                    }
                    System.out.print("Password: ");
                    if (FinanceApp.currentUser.checkPassword(scanner.nextLine())) {
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

    public static void showMainMenu() {
        boolean session = true;
        while (session) {
            System.out.println("\nMain Menu:");
            System.out.println("1) View Accounts");
            System.out.println("2) Deposit to Savings");
            System.out.println("3) " + (FinanceApp.currentUser.hasJobs()? "Quit Job":"Select Job"));
            System.out.println("4) Get a HYSA");
            System.out.println("5) View Credit Cards");
            System.out.println("6) Pay Credit Card");
            System.out.println("7) Do Task");
            System.out.println("8) Progress Day");
            System.out.println("9) Logout");
            System.out.println("10) Exit");

            int choice = scanner.nextInt(); scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println(FinanceApp.currentUser);
                    break;
                case 2:
                    System.out.print("Amount to deposit: $");
                    double amt = scanner.nextDouble(); scanner.nextLine();
                    FinanceApp.currentUser.getSavingsAccount().deposit(amt, "Manual deposit");
                    break;
                case 3:
                    handleJobMenu();
                    break;
                case 4:
                    handleHysaMenu();
                    break;
                case 5:
                    for (CreditCard cc : FinanceApp.creditOptions)
                        System.out.println(cc);
                    break;
                case 6:
                    if (FinanceApp.currentUser.getCreditCard() == null)
                        System.out.println("No card.");
                    else {
                        System.out.print("Pay amount: $");
                        double pay = scanner.nextDouble(); scanner.nextLine();
                        FinanceApp.currentUser.getCreditCard().makePayment(pay);
                    }
                    break;
                case 7:
                    handleTaskMenu();
                    break;
                case 8:
                    FinanceApp.currentUser.progressDay();
                    System.out.println("Day progressed.");
                    break;
                case 9:
                    session = false;
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("Invalid.");
            }
        }
    }

    private static void handleJobMenu() {
        if (!FinanceApp.currentUser.hasJobs()) {
            Job[] jobs = FinanceApp.jobOptions;
            for (int i = 0; i < jobs.length; i++)
                System.out.printf("%d) %s%n", i+1, jobs[i]);
            System.out.print("Pick job or 0: ");
            int j = scanner.nextInt(); scanner.nextLine();
            if (j > 0 && j <= jobs.length) {
                FinanceApp.currentUser.addJob(jobs[j-1]);
                System.out.println("Job added.");
            }
        } else {
            List<Job> js = FinanceApp.currentUser.getJobs();
            for (int i = 0; i < js.size(); i++)
                System.out.printf("%d) %s%n", i+1, js.get(i));
            System.out.print("Quit job or 0: ");
            int q = scanner.nextInt(); scanner.nextLine();
            if (q > 0 && q <= js.size()) {
                FinanceApp.currentUser.removeJob(q-1);
                System.out.println("Job removed.");
            }
        }
    }

    private static void handleHysaMenu() {
        for (int i = 0; i < FinanceApp.hysaNames.length; i++)
            System.out.printf("%d) %s%n", i+1, FinanceApp.hysaNames[i]);
        System.out.print("Pick HYSA or 0: ");
        int h = scanner.nextInt(); scanner.nextLine();
        if (h > 0 && h <= FinanceApp.hysaRates.length) {
            double bal = FinanceApp.currentUser.getSavingsAccount().balance;
            FinanceApp.currentUser.setSavingsAccount(
                    new SavingsAccount(bal, FinanceApp.hysaRates[h-1])
            );
            System.out.println(FinanceApp.hysaNames[h-1] + " selected.");
        }
    }

    private static void handleTaskMenu() {
        DailyTask[] tasks = FinanceApp.tasks;
        for (int i = 0; i < tasks.length; i++)
            System.out.printf("%d) %s%n", i+1, tasks[i].getDescription());
        System.out.print("Pick task: ");
        int t = scanner.nextInt(); scanner.nextLine();
        if (t > 0 && t <= tasks.length)
            tasks[t-1].perform(FinanceApp.currentUser);
    }
}

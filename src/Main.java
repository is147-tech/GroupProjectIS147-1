//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random generator = new Random();

        /* the users names are initiated out of the loop
        given the null value so it can be updated as they give us an input
         */
        String fName = null, lName = null, password = null;
        boolean loggedIn = false;
        /*
        i created the loop so it doesn't just end
        this is our introduction, jus a simple layout of login create account while brainstorming
         */
        while (!loggedIn) {
            System.out.println("\nWelcome to Bit by Bits Finance System. Please Create an account or log in");
            System.out.println("1. Create an Account");
            System.out.println("2. Login to Existing Account");
            System.out.println("3. Exit APP");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    if (fName != null) {
                        System.out.println("An account is already created. Try logging in.");
                        break;
                    }
                    System.out.print("What is your first name? ");
                    fName = scanner.nextLine();
                    System.out.print("What is your last name? ");
                    lName = scanner.nextLine();
                    System.out.print("Create a password: ");
                    password = scanner.nextLine();
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    if (fName == null) {
                        System.out.println("No account exists. Please create an account first.");
                        break;
                    }
                    System.out.print("To log in, enter your first name: ");
                    String inputName = scanner.nextLine();
                    if (inputName.equals(fName)) {
                        System.out.print("Hello " + inputName + ", enter your password: ");
                        String inputPassword = scanner.nextLine();
                        if (inputPassword.equals(password)) {
                            System.out.println("Login successful! Accessing account...");
                            loggedIn = true;
                        } else {
                            System.out.println("Incorrect password. Try again.");
                        }
                    } else {
                        System.out.println("That name isn't associated with an account.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting application...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option, try again.");
            }
        }
        /*
        PART 2 OF PROGRAM
         */

        boolean running = true;
  while (running) {

      System.out.println("Hello, welcome to bit by bit Financing APP, we are here to help with your money management needs !");

  }
    }
}
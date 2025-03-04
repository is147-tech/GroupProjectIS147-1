//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random generator = new Random();

        String fName = "";
        String lName = "";
        String password = "";

        while(true) {
            System.out.println("\nWelcome to Bit by Bits Finance System. Please Create an account");
            System.out.println("1. Create an Account");
            System.out.println("2. Login to Existing Account");
            System.out.println("3. Exit APP");



            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("What is your first name?");
                    fName = scanner.nextLine();
                    System.out.print("What is your last name?");
                    lName = scanner.nextLine();
                    System.out.print("Create a password!");
                    password = scanner.nextLine();
                    break;

                case 2:
                    System.out.print("To login to your existing account, Please input your first name:");
                    String inputName = scanner.nextLine();
                    if (inputName.equals(fName)) {
                        System.out.print("Hello" + inputName + "what is your password?");
                    } else {
                        System.out.println("That name isn't associated with the account");
                    }

                    break;

                default:
                    System.out.println("Invalid option, try again. ");
            }
        }
    }
}
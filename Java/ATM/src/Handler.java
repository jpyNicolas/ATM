import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Handler {
    private static Scanner scanner = new Scanner(System.in);

    private static Account login() {
        String userName, pass;
        System.out.print("User Name : ");
        userName = scanner.next();
        System.out.print("Pass : ");
        pass = scanner.next();
        return Database.getAccountByUserPass(userName, pass);
    }

    public static void runATM() {
        Account account = login();
        byte input;
        do {
            Menu.mainMenu(account.getPerson().getName());
            input = scanner.nextByte();
            switch (input) {
                case 1:
                    System.out.println();
                    System.out.printf("Account balance : %s\n",account.getBalance());
                    System.out.println();
                    break;
                case 2:
                    withDraw(account);
                    break;
                case 3:
                    deposit(account);
                    break;
            }
        } while (input != 0);
    }

    private static void withDraw(Account account) {
        System.out.print("How much money do you want to withdraw? ");
        double amount = scanner.nextDouble();
        WithDraw wd = new WithDraw(account);
        wd.operate(amount);
    }

    private static void deposit(Account account) {
        System.out.print("Enter destination card number : ");
        String destinationCardNumber = scanner.next();
        System.out.print("How much money do you want to transfer? ");
        double amount = scanner.nextDouble();
        Deposit dp = new Deposit(account, destinationCardNumber);
        System.out.println();
        System.out.println("----Destination Account Info----");
        System.out.println(dp.getDAInfo());
        System.out.printf("The amount you want to transfer : %s\n", amount);
        System.out.println();
        System.out.print("Y or N ? ");
        String inpCh = scanner.next();
        if (inpCh.equalsIgnoreCase("y")) {
            dp.operate(amount);
            System.out.println("Transfer completed successfully");
        } else {
            System.out.println("The transfer was canceled");
        }
        System.out.println();
    }
}

import java.util.Scanner;

public class Handler {
    private static Scanner scanner = new Scanner(System.in);
    private static Account login(){
        String userName, pass;
        System.out.print("User Name : ");
        userName = scanner.next();
        System.out.print("Pass : ");
        pass = scanner.next();
        return Database.getAccountByUserPass(userName,pass);
    }
    public static void runATM(){
        Account account = login();
        byte input;
        do{
            Menu.mainMenu(account.getPerson().getName());
            input = scanner.nextByte();
            switch (input){
                case 1:
                    System.out.println(account.getBalance());
                    break;
                case 2:
                    withDrawMoney(account);
                    break;
                case 3:

                    break;
            }
        }while (input != 0);
    }
    private static void withDrawMoney(Account account){
        System.out.print("How much money do you want to withdraw? ");
        double amount = scanner.nextDouble();
        WithDraw withDraw = new WithDraw(account);
        withDraw.operate(amount);
    }
}

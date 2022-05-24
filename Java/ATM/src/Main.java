public class Main {
    public static void main(String[] args) {

            Database.creatDatabase();
            Person person = new Person("Amir", "Kazemi", "002");
            Account account = new Account("1", "123", "2055", 5000.0, person);
            Person person2 = new Person("Soheil", "Rezayi", "002");
            Account account2 = new Account("2", "456", "0733", 7000.0, person2);
            Database.addAccount(account);
            Database.addAccount(account2);
            while (true)
                Handler.runATM();

    }
}

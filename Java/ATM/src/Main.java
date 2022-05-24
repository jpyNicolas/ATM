public class Main {
    public static void main(String[] args) {

            Database.creatDatabase();
            Person person = new Person("Hooman", "Mirzaee", "002");
            Account account = new Account("1", "123", "2055", 5000.0, person);
            Database.addAccount(account);
            Handler.runATM();
            Handler.runATM();
    }
}

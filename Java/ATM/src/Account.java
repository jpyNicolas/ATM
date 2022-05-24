import java.util.List;

public class Account {
    private static long id = 0;
    private String userName;
    private String pass;
    private String accountNumber;
    private double balance;
    private Person person;
    private List<Transaction> transactions;

    public Account(String userName, String pass, String accountNumber, double balance, Person person) {
        this.userName = userName;
        this.pass = pass;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.person = person;
        id++;
    }

    public String getUserName() {
        return userName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Person getPerson() {
        return person;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean checkPass(String pass){
        return this.pass.equals(pass);
    }
    public void changeBalance(double amount){
        if (amount >= 0){
            this.balance = amount;
        } else
            throw new RuntimeException("Error in account balance amount");
    }
}
import java.util.Date;

public sealed abstract class Transaction permits Deposit, WithDraw {
    private Date date;
    private Account sourceAccount;
    public Transaction(Account account){
        this.sourceAccount = account;
    }
    public abstract void operate(double amount);

    public Account getSourceAccount() {
        return sourceAccount;
    }
}
import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Database database;
    private static List<Account> accountList;
    private Database(){
        accountList = new ArrayList<>();
    }

    public static Database creatDatabase(){
        if (database == null)
            database = new Database();
        return database;
    }
    public static void addAccount(Account account){
        accountList.add(account);
    }
    public static List<Account> getAccountList(){
        return accountList;
    }
    public static Account findByAccountNumber(String accountNumber){
        for (Account account :
                accountList) {
            if (account.getAccountNumber().equals(accountNumber))
                return account;
        }
        throw new DatabaseError();
    }
    public static Account getAccountByUserPass(String userName, String pass){
        for (Account account :
                accountList) {
            if (account.getUserName().equals(userName))
                if (account.checkPass(pass))
                    return account;
        }
        throw new DatabaseError();
    }
}

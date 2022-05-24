public non-sealed class Deposit extends Transaction{
    private Account destinationAccount;

    public Deposit(Account account, String destinationCardNumber) {
        super(account);
        this.destinationAccount = getDestinationAccount(destinationCardNumber);
    }

    @Override
    public void operate(double amount) {
        double sourceBalance = super.getSourceAccount().getBalance();
        double destinationBalance = destinationAccount.getBalance();
        if (amount <= sourceBalance){
            super.getSourceAccount().changeBalance(sourceBalance - amount);
            destinationAccount.changeBalance(amount + destinationBalance);
        }
    }
    public Account getDestinationAccount(String destinationCardNumber){
        return Database.findByAccountNumber(destinationCardNumber);
    }
}

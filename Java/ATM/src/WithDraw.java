public non-sealed class WithDraw extends Transaction{

    public WithDraw(Account account){
        super(account);
    }
    @Override
    public void operate(double amount) {
        double accountBalance = super.getSourceAccount().getBalance();
        super.getSourceAccount().changeBalance(accountBalance - amount);
    }
}

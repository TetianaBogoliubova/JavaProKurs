package addPracticeTasks.practice_04_09_BankAccount;

public class FixedBalanceAccount extends Account implements Transferable {
    public FixedBalanceAccount(String destination, double balance) {
        super(destination, balance);
    }

    @Override
    public void transfer(Account destination, double amount) {
        double x;
        x = getBalance() - amount;

        if (getBalance() > amount) {
            setBalance(x);
        } else {
            System.out.println("You cannot transfer this amount = " + amount + " from your account");
        }
    }
}

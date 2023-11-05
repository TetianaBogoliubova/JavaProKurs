package addPracticeTasks.practice_04_09_BankAccount;

public class CreditAccount extends Account implements Transferable {
    private double creditLimit;



    public CreditAccount(String destination, double balance, double creditLimit) {
        super(destination, balance);
        this.creditLimit = creditLimit;
    }

    @Override
    public void transfer(Account destination, double amount) {

        double x;
        double y;
        x = creditLimit + getBalance();
        y = x - amount;
        if (y < 0)  {
            System.out.println("You cannot transfer this amount " + amount + " from your account");
        }else setBalance(x - amount);
    }
}


package homework_Summ_23_11_24;

public class Deposit implements Runnable {

    private final BankAccount bankAccount;

    public Deposit(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 5; i++) {
            bankAccount.addDeposit(200);
        }
    }
}

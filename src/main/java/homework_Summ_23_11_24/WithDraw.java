package homework_Summ_23_11_24;

public class WithDraw implements Runnable {
    private final BankAccount bankAccount;

    public WithDraw(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 5; i++) {
            bankAccount.withDrawAmount(500);
        }
    }
}

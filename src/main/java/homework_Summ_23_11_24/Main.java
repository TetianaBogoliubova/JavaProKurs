package homework_Summ_23_11_24;

public class Main {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount(1000);

        Thread thread1 = new Thread(new Deposit(bankAccount));
        Thread thread2 = new Thread(new WithDraw(bankAccount));

        thread1.start();
        thread2.start();

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

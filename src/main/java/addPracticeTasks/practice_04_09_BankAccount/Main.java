package addPracticeTasks.practice_04_09_BankAccount;

public class Main {
    CreditAccount creditAccount = new CreditAccount("00", 0.0, 0.0);
    public static void main(String[] args) {

        FixedBalanceAccount fixedAccount = new FixedBalanceAccount("123456", 1000);
        CreditAccount creditAccount = new CreditAccount("789012", -500, 1000);

        fixedAccount.transfer(creditAccount, 400);
        creditAccount.transfer(fixedAccount, 600);

        System.out.println("Fixed account balance: " + fixedAccount.getBalance());
        System.out.println("Credit account balance: " + creditAccount.getBalance());
    }
}

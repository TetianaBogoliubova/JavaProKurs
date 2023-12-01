package homework_Summ_23_11_24;

//Имеется счет BankAccount, на котором хранится определенная сумма денег int sum.
// Реализовать потокобезопасный метод пополнения счета - deposit(int amount), снятия со счета -
// withdraw(int amount).

public class BankAccount {
    private int sum;

    public BankAccount(int sum) {
        this.sum = sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public synchronized void addDeposit(int amount) {
        int result;
        result = amount + sum;
        setSum(result);
        System.out.println("Счет пополнен на " + amount + ". Общая сумма на счету: " + sum);
    }

    public synchronized void withDrawAmount(int amount) {
        int result;
        if (sum < amount) {
            System.out.println("Недостаточно денег на счету.");
        } else {
            result = sum - amount;
            setSum(result);
            System.out.println("На счету осталось: " + result);
        }
    }
}

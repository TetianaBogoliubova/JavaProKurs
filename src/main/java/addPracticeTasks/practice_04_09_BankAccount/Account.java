package addPracticeTasks.practice_04_09_BankAccount;

import lombok.Getter;

//Задача:
// Создать банковскую систему, в которой можно создавать различные типы счетов
// (например, счета с фиксированным балансом и счета с кредитным лимитом).
// Реализовать абстрактный класс Account, содержащий базовую информацию о счете и методы для
// осуществления операций. Создать интерфейс Transferable, который имеет метод transfer
// (Account destination, double amount) для перевода средств между счетами.
// Реализовать два класса, FixedBalanceAccount и CreditAccount, наследующихся от абстрактного класса Account.
// Класс FixedBalanceAccount не имеет возможности использовать кредитный лимит,
// а класс CreditAccount может использовать кредитный лимит при отрицательном балансе.
public abstract class Account {

    private String destination;
    private double balance;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(String destination, double balance) {
        this.destination = destination;
        this.balance = balance;
    }
}

package homework_23_11_20.classes;

import com.github.javafaker.Faker;
import homework_23_11_20.Status;

import java.util.*;

public class Order {

    private int idOrder;
    private List<String> goods = new ArrayList<>();
    private Status status;

    public Order() {
    }

    public Order(int idOrder, List<String> goods, Status status) {
        this.idOrder = idOrder;
        this.goods = goods;
        this.status = status;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public List<String> getGoods() {
        return goods;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // 1. Добавление товара
    public List<String> setGoodInList(String good) {
        good = new Faker().commerce().material();
        goods.add(good);
        return goods;
    }

    // 2. Создание заказа
    public Order createOrder() {
        int newIdOrder = new Random().nextInt(1, 10);
        return new Order(newIdOrder, setGoodInList(new Faker().commerce().material()), Status.IN_PROCESSING);
    }

    // 3. Изменение статуса заказа
    public String changeStatus() {
        if (status == Status.IN_PROCESSING) {
            return "Заказ полностью не оформлен";
        }
        return "inProcess";
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", goods=" + goods +
                ", status=" + status +
                '}';
    }
}

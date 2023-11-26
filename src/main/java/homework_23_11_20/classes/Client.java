package homework_23_11_20.classes;

import homework_23_11_20.Status;

import java.util.*;

public class Client {

    Order order = new Order();
    OrderProcessor orderProcessor = new OrderProcessor();
    private int idClient;
    private final List<Order> orders = new ArrayList<>();

    // 1. Создание заказа
    public List<Order> createOrderByClient(String good) {
        idClient = new Random().nextInt(1, 10);
        order.setIdOrder(idClient);
        order.getGoods().add(good);
        Order newOrder = new Order(idClient, order.getGoods(), Status.IN_PROCESSING);
        orders.add(newOrder);
        return orders;
    }

    // 2.  Отслеживание статуса заказа
    public Status trackingOrder(int num) {
        orderProcessor.createQueue();
        for (Order i : orderProcessor.getQueueOfOrders()) {
            if (i.getIdOrder() == num) {
                return i.getStatus();
            }
        }
        return null;
    }
}




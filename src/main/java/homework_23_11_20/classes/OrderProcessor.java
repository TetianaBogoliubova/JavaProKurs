package homework_23_11_20.classes;

import com.github.javafaker.Faker;
import homework_23_11_20.Status;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class OrderProcessor {
    Order order = new Order();
    private final Queue<Order> queueOfOrders = new LinkedList<>();

    public Queue<Order> getQueueOfOrders() {
        return queueOfOrders;
    }

    // 1. добавление заказа в очередь
    public synchronized Order addOrderInQueue(Order order) {
        queueOfOrders.add(order);
        return order;
    }

    // 2. извлечение заказа из очереди
    public void pullOrderOufQueue(int num) {
        Iterator<Order> iterator = queueOfOrders.iterator();
        boolean orderFound = false;

        while (iterator.hasNext()) {
            Order i = iterator.next();
            if (i.getIdOrder() == num && (i.getStatus().equals(Status.EXECUTED) || i.getStatus().equals(Status.CANCELED))) {
                iterator.remove();
                System.out.println("Заказ: " + i.getIdOrder() + "удален из очереди");
                orderFound = true;
                break;
            }
        }
        if (!orderFound) {
            System.out.println("Заказ с таким номером не найден");
        }
    }

    public Queue<Order> createQueue() {
        queueOfOrders.add(new Order(1, order.setGoodInList(new Faker().commerce().material()), Status.IN_PROCESSING));
        queueOfOrders.add(new Order(2, order.setGoodInList(new Faker().commerce().material()), Status.CHECKED_OUT));
        queueOfOrders.add(new Order(3, order.setGoodInList(new Faker().commerce().material()), Status.CONFIRMED));
        queueOfOrders.add(new Order(4, order.setGoodInList(new Faker().commerce().material()), Status.PAID));
        queueOfOrders.add(new Order(5, order.setGoodInList(new Faker().commerce().material()), Status.EXECUTED));
        queueOfOrders.add(new Order(6, order.setGoodInList(new Faker().commerce().material()), Status.CANCELED));
        queueOfOrders.add(new Order(7, order.setGoodInList(new Faker().commerce().material()), Status.IN_PROCESSING));
        return getQueueOfOrders();
    }
}

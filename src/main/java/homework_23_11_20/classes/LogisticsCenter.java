package homework_23_11_20.classes;

import homework_23_11_20.Status;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LogisticsCenter {

    OrderManagementSystem oms = new OrderManagementSystem();
    private final Queue<List> readyOrdersFull = new LinkedList<>();
    private final Queue<List> readyOrdersNotFull = new LinkedList<>();

    // 1. Добавление готового заказа и отправка заказов
    public synchronized void addReadyOrderInQueue() {
        List<List<Order>> orderProcessorList = oms.distributeOrders();

        for (List<Order> i : orderProcessorList) {

            if (!i.isEmpty() && oms.getForDelivery().containsAll(i)) {
                readyOrdersFull.add(i);

            } else if (oms.getFinalizeList().containsAll(i) && oms.getFinalizeList().stream()
                    .anyMatch(o -> o.getStatus().equals(Status.CONFIRMED))) {
                readyOrdersNotFull.add(i);
            }
        }
        System.out.println("Товары оплачены и будут отправлены в ближайшее время: " + readyOrdersFull
                + "\nТовары еще не оплачены, ждут подтверждения к отправке: " + readyOrdersNotFull);
    }

}

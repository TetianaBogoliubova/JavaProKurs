package homework_23_11_20.classes;

import homework_23_11_20.Status;

import java.util.*;

public class OrderManagementSystem {
    OrderProcessor orderProcessor = new OrderProcessor();

    private volatile List<List<Order>> orderProcessorList = new ArrayList<>();//список обработчиков заказов
    private final List<Order> forDelivery = new ArrayList<>();
    private final List<Order> finalizeList = new ArrayList<>();
    private final List<Order> historyList = new ArrayList<>();

    public List<Order> getForDelivery() {
        return forDelivery;
    }

    public List<Order> getFinalizeList() {
        return finalizeList;
    }


    // 1. Запуск системы
    public boolean startManagementSystem() {
        orderProcessor.createQueue();
        if (!orderProcessor.getQueueOfOrders().isEmpty()) {
            for (Order i : orderProcessor.getQueueOfOrders()) {
                if (i.getStatus().equals(Status.IN_PROCESSING)) {
                    System.out.print("Есть новые заказы - система начала работать. ");
                    return true;
                }
            }
        }
        return false;
    }

    // 2. Остановка системы
    public boolean stopManagementSystem() {

        for (Order i : orderProcessor.getQueueOfOrders()) {
            if (!(i.getStatus().equals(Status.EXECUTED) || i.getStatus().equals(Status.CANCELED))) {
                System.out.print("Система продолжает работу над заказами. ");
                return false;
            }
        }
        return true;
    }

    // 3. Распределение заказов по обработчикам
    public List<List<Order>> distributeOrders() {
        orderProcessor.createQueue();

        for (Order i : orderProcessor.getQueueOfOrders()) {
            if (i.getStatus().equals(Status.IN_PROCESSING) || i.getStatus().equals(Status.CHECKED_OUT) || i.getStatus().equals(Status.CONFIRMED)) {
                finalizeList.add(i);
            } else if (i.getStatus().equals(Status.PAID)) {
                forDelivery.add(i);
            } else {
                historyList.add(i);
            }
        }
        orderProcessorList.add(finalizeList);
        orderProcessorList.add(forDelivery);
        orderProcessorList.add(historyList);

        System.out.println("Заказы готовые к завершению: " + finalizeList);
        System.out.println("Заказы готовые к отправке: " + forDelivery);
        System.out.println("Заказы для хранения в истории заказов: " + historyList);

        return orderProcessorList;
    }
}

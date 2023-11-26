package homework_23_11_20.threads;

import homework_23_11_20.Status;
import homework_23_11_20.classes.Order;
import homework_23_11_20.classes.OrderProcessor;

//Поток обработки заказов.
//Извлекает заказы из очереди обработчика заказов и обновляет их статус.
public class OrderProcessingThread implements Runnable {
    private final OrderProcessor orderProcessor;
    private volatile boolean stopThread;
    public OrderProcessingThread(OrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
    }

    public void stopThisThread() {
        stopThread = true;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            Order order = orderProcessor.getQueueOfOrders().poll();
            if (order != null) {
                if (order.getStatus().equals(Status.IN_PROCESSING)) {
                    order.setStatus(Status.CHECKED_OUT);
                    System.out.println("Заказ с обновленным статусом: " + order);
                } else if (order.getStatus().equals(Status.CHECKED_OUT)) {
                    order.setStatus(Status.CONFIRMED);
                    System.out.println("Заказ с обновленным статусом: " + order);
                } else if (order.getStatus().equals(Status.CONFIRMED)) {
                    order.setStatus(Status.PAID);
                    System.out.println("Заказ с обновленным статусом: " + order);
                } else if (order.getStatus().equals(Status.PAID)) {
                    order.setStatus(Status.EXECUTED);
                    System.out.println("Заказ с обновленным статусом: " + order);
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
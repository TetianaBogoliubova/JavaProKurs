package homework_23_11_20.threads;

import homework_23_11_20.classes.OrderManagementSystem;

//Переносит обработанные заказы в логистический центр для отправки.
public class LogisticsThread implements Runnable {
    private final OrderManagementSystem orderManagementSystem;
    private volatile boolean stopThread;

    public LogisticsThread(OrderManagementSystem orderManagementSystem) {
        this.orderManagementSystem = orderManagementSystem;
    }

    public void stopThisThread() {
        stopThread = true;
    }

    @Override
    public void run() {

            while (!Thread.interrupted()) {
                synchronized (orderManagementSystem) {

                    if (!orderManagementSystem.getForDelivery().isEmpty()) {
                        System.out.println("Заказы будут отправлены через логистический центр в ближайшее время");
                        orderManagementSystem.getForDelivery().clear();
                    }
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

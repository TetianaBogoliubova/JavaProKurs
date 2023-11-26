package homework_23_11_20.threads;

import homework_23_11_20.classes.Order;
import homework_23_11_20.classes.OrderProcessor;

//Отслеживает общее состояние системы и выводит информацию о статусах заказов.
public class MonitoringThread implements Runnable{
private final OrderProcessor orderProcessor;
    private volatile boolean stopThread;

    public MonitoringThread(OrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
    }

    public void stopThisThread() {
        stopThread = true;
    }

    @Override
    public void run() {
       while (!Thread.interrupted()) {
           synchronized (orderProcessor) {
               Order topOrder = orderProcessor.getQueueOfOrders().peek();
               if (topOrder != null) {
                   System.out.println("Информация о статусах заказов: " + topOrder.getStatus());
               } else {
                   System.out.println("Очередь заказов пуста");
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

package homework_23_11_20.threads;

import com.github.javafaker.Faker;
import homework_23_11_20.Status;
import homework_23_11_20.classes.Order;
import homework_23_11_20.classes.OrderProcessor;
import java.util.Random;

// Поток-генератор заказов.
// Создает новые заказы и добавляет их в систему управления заказами.
public class OrderGeneratorThread implements Runnable {
    private final OrderProcessor orderProcessor;
    private volatile boolean stopThread;
    public OrderGeneratorThread(OrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
    }

    public void stopThisThread() {
        stopThread = true;
    }

    @Override
    public void run() {

        while (!Thread.interrupted()) {
            try {
                int idOrder = new Random().nextInt(1, 100);
                String material = new Faker().commerce().material();
                Order newOrder = new Order();
                newOrder.setIdOrder(idOrder);
                newOrder.setGoodInList(material);
                newOrder.setStatus(Status.IN_PROCESSING);
                orderProcessor.addOrderInQueue(newOrder);
                System.out.println("Новый заказ: " + newOrder);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

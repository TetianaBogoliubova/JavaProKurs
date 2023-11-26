package homework_23_11_20;

import homework_23_11_20.classes.*;
import homework_23_11_20.threads.LogisticsThread;
import homework_23_11_20.threads.MonitoringThread;
import homework_23_11_20.threads.OrderGeneratorThread;
import homework_23_11_20.threads.OrderProcessingThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) {

        Order order = new Order();
        OrderProcessor orderProcessor = new OrderProcessor();
        OrderManagementSystem oms = new OrderManagementSystem();
        LogisticsCenter logisticsCenter = new LogisticsCenter();
        Client client = new Client();

        OrderGeneratorThread orderGeneratorThread = new OrderGeneratorThread(orderProcessor);
        OrderProcessingThread orderProcessingThread = new OrderProcessingThread(orderProcessor);
        LogisticsThread logisticsThread = new LogisticsThread(oms);
        MonitoringThread monitoringThread = new MonitoringThread(orderProcessor);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Order order1 = new Order(1, order.getGoods(), Status.IN_PROCESSING);
        Order order2 = new Order(5, order.getGoods(), Status.EXECUTED);

        System.out.println("Добавление товара: " + order.setGoodInList("good"));
        System.out.println("Создание заказа: " + order.createOrder());
        System.out.println("Изменение статуса: " + order.changeStatus());
        System.out.println("Добавление заказа в очередь: " + orderProcessor.addOrderInQueue(order1));
        orderProcessor.pullOrderOufQueue(2);
        System.out.println("Запуск системы: " + oms.startManagementSystem());
        System.out.println("Остановка системы: " + oms.stopManagementSystem());
        System.out.println("Распределение заказов по обработчикам: ");
        logisticsCenter.addReadyOrderInQueue();
        System.out.println("Создание заказа клиентом: " + client.createOrderByClient("good"));
        System.out.println("Отслеживание статуса заказа: " + client.trackingOrder(1));
        System.out.println("main is end");

        executorService.submit(new OrderGeneratorThread(orderProcessor));
        executorService.submit(new OrderProcessingThread(orderProcessor));
        executorService.submit(new LogisticsThread(oms));
        executorService.submit(new MonitoringThread(orderProcessor));


    // не могу остановить потоки и выйти из бесконечных циклов
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        orderGeneratorThread.stopThisThread();
        orderProcessingThread.stopThisThread();
        logisticsThread.stopThisThread();
        monitoringThread.stopThisThread();

        executorService.shutdown();

        System.out.println("main is end");
    }
}
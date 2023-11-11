package homework_23_11_06;

/**
 * Задание 1: Сервис заказов с внешним API для проверки статуса платежа
 * Бизнес логика:
 * <p>
 * Order - класс заказа, содержащий данные о заказе.
 * PaymentService - сервис для обработки платежей, который взаимодействует с внешним платежным API.
 * OrderService - сервис для управления заказами, который использует PaymentService.
 */
public class Order {
    private final String id;
    private final double amount;
    private boolean isPaid;

    public Order(String id, double amount, boolean isPaid) {
        this.id = id;
        this.amount = amount;
        this.isPaid = isPaid;
    }

    public String getId() {
        return id;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}

interface ExternalPaymentApi {
    boolean requestPayment(Order order);

    boolean verifyPayment(String orderId);
}

class PaymentService {
    private final ExternalPaymentApi paymentApi;

    public PaymentService(ExternalPaymentApi paymentApi) {//////////////\
        this.paymentApi = paymentApi;
    }

    public boolean processPayment(Order order) {
        return paymentApi.requestPayment(order) && paymentApi.verifyPayment(order.getId());
    }
}

class OrderService {
    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {////////////////////
        this.paymentService = paymentService;
    }

    public boolean placeOrder(Order order) {
        boolean paymentProcessed = paymentService.processPayment(order);
        if (paymentProcessed) {
            order.setPaid(true);
        }
        return paymentProcessed;
    }
}


package homework_23_11_06;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private PaymentService paymentService;

    @Test
    void placeOrderPositiveTest() {

        Order order = new Order("abc123", 100, false);
        OrderService orderService1 = new OrderService(paymentService);

        Mockito.when(paymentService.processPayment(order)).thenReturn(true);
        orderService1.placeOrder(order);
        assertTrue(order.isPaid());

        Mockito.verify(paymentService).processPayment(order);
    }

    @Test
    void placeOrderNegativeTest() {

        Order order = new Order("abc123", 100, false);
        OrderService orderService1 = new OrderService(paymentService);

        Mockito.when(paymentService.processPayment(order)).thenReturn(false);
        orderService1.placeOrder(order);
        assertFalse(order.isPaid());

        Mockito.verify(paymentService).processPayment(order);
    }
}
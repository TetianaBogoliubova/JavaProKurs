package homework_23_11_06;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    ExternalPaymentApi externalPaymentApi = Mockito.mock(ExternalPaymentApi.class);
    PaymentService paymentService = new PaymentService(externalPaymentApi);
    Order order = new Order("abc123", 100, false);

    @Test
    void processPaymentPositiveTest() {
        Mockito.when(externalPaymentApi.requestPayment(order)).thenReturn(true);
        Mockito.when(externalPaymentApi.verifyPayment(order.getId())).thenReturn(true);
        boolean result = paymentService.processPayment(order);
        assertTrue(result);

        Mockito.verify(externalPaymentApi).requestPayment(order);
        Mockito.verify(externalPaymentApi).verifyPayment(order.getId());
    }
}
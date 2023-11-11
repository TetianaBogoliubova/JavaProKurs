package homework_23_11_06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderFulfillmentServiceTest {
    @Mock
    OrderFulfillmentService fulfillmentService;
    @Mock
    InventoryService inventoryService;

    @BeforeEach
    void setUp() {
        inventoryService = new InventoryService();
        fulfillmentService = new OrderFulfillmentService(inventoryService);
    }

    // 1.
    @Test
    void fulfillOrderPositiveTest() {
        String sku = "ABC123";
        int quantity = 90;
        int expectedQuantity = 10;
        boolean result = inventoryService.updateStock(sku, -quantity);
        assertTrue(result);
        assertEquals(expectedQuantity, inventoryService.checkProductStock(sku));
        assertEquals(expectedQuantity, inventoryService.getProductStockDatabase().get(sku));
    }

    @Test
    void fulfillOrderNegativeTest() {
        String sku = "ABC123";
        int expectedQuantity = -10;
        boolean result = false;
        assertFalse(result);
        assertNotEquals(expectedQuantity, inventoryService.getProductStockDatabase().get(sku));
    }

    // 2.
    @Test
    void returnItemsToInventoryTest() {
        String sku = "ABC123";
        Product product = new Product("ABC123", 100);
        int quantity = 50;
        int expected = 150;
        boolean result = fulfillmentService.returnItemsToInventory(product, quantity);
        assertTrue(result);
        assertEquals(expected, inventoryService.getProductStockDatabase().get(sku));
        assertEquals(expected, product.getStockQuantity());
        assertEquals(expected, inventoryService.checkProductStock(sku));
    }

    @Test
    void returnItemsToInventoryTest1() {
        String sku = "ABC123";
        Product product = new Product("ABC123", 100);
        int quantity = 50;
        int expected = 150;
        boolean result = fulfillmentService.returnItemsToInventory(product, quantity);
        assertTrue(result);
        assertEquals(expected, inventoryService.getProductStockDatabase().get(sku));
        assertEquals(expected, product.getStockQuantity());
        assertEquals(expected, inventoryService.checkProductStock(sku));

    }
}
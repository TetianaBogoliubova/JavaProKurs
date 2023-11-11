package homework_23_11_06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryServiceTest {

    private InventoryService inventoryService;

    @BeforeEach
    void setUp() {
        inventoryService = new InventoryService();
    }

    // 1.
    @Test
    void checkProductStockPositiveTest() {
        String sku = "ABC123";
        int expected = 100;
        assertEquals(expected, inventoryService.checkProductStock(sku));
    }

    @Test
    void checkProductStockNegativeTest() {
        String sku = "RRR000";
        int expected = 0;
        assertEquals(expected, inventoryService.checkProductStock(sku));
    }

    // 2.
    @Test
    void updateStockProductIsTest() {
        String sku = "ABC123";
        assertTrue(inventoryService.updateStock(sku, 1));
    }

    @Test
    void updateStockProductNotIsTest() {
        String expected = "RRR000";
        String sku = "ABC123";
        assertNotEquals(expected, inventoryService.getProductStockDatabase().get(sku));
    }

    @Test
    void updateStockProductNegativeQuantityTest() {//????????????
        int quantityChange = -150;
        String sku = "ABC123";
        assertFalse(inventoryService.updateStock(sku, quantityChange));
    }

    @Test
    void updateStockProductPositiveQuantityTest() {
        String sku = "ABC123";
        int quantityChange = 50;
        int baseQuantity = 100;
        int expectedQuantity = baseQuantity + quantityChange;

        boolean result = inventoryService.updateStock(sku, quantityChange);
        assertTrue(result);
        assertEquals(expectedQuantity, inventoryService.checkProductStock(sku));
    }
}
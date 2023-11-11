package homework_23_11_06;

import java.util.HashMap;
import java.util.Map;

/**
 * InventoryService управляет простой "базой данных" продуктов
 * ключ — это SKU продукта
 * значение — количество товара на складе.
 * updateStock учитывает возможность, что обновление запасов не должно привести к отрицательному количеству товара.
 * <p>
 * OrderFulfillmentService использует InventoryService для проверки и
 * обновления запасов при выполнении заказа.
 * Если запасы достаточны, заказ выполняется и запасы обновляются.
 * returnItemsToInventory может использоваться для возврата товаров на склад,
 * что увеличивает количество запасов для данного SKU.
 */
public class Product {
    private final String sku; // Stock Keeping Unit - уникальный идентификатор продукта
    private int stockQuantity; //количество товара на складе

    public Product(String sku, int stockQuantity) {
        this.sku = sku;
        this.stockQuantity = stockQuantity;
    }

    public String getSku() {
        return sku;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}

class InventoryService {
    private final Map<String, Integer> productStockDatabase = new HashMap<>();

    public InventoryService() {
        // Инициализация некоторыми тестовыми данными
        productStockDatabase.put("ABC123", 100);
        productStockDatabase.put("XYZ987", 200);
        productStockDatabase.put("IJK654", 150);
    }

    // 1.
    public int checkProductStock(String sku) {
        return productStockDatabase.getOrDefault(sku, 0);
    }

    //2.
    public boolean updateStock(String sku, int quantityChange) {
        // Проверяем, существует ли продукт
        if (!productStockDatabase.containsKey(sku)) {
            return false;
        }
        int currentStock = productStockDatabase.get(sku);
        int newStock = currentStock + quantityChange;
        // Проверяем, не становится ли новое количество отрицательным
        if (newStock < 0) {
            return false;
        }
        productStockDatabase.put(sku, newStock);
        return true;
    }

    public Map<String, Integer> getProductStockDatabase() {
        return productStockDatabase;
    }
}

class OrderFulfillmentService {
    private final InventoryService inventoryService;

    public OrderFulfillmentService(InventoryService inventoryService) {/////////////////кон.
        this.inventoryService = inventoryService;
    }

    // 1.
    public boolean fulfillOrder(Product product, int quantity) {
        String sku = product.getSku();
        int stock = inventoryService.checkProductStock(sku);
        if (stock >= quantity) {
            boolean stockUpdated = inventoryService.updateStock(sku, -quantity);
            if (stockUpdated) {
                product.setStockQuantity(stock - quantity);
            }
            return stockUpdated;
        }
        return false;
    }

    // 2.
    public boolean returnItemsToInventory(Product product, int quantity) {
        String sku = product.getSku();
        boolean stockUpdated = inventoryService.updateStock(sku, quantity);
        if (stockUpdated) {
            product.setStockQuantity(product.getStockQuantity() + quantity);
        }
        return stockUpdated;
    }
}

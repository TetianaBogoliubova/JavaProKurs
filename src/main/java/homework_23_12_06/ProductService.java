package homework_23_12_06;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public void addProduct(Product product) {
        // Добавление товара
    }

    public void updateProduct(Product product) {
        // Обновление товара
    }

    public void deleteProduct(Product product) {
        // Удаление товара
    }

    public double calculatePrice(Product product) {
        // Вычисление цены товара
        return 0;
    }
}
//          *** исправленный ***

class Product {
    private int id;
    private String name;
    private double prise;

}

class ProductServiceCorrect {
    Product product = new Product();
    private List<Product> dataBase = new ArrayList<>();

    public void addProduct(Product product) {
        // Добавление товара
    }

    public void updateProduct(Product product) {
        // Обновление товара
    }

    public void deleteProduct(Product product) {
        // Удаление товара
    }

    public double calculatePrice(Product product) {
        // Вычисление цены товара
        return 0;
    }
}
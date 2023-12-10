package homework_23_12_06;

import java.util.List;

//public class Product {
//
//    private String name;
//    private double price;
//
//    public void saveToDatabase() {
//        // Сохранение товара в базу данных
//    }
//
//    public void generateInvoice() {
//        // Генерация счета для товара
//    }
//
//    // Избыточный метод, который не связан с товаром
//    public void sendEmailConfirmation() {
//        // Отправка электронного письма с подтверждением
//    }
//}

//          *** исправленный ***

class ProductCorrect {

    private String name;
    private double price;
    private List<Product> dataBase;

    public void saveToDatabase() {
        // Сохранение товара в базу данных
    }

    public void generateInvoice() {
        // Генерация счета для товара
    }
}

class OrderProcessing {

    public void sendEmailConfirmation() {
        // Отправка электронного письма с подтверждением
    }
}
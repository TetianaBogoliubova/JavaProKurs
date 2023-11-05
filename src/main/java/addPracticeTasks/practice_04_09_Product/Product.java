package addPracticeTasks.practice_04_09_Product;

import lombok.Getter;
import lombok.Setter;

//Разработать интернет-магазин, в котором можно продавать различные продукты с
//возможностью применения скидок. Создать абстрактный класс Product,
//содержащий информацию о продукте (название, цена) и методы для получения информации.
//Создать интерфейс Discountable, который имеет метод applyDiscount(double percentage)
//для применения скидки к продукту. Реализовать два класса, PhysicalProduct и DigitalProduct,
//наследующихся от абстрактного класса Product. Класс PhysicalProduct может иметь наценку за доставку,
//а класс DigitalProduct не имеет такой наценки.
public class Product {
   // Getter
    //Setter;
    private final String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

}

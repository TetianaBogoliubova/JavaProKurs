package homework_23_08_30.allClasses;


import homework_23_08_30.allEnums.Currency;
import homework_23_08_30.allEnums.ProductCategory;

public class Product {
    private int id;
    private String name;
    private ProductCategory category;
    private double price;
    private Currency currency;

    public Currency getCurrency() {
        return currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Product(int id, String name, ProductCategory category, double price, Currency currency) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.currency = currency;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", currency=" + currency +
                '}';
    }
}

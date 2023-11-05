package addPracticeTasks.practice_04_09_Product;

public class DigitalProduct extends Product implements Discountable {
    public DigitalProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public void applyDiscount(double percentage) {
        double discount;
        double totalCount;
        discount = (getPrice() * percentage) / 100;
        totalCount = getPrice() - discount;
        setPrice(totalCount);
    }

}


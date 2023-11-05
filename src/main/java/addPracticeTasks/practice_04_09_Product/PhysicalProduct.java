package addPracticeTasks.practice_04_09_Product;

public class PhysicalProduct extends Product implements Discountable {
    private double deliveryCount;

    public PhysicalProduct(String name, double price, double deliveryCount) {
        super(name, price);
        this.deliveryCount = deliveryCount;
    }

    @Override
    public void applyDiscount(double percentage) {
        double discount;
        double totalCount;
        discount = (getPrice() * percentage) / 100;
        totalCount = (getPrice() - discount) + deliveryCount;
        setPrice(totalCount);
    }
}

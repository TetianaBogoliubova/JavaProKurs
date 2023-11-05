package addPracticeTasks.practice_04_09_Product;

public class Main {
    public static void main(String[] args) {

        PhysicalProduct physicalProduct = new PhysicalProduct("Phone", 800, 20);
        DigitalProduct digitalProduct = new DigitalProduct("Ebook", 90);

        physicalProduct.applyDiscount(15);
        digitalProduct.applyDiscount(25);

        System.out.println("Physical product price after discount: " + physicalProduct.getPrice());
        System.out.println("Digital product price after discount: " + digitalProduct.getPrice());
    }
}



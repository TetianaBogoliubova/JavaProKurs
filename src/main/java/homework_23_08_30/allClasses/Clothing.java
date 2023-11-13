package homework_23_08_30.allClasses;
//2.2. Clothing - Подкласс класса Product для представления одежды:
//  Дополнительное поле size (размер одежды из Size).
//  Конструктор для инициализации полей.

import homework_23_08_30.allEnums.Currency;
import homework_23_08_30.allEnums.ProductCategory;
import homework_23_08_30.allEnums.Size;

public class Clothing extends Product {

    private Size size;

    public Clothing(int id, String name, ProductCategory category, double price, Currency currency, Size size) {
        super(id, name, category, price, currency);
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "size=" + size +
                '}';
    }

    public void setSize(Size size) {
        this.size = size;

    }
}

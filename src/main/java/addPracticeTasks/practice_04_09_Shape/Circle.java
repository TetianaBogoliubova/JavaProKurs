package addPracticeTasks.practice_04_09_Shape;

public class Circle extends Shape implements Resizable {
    private final int radius;
    private final double PI = Math.PI;

    public Circle(int radius) { // конструктор данного класса с параметром - П.radius
        this.radius = radius;
    }

    @Override
    double area() {
        return PI * (radius * radius);
    }
    @Override
    public double resize(double factor) {
        return area() * factor;
    }
}

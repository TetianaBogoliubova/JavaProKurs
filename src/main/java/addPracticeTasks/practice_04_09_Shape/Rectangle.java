package addPracticeTasks.practice_04_09_Shape;

public class Rectangle extends Shape implements Resizable {
    private final int sizeA;
    private final int sizeB;

    public Rectangle(int sizeA, int sizeB) {
        this.sizeA = sizeA;
        this.sizeB = sizeB;
    }

    @Override
    public double resize(double factor) {
        return area() * factor;
    }

    @Override
    double area() {
        return sizeA * sizeB;
    }
}

package addPracticeTasks.practice_04_09_Shape;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(5);
        circle.area();
        System.out.println("Circle area after resizing: " + circle.resize(1.5));


        Rectangle rectangle = new Rectangle(4, 6);
        rectangle.area();
        System.out.println("Rectangle area after resizing: " + rectangle.resize(2));
    }
}

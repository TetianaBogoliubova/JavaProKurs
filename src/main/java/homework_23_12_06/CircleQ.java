package homework_23_12_06;

public class CircleQ {
    private double radius;

    public double calculateArea() {

        return Math.PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
}

//          *** исправленный ***

class CircleCorrect {
    private double radius; //радиус не инициализирован

    public double calculateArea() {

        return Math.PI * Math.pow(radius, 2);
    }

    public double calculateLength() {

        return 2 * Math.PI * radius;
    }
}

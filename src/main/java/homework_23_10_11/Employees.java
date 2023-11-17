package homework_23_10_11;

public class Employees {
    private String name;
    private double salary;
    private String city;
    private String position;

    public Employees(String name, double salary, String city, String position) {
        this.name = name;
        this.salary = salary;
        this.city = city;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", city='" + city + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

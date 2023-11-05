package addPracticeTasks.practice_27_09_23_students;

import java.util.List;

public class Student {

    private int id; // Уникальный идентификатор студента.
    private String firstName;// мя студента.
    private String lastName;// Фамилия студента.
    private int age; //Возраст студента.
    private List<Double> grades; //Список оценок студента.
    private List<Course> courses1;// Множество учебных предметов, которые посещает студент.


    public Student(int id, String firstName, String lastName, int age, List<Double> grades, List<Course> courses1) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.grades = grades;
        this.courses1 = courses1;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    public List<Course> getCourses() {
        return courses1;
    }

    public void setCourses(List<Course> courses1) {
        this.courses1 = courses1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", grades=" + grades +
                ", courses1=" + courses1 +
                '}';
    }
}

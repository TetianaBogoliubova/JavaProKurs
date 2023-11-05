package homework_23_09_06;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static char c1;
    static char c2;
    static char c3;
    static char c4;
    static int inputName;

    public static void main(String[] args) {

        Student student = new Student("name", 0, Grade.A);

        GradeManagementSystem gms = new GradeManagementSystem();
        GradeComparator gradeComparator = new GradeComparator();

        Teacher teacher = new Teacher("name", 0, Category.I);

        System.out.println("Отображение среднего балла студента по его фамилии: ");
        student.getGradeName("Петров");// <--- введите необходимую фамилию

        c1 = Teacher.gradeStudent();
        c2 = Teacher.gradeStudent();
        c3 = Teacher.gradeStudent();
        c4 = Teacher.gradeStudent();

        System.out.println("Баллы, которые студент получал за последние 2 недели - " + c1 + ", " + c2 + ", " + c3 + ", " + c4);
        student.getDescription();

        System.out.println();

        System.out.println("Отбор студентов по определенному среднему баллу: ");
        gms.processStudents(Grade.A);// <--- ввести нужный балл

        System.out.println("Сравнительная характеристика среднего балла успеваимости студентов");
        Arrays.sort(gms.students, gradeComparator);
        for (Student stud : gms.students) {
            System.out.println(stud.getGrade() + ", " + stud.getName());
        }
        System.out.println();

        System.out.println("Отбор преподавателя по категории: ");
        gms.processTeachers(Category.III);// <--- ввести нужную категорию

        System.out.println();

        System.out.println("Введите возраст преподавателя: "); // \n" + Arrays.toString(gms.teachers));
        Scanner scanner = new Scanner(System.in);
        inputName = scanner.nextInt();
        teacher.getDescription();
    }
}

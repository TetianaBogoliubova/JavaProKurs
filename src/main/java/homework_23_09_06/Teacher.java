package homework_23_09_06;

import java.util.Random;

public class Teacher extends Person implements Categoried {

    Category category;
    GradeManagementSystem gms2 = new GradeManagementSystem();
    //Main main2 = new Main();

    public Teacher(String name, int age, Category category) {
        super(name, age);
        this.category = category;

    }

    @Override // метод выдает информацию о преподавателе
    void getDescription() {
            if (Main.inputName >= 35) {
                System.out.println("Преподаватель может пройти курс по повышению категории квалификации");
            } else System.out.println("Преподаватель не может еще пройти курс по повышению категории квалификации");
        }

    public static char gradeStudent() {//метод будет выставлять случайную оценку студенту.
        Random random = new Random();
        return (char) (random.nextInt(4) + 'A');

    }

    @Override
    public Category getCategory() {
        return category;
    }
}

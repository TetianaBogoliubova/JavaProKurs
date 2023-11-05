package homework_23_09_06;

public class Student extends Person implements Graded {
    public Grade grade;

    public Student(String name, int age, Grade grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override //метод выдает информацию о студенте
    void getDescription() {
        if (Main.c1 == 'D' || Main.c2 == 'D' || Main.c3 == 'D' || Main.c4 == 'D') {
            System.out.println("Студенту следует повторно прослушать курс");
        } else System.out.println("Студент рекомендован к прохождению стажировки");


    }

    @Override
    public void getGradeName(String arg) {// метод возвращает имя студенка по его оценке
        for (Student stud : GradeManagementSystem.students) {
            if (stud.getName().equals(arg))
                System.out.println("Средний балл студента " + stud.getName() + " : " + stud.grade);
            } return;
            }

    @Override // метод возвращает оценку студента
    public Grade getGrade() {
return grade;
    }
}



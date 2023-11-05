package homework_23_09_06;

public class GradeManagementSystem {

    static Student[] students = {
            new Student("Ливанов", 20, Grade.A),
            new Student("Петров", 23, Grade.B),
            new Student("Сидоров", 24, Grade.C),
            new Student("Пяточкин", 19, Grade.D),
            new Student("Пупкин", 22, Grade.B),
            new Student("Васячкин", 24, Grade.C),
            new Student("Клименко", 19, Grade.A),
            new Student("Бойко", 21, Grade.B)
    };

    //- метод для вывода информации о студентах (перебор массива студентов) - выборка по оценке.
    public void processStudents(Grade grade) {
        for (Student gr : students) {
            if (gr.grade.equals(grade))
                System.out.println(gr.getName() + ": " + gr.grade);
        }
        return;
    }

    static Teacher[] teachers = {
            new Teacher("Максим Маскимович", 30, Category.I),
            new Teacher("Петр Петрович", 45, Category.II),
            new Teacher("Сергей Сергеевич", 50, Category.III),
            new Teacher("Роман Романович ", 38, Category.II),
            new Teacher("Кирилл Кириллович", 52, Category.III)
    };

    //- метод для вывода информации о преподавателях (перебор массива преподавателей).
    public void processTeachers(Category category) {
        for (Teacher cat : teachers) {
            if (cat.category.equals(category)) {
                System.out.println("Указанную категорию " + cat.category + " имеет " + cat.getName());
                if (cat.category == Category.II) {
                    System.out.println("Данный учитель ведет занятия у студентов со средним баллом: " + Grade.A + " и " + Grade.B);
                } else if (cat.category == Category.I) {
                    System.out.println("Данный учитель ведет занятия у студентов со средним баллом: " + Grade.C + " и " + Grade.D);
                } else System.out.println("Учитель с данной категорией проводит стажировку у студентов");

            }
        }
    }
}

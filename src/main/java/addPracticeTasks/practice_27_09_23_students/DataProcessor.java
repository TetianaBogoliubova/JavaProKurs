package addPracticeTasks.practice_27_09_23_students;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataProcessor {
    MethodsForStudents ms = new MethodsForStudents();
    Course course;
    Student student;

    List<Student> students = new ArrayList<>();// Список всех зарегистрированных студентов.
    Set<Course> courses = new HashSet<>();// (): Множество всех доступных учебных предметов.
    List<Double> grades = new ArrayList<>();//Список оценок студента.
    List<Student> studentsEnrolled = new ArrayList<>();//Список студентов, зарегистрированных на данный предмет.
    List<Student> gradeBook = new ArrayList<>();

    public DataProcessor() {
    }

//    public DataProcessor() {
//        course = new Course(ms.getCourseId(), ms.getCourseName(), ms.getCourseDescription(), ms.getCourseCredits(), ms.getStudentsEnrolled(""), ms.getGradeBook(""));
//        student = new Student(ms.getIdStudent(), ms.getFirstName(), ms.getLastName(), ms.getAgeStudent(), ms.setUpGradesStudentList(), (List<String>) ms.getCoursesByStudent());
//    }


    public DataProcessor(MethodsForStudents ms, Course course, Student student, List<Student> students, Set<Course> courses, List<Double> grades, List<Student> studentsEnrolled, List<Student> gradeBook) {
        this.ms = ms;
        this.course = course;
        this.student = student;
        this.students = students;
        this.courses = courses;
        this.grades = grades;
        this.studentsEnrolled = studentsEnrolled;
        this.gradeBook = gradeBook;
    }

    //Множество всех доступных учебных предметов.
    public Set<Course> setUpCourses() {
        while (courses.size() < 15) {
            Course course = new Course(
                    ms.getCourseId(),
                    ms.getCourseName(),
                    ms.getCourseDescription(),
                    ms.getCourseCredits(),
                    (List<Student>) ms.getStudentsEnrolled(),
                    ms.getGradeBook()
            );
            courses.add(course);
        }
        return courses;
    }

    //Список всех зарегистрированных студентов.
    public List<Student> setUpStudents() {
        while (students.size() < 40) {
            Student student = new Student(
                    ms.getIdStudent(),
                    ms.getFirstName(),
                    ms.getLastName(),
                    ms.getAgeStudent(),
                    ms.setUpGradesStudentList(),
                    ms.setCoursesForStudent()
            );
            students.add(student);
        }
        return students;
    }



    //Методы:
//        1. `public double calculateAverageGrade(Student student)`: Метод, который
//        вычисляет средний балл для конкретного студента.
//        2. `public Map<Student, Double> calculateClassAverage()`: Метод, который вычисляет
//        средний балл для каждого студента и возвращает результат в виде отображения (Map).
//        3. `public List<String> listCourseNamesWithLowestAverage()`: Метод, который
//        возвращает список названий предметов с наименьшим средним баллом среди студентов.
//        4. `public void addStudentToCourse(Student student, Course course)`: Метод,
//        который добавляет студента на учебный предмет.
//        5. `public void recordGrade(Student student, Course course, double grade)`: Метод,
//        который записывает оценку студенту по учебному предмету.
//        6. `public void removeStudentFromCourse(Student student, Course course)`: Метод,
//        который удаляет студента с учебного предмета.
}

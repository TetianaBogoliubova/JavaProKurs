package addPracticeTasks.practice_27_09_23_students;

import com.github.javafaker.Faker;

import java.util.*;

public class MethodsForStudents {
Course course = new Course();
    private final Random random = new Random();
    private final Faker faker = new Faker();
    private DataProcessor dataProcessor;
    private double grade;
    List<Double> grades = new ArrayList<>();
    Map<String, List<Double>> gradeBook = new HashMap<>();
    List<Course> courses1 = new ArrayList<>();
    List<Student> studentsEnrolled = new ArrayList<>();

    public DataProcessor getDataProcessor() {
        return dataProcessor;
    }

    public void setDataProcessor(DataProcessor dataProcessor) {
        this.dataProcessor = dataProcessor;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getIdStudent() {
        int id = random.nextInt(10, 100);
        return id;
    }

    public String getFirstName() {
        String firstName = faker.name().firstName();
        return firstName;
    }

    public String getLastName() {
        String lastName = faker.name().lastName();
        return lastName;
    }

    public int getAgeStudent() {
        int age = random.nextInt(18, 24);
        return age;
    }


    public List<Double> setUpGradesStudentList() {
        List<Double> grades = new ArrayList<>();
//        grade = random.nextInt(1, 10);
//        grade = Math.round(grade * 100.0) / 100.0;
        for (int i = 0; i < 10; i++) {
            double grade = Math.round(random.nextDouble(1, 10) * 100.0) / 100.0;
            grades.add(grade);
        }
        return grades;

//        while (grades.size() < 10) {
//            grades.add(grade);
//        }
//        return grades;
    }

    public int getCourseId() {
        int courseId = random.nextInt(10, 50);
        return courseId;
    }

    public String getCourseName() {
        String courseName = faker.educator().course();
        return courseName;
    }

    public String getCourseDescription() {
        String courseDescription = faker.job().title();
        return courseDescription;
    }

    public int getCourseCredits() {
        int courseCredits = random.nextInt(1, 6);
        return courseCredits;
    }

    //Список студентов, зарегистрированных на данный предмет.
    public Student getStudentsEnrolled() {
        if (dataProcessor != null) {
            return dataProcessor.students.get(Integer.parseInt(faker.name().lastName()));
        }
        return null;
    }


    //Связь студентов и их оценок по данному предмету.
    public Map<String, List<Double>> getGradeBook() {
       // for (Student i : dataProcessor.students) {
           // //if (i.getCourses().equals(course)) {
            //gradeBook.put(i.getLastName(),i.getGrades());
       // }
        return gradeBook;
    }

    public List<Course> setCoursesForStudent() {
        if (dataProcessor != null) {

            while (courses1.size() < 9) {
             course = courses1.get(random.nextInt(courses1.size()));
                courses1.add(course);
            }
        }
        return courses1;
    }
}
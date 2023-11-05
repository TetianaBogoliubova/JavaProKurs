package addPracticeTasks.practice_27_09_23_students;

import java.util.List;
import java.util.Map;

public class Course {
    private int courseId; //  Уникальный идентификатор предмета.
    private String courseName;// Название учебного предмета.
    private String courseDescription;// Описание учебного предмета.
    private int courseCredits;//Количество кредитов, присваиваемых за успешное прохождение предмета.
    private List<Student> studentsEnrolled;// Список студентов, зарегистрированных на данный предмет.
    private Map<String, List<Double>> gradeBook;// Связь студентов и их оценок по данному предмету.


    public Course(int courseId, String courseName, String courseDescription, int courseCredits, List<Student> studentsEnrolled,  Map<String, List<Double>> gradeBook) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseCredits = courseCredits;
        this.studentsEnrolled = studentsEnrolled;
        this.gradeBook = gradeBook;
    }

//    public Course(int courseId, String courseName, String courseDescription, int courseCredits, Student ob, String gradeBook) {
//    }

    public Course() {
    }

    public int getCourseId() {
        return courseId;
    }


    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(int courseCredits) {
        this.courseCredits = courseCredits;
    }

    public List<Student> getStudentsEnrolled(String str) {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public Map<String, List<Double>> getGradeBook(String str) {
        return gradeBook;
    }

    public void setGradeBook( Map<String, List<Double>> gradeBook) {
        this.gradeBook = gradeBook;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", courseCredits=" + courseCredits +
                ", studentsEnrolled=" + studentsEnrolled +
                ", gradeBook=" + gradeBook +
                '}';
    }
}

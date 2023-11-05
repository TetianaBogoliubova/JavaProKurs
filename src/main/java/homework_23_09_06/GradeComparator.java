package homework_23_09_06;

import java.util.Comparator;

public class GradeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
return o1.getGrade().compareTo(o2.getGrade());
    }
}

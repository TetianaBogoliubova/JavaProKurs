package homework_Summ_23_11_17;

import java.lang.reflect.Field;

public class School {

    public static void inject(Object instance) {

        Field[] fieldsOfStudents = instance.getClass().getDeclaredFields();
        for (Field i : fieldsOfStudents) {
            if (i.isAnnotationPresent(StudentInfo.class)) {
                StudentInfo annotation = i.getAnnotation(StudentInfo.class);
                i.setAccessible(true);
                try {
                    i.set(instance, annotation.name() + " " + annotation.surname() + " " + annotation.age());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        Student classStudent = new Student();

        System.out.println(classStudent.getStudent1());
        System.out.println(classStudent.getStudent2());
        System.out.println(classStudent.getStudent3());

        inject(classStudent);

        System.out.println(classStudent.getStudent1());
        System.out.println(classStudent.getStudent2());
        System.out.println(classStudent.getStudent3());

        try {
            Field field = classStudent.getClass().getDeclaredField("student1");
            field.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}



package homework_Summ_23_11_17;

//Имеется класс Student с полями name, surname, age. Создать аннотацию @StudentInfo и соответствующий инжектор через
// рефлексию, чтобы с их помощью иметь возможность инициализировать переменные типа Student. Например:

//public class School {
//    @StudentInfo(name = "Tom", surname = "Smith", age = 15)
//    private Student student1;
//
//    @StudentInfo(name = "Mary", surname = "Jennings", age = 17)
//    private Student student2;
//}

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Student {

    @StudentInfo(name = "Name1", surname = "Surname1", age = 19)
    private String student1;

    @StudentInfo(name = "Name2", surname = "Surname2", age = 20)
    private String student2;

    @StudentInfo(name = "Name3", surname = "Surname3", age = 21)
    private String student3;

}


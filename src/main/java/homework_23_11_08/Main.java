package homework_23_11_08;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MethodsAndTestsForDataBase md = new MethodsAndTestsForDataBase();

        List<String> names = md.readerWriterDB("src/main/dataBase.txt");

        System.out.println("М-1. Общий список из файла: " + names);
        md.createNewCollectionsWithData(names);
        System.out.println("M-3. Мар: имя = количество таких имен: " + md.getMapOfNames());
        System.out.println("М-4. Самая часто встречающаяся первая буква в именах: " + md.getFirstLetterOfNames());
        System.out.println("М-5. Список номеров телефонов  в числовом формате: " + md.getListOfPhoneNumbersLikeDigit());
        System.out.println("М-6. Группировка имен по длине имени: " + md.groupNamesByLong());
        System.out.println("М-7. Поиск уникальных фамилий: " + md.getUniqueLastNames());
        System.out.println("М-8. Списка имен, отсортированных в обратном алфавитном порядке: " + md.getListWithReversOrder());
        System.out.println("М-9. Преобразование данных в формат имя=номер: " + md.getMapWithNamesAndPhoneNumbers(names));
        System.out.println("М-10. Расчет средней длины имен: " + md.getAverageLongOfName());
        System.out.println("М-11. Мар: номер телефона = имя: " + md.getMapWithPhoneNumbersAndNames());
        md.searchNamesAndPhoneNumbersByLongOfNames();
    }
}

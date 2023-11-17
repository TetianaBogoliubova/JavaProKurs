package homework_23_10_04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainPart1 {
    public static void main(String[] args) {

        //Задание 1: Фильтрация списка целых чисел на нечетные числа
        List<Integer> list = Arrays.asList(32, 1, 6, 5, 4, 9, 9, 9, 9, 87);
        //list.stream();
        List<Integer> list1 = list.stream()
                .filter(digit -> digit % 2 == 1)
                .toList();
        System.out.println(list1);

        //Задание 2: Преобразование списка строк в список чисел
        List<String> listStr = Arrays.asList("1", "2", "89", "45", "12");
        List<Integer> list2 = listStr.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        System.out.println(list2);

        //Задание 3: Суммирование списка чисел
        List<Integer> listSum = Arrays.asList(32, 1, 6, 5, 4, 9, 19, 94, 9, 87);
        int sum = listSum.stream().mapToInt(i -> i).sum();
        System.out.println(sum);

        //Задание 4: Определение максимального значения в списке
        List<Integer> listMaxEl = Arrays.asList(32, 1, 6, 5, 4, 9, 19, 94, 9, 87);
        int max = listMaxEl.stream()
                .mapToInt(v -> v)
                .max()
                .orElse(Integer.MIN_VALUE);
        System.out.println(max);

        //Задание 5: Фильтрация списка строк на те, которые начинаются с определенной буквы и преобразование их в верхний регистр
        List<String> listStrFilter = Arrays.asList("Sorts", "specified", "array", "into", "ascending", "numerical", "order");
        String letter = "s";
        List<String> filterAndUpperCase = listStrFilter.stream()
                .filter(s -> s.toLowerCase().startsWith(letter.toLowerCase()))
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(filterAndUpperCase);

        //Задание 6: Получение списка уникальных слов из списка строк, длина которых больше 4 символов
        List<String> listUniqueStr = Arrays.asList("array", "specified", "array", "into", "ascending", "numerical", "into");
        List<String> list4 = listUniqueStr.stream()
                .filter(s -> s.length() > 4)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list4);

        //Задание 8: Нахождение суммы чисел, кратных 3 и 5, из списка чисел
        List<Integer> listSumEl = Arrays.asList(32, 1, 6, 5, 4, 9, 19, 95, 9, 87);
        int num = listSumEl.stream()
                .filter(digit -> digit % 3 == 0 || digit % 5 == 0)
                .mapToInt(v -> v).sum();
        System.out.println(num);

        //Задание 9: Получение списка слов, содержащих только уникальные символы, из списка строк
        List<String> listUniqueEl = Arrays.asList("array", "specified", "into", "ascending", "numerical");
        List<String> list5 = listUniqueEl.stream()
                .filter(s -> s.chars().distinct().count() == s.length())
                .collect(Collectors.toList());
        System.out.println(list5);
    }
}

package homework_23_10_04;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MainPart2 {
    public static void main(String[] args) {

// Задача 1: Фильтрация четных чисел и умножение на 2.
        List<Integer> list1 = Arrays.asList(32, 1, 6, -5, 4, 9, 19, 95, -9, 87);
        List<Integer> stream1 = list1.stream()
                .filter(digit -> digit % 2 == 0)
                .map(el -> el * 2)
                .toList();
        System.out.println(stream1);

// Задача 2: Удаление дубликатов из списка строк.
        List<String> list2 = Arrays.asList("Convert", "the", "integer", "to", "the", "an", "unsigned", "number");
        List<String> stream2 = list2.stream()
                .distinct()
                .toList();
        System.out.println(stream2);

// Задача 3: Сортировка списка чисел в порядке убывания и выбор первых трех элементов.
        List<Integer> list3 = Arrays.asList(32, 1, 6, -5, 4, 9, 19, 95, -9, 87);
        List<Integer> stream3 = list3.stream()
                .sorted(Collections.reverseOrder())
                .limit(3)
                .toList();
        System.out.println(stream3);

// Задача 4: Фильтрация строк, начинающихся на "A" и преобразование в верхний регистр.
        List<String> list4 = Arrays.asList("This", "class", "also", "contains", "static", "factory", "that", "allows", "arrays", "to be", "viewed", "as lists");
        String letterA = "A";
        List<String> stream4 = list4.stream()
                .filter(s -> s.toLowerCase().startsWith(letterA.toLowerCase()))
                .map(s -> s.toUpperCase())
                .toList();
        System.out.println(stream4);

// Задача 5: Пропуск первых двух элементов и вывод оставшихся.
        List<Integer> list5 = Arrays.asList(32, 1, 6, -5, 4, 9, 19, 95, -9, 87);
        List<Integer> stream5 = list5.stream()
                .skip(2)
                .toList();
        System.out.println(stream5);

// Задача 6: Фильтрация чисел больше 50 и вывод их квадратов.
        List<Integer> list6 = Arrays.asList(32, 1, 6, -5, 4, 9, 19, 95, -9, 87);
        List<Integer> stream6 = list6.stream()
                .filter(s -> s > 50)
                .map(s -> s * s)
                .toList();
        System.out.println(stream6);

// Задача 7: Оставить только слова, содержащие букву "o" и вывести их в обратном порядке.
        List<String> list7 = Arrays.asList("Convert", "the", "integer", "to", "the", "an", "unsigned", "number");
        String letterO = "o";
        List<String> stream7 = list7.stream()
                .filter(s -> s.toLowerCase().contains(letterO.toLowerCase()))
                .sorted(Collections.reverseOrder())
                .toList();
        System.out.println(stream7);

// Задача 8: Фильтрация чисел, оставить только нечетные и вывести их в порядке возрастания.
        List<Integer> list8 = Arrays.asList(32, 1, 6, -5, 4, 9, 19, 95, -9, 87);
        List<Integer> stream8 = list8.stream()
                .filter(s -> s % 2 != 0)
                .sorted()
                .toList();
        System.out.println(stream8);

// Задача 9: Получить среднее значение чисел в списке.
        List<Double> list9 = Arrays.asList(1.0, 6.0, -5.0, 4.0, 9.0, 8.0);
        double sum = list9.stream().mapToDouble(s -> s).sum() / list9.size();
        System.out.println(sum);

// Задача 10: Получить строку, объединяющую элементы списка через запятую.
        List<String> list10 = Arrays.asList("Convert", "the", "integer", "to", "the", "an", "unsigned", "number");
        String stream10 = list10.stream()
                .collect(Collectors.joining(", "));
        System.out.println(stream10);

// Задача 11: Получить список квадратов чисел из другого списка.
        List<Integer> list11 = Arrays.asList(32, 1, 6, -5, 4, 9, 19, 95, -9, 87);
        List<Integer> stream11 = list11.stream()
                .map(s -> s * s)
                .collect(Collectors.toList());
        System.out.println(stream11);

// Задача 12: Получить список букв из списка слов и вывести их в алфавитном порядке.
        List<String> list12 = Arrays.asList("Convert", "the", "integer", "to", "the", "an", "unsigned", "number");
        List<Character> stream12 = list12.stream()
                .map(s -> s.chars().mapToObj(c -> (char) c))
                .flatMap(st -> st)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(stream12);

// Задача 13: Получить первые 3 строки из списка и вывести их в обратном порядке.
        List<String> list13 = Arrays.asList("Convert", "the", "integer", "to", "the", "an", "unsigned", "number");
        List<String> stream13 = list13.stream()
                .limit(3)
                .sorted(Collections.reverseOrder())
                .toList();
        System.out.println(stream13);

// Задача 14: Пропустить первые 2 элемента и оставить только уникальные.
        List<Integer> list14 = Arrays.asList(32, 1, 6, 1, 9, 19, 95, 19, 1);
        List<Integer> stream14 = list14.stream()
                .skip(2)
                .distinct()
                .toList();
        System.out.println(stream14);

// Задача 15: Фильтрация и сортировка пользователей по возрасту.
        Stream<User> stream15 = Stream.of(new User("Name1", 16),
                new User("Name2", 18),
                new User("Name3", 20),
                new User("Name4", 11),
                new User("Name5", 30),
                new User("Name6", 38));

        stream15.filter(s -> s.getAge() > 18)
                .sorted(new AgeComparator())
                .forEach(s -> System.out.printf("%d - %s \n", s.getAge(), s.getName()));
    }
}

class AgeComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.getAge() - o2.getAge();
    }
}
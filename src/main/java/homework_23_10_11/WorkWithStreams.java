package homework_23_10_11;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class WorkWithStreams {
    public void run() {
        m1("Ruby");
        m2(25);
        m3("J");
        m4();
        m5();
        m6();
        m7();
        m8();
        m9();
        m10(3, 2);
        m11(4);
    }

    // 1. Дан список строк. Необходимо найти количество строк, которые содержат заданную подстроку.
    private static void m1(String str) {
        List<String> list = Arrays.asList("Java", "JavaScript", "Python", "Ruby");
        int count = (int) list.stream()
                .filter(s -> s.contains(str))
                .count();
        System.out.println("Количество строк, которые содержат заданную подстроку: " + count);
    }

    // 2. Дан список целых чисел. Необходимо найти максимальный элемент списка, который делится на заданное
    // число без остатка.
    private static void m2(int x) {
        List<Integer> list = Arrays.asList(10, 15, 20, 25, 30);
        int max = list.stream()
                .filter(n -> (n % x) == 0)
                .mapToInt(v -> v)
                .max()
                .orElse(Integer.MIN_VALUE);
        System.out.println("Максимальный элемент, который делится на заданное число " + x + " без остатка: " + max);
    }

    // 3. Дана коллекция объектов класса Person. Класс Person содержит поля name и age. Необходимо найти средний
    // возраст людей, чьи имена начинаются на заданную букву.
    private static void m3(String letter) {
        List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("ane", 25),
                new Person("Jack", 30),
                new Person("ames", 35),
                new Person("Jill", 40)
        );

        int averageAge = (int) people.stream()
                .filter(s -> s.getName().toLowerCase().startsWith(letter.toLowerCase()))
                .mapToDouble(i -> i.getAge())
                .average()
                .orElse(0.0);
        System.out.println("Средний возраст людей, чьи имена начинаются на букву: " + letter + " - " + averageAge);
    }

    // 4. Дана коллекция строк. Необходимо найти все уникальные слова, которые содержатся в этой коллекции строк,
    // и вернуть их в виде списка.
    private static void m4() {
        List<String> lines = Arrays.asList(
                "Java is a programming language.",
                "Java is widely used in enterprise applications.",
                "Python is gaining popularity as a data science tool.",
                "Python is a versatile programming language."
        );
        List<String> newList = lines.stream()
                .flatMap(w -> stream(w.split("\\s+")))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Все уникальные слова, которые содержатся в этой коллекции строк: \n" + newList);
    }

    // 5. Подсчитать буквы в нижнем и верхнем регистре
    private void m5() {
        String ss = "KikJhYggfTgf";
        int bigLetter = (int) ss.chars()
                .filter(big -> Character.isUpperCase(big))
                .count();

        int smallLetter = (int) ss.chars()
                .filter(small -> Character.isLowerCase(small))
                .count();

        System.out.println(" Буквы в верхнем регистре: " + bigLetter + "\n Буквы в нижнем регистре: " + smallLetter);
    }

    // 6. Определите все символьные строки максимальной длины в заданном конечном потоке символьных
    // строк через Optional
    private void m6() {
        Stream<String> stream = Stream.of("we", "wee", "qwer", "oooo");
        Optional<Map.Entry<Integer, List<String>>> max = stream
                .collect(Collectors.groupingBy(s -> s.length()))
                .entrySet()
                .stream()
                .max((en1, en2) -> Integer.compare(en1.getKey(), en2.getKey()));

        max.ifPresent(i -> System.out.println("Все символьные строки максимальной длины: " + i.getValue()));
    }

    // 7. Дан список сотрудников, у каждого из которых есть поле "salary". Необходимо найти среднюю
    // зарплату сотрудников, работающих на должности "developer" в компаниях, которые находятся
    // в городах, начинающихся на букву "M".
    private void m7() {

        List<Employees> employees = Arrays.asList(
                new Employees("Name1", 10000, "M", "Admin"),
                new Employees("Name2", 15000, "O", "Developer"),
                new Employees("Name3", 20000, "M", "Developer"),
                new Employees("Name4", 18000, "N", "Admin"),
                new Employees("Name5", 12000, "M", "Developer"),
                new Employees("Name6", 17000, "D", "Manager")
        );

        String letter = "M";
        double empStream = employees.stream()
                .filter(c -> c.getCity().toLowerCase().startsWith(letter.toLowerCase()))
                .filter(p -> p.getPosition().contains("Developer"))
                .mapToDouble(s -> s.getSalary())
                .average()
                .orElse(0.0);
        System.out.println("Средняя зарплата сотрудников, работающих на должности 'developer' в городе М: " + empStream);
    }

    // 8. У нас есть список списков numbers, и мы хотим получить все четные числа из этих списков.
    // Мы используем flatMap, чтобы преобразовать каждый внутренний список в поток чисел, а затем
    // фильтруем только четные числа. Результат: Even numbers: [2, 4, 6].
    private void m8() {

        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );
        List<Integer> listStream = numbers.stream()
                .flatMap(el -> el.stream())
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Все четные числа из двух списков: " + listStream);
    }

    //  И 9. Есть два списка list1 и list2, и мы хотим получить все возможные комбинации сумм чисел из обоих списков.
    //* Мы используем flatMap, чтобы преобразовать каждый элемент из list1 в поток,
    //* затем применяем map, чтобы создать поток сумм чисел из list1 и list2,
    //* и наконец, собираем все значения в combinedList.
    //* Результат: Combined list: [5, 6, 7, 6, 7, 8, 7, 8, 9].
    private void m9() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> combinedList = list1.stream()
                .flatMap(n -> list2.stream().map(m -> n + m))
                .collect(Collectors.toList());
        System.out.println("Все возможные комбинации сумм чисел из двух списков: " + combinedList);
    }

    // Задача 10. Найти k-ую перестановку из n элементов. Дано число n и число k, необходимо найти k-ую перестановку
    // из n элементов.
    public static List<List<Integer>> findAllMoves(List<Integer> num) {
        if (num == null || num.isEmpty()) {
            return new ArrayList<>();
        }

        if (num.size() == 1) {
            return Arrays.asList(num);
        }

        Integer firstIndex = num.get(0);
        List<List<Integer>> allElementsForMoves = findAllMoves(num.subList(1, num.size()));

        return IntStream.range(0, num.size())
                .boxed()
                .flatMap(i -> {
                    List<List<Integer>> allMoves = new ArrayList<>();
                    for (List<Integer> m : allElementsForMoves) {
                        List<Integer> newMoves = new ArrayList<>(m);
                        newMoves.add(i, firstIndex);
                        allMoves.add(newMoves);
                    }
                    return allMoves.stream();
                })
                .collect(Collectors.toList());
    }

    private void m10(int n, int k) {

        List<Integer> num = Arrays.asList(1, 2, 3);//вносим желаемое количество элементов n
        List<List<Integer>> moves = findAllMoves(num);
        System.out.println("Все перестановки для " + n + " элементов: ");
        moves.forEach(x -> System.out.println(x));

        for (List<Integer> i : moves) {
        }
        System.out.println("При " + n + " элементах k-ая перестановка: " + moves.get(k));
    }

    // Задача 11. Разбить список на подсписки заданного размера. Дан список элементов и размер подсписков. Необходимо
    // разбить список на подсписки указанного размера.

    private List[] m11(int n) {
        List<Integer> list11 = Arrays.asList(6, 28, 9, 41, 9, 10, 4, 23, 9, 15);
        List<List<Integer>> sublists = splitList(list11, n);// Вызов метода splitList для разбиения list11 на подсписки размером n. Результат сохраняется в списке sublists.
        System.out.println("Список разбит на подсписки по " + n + " элементов");
        sublists.forEach(x -> System.out.println(x));//Вывод каждого подсписка в sublists.
        return sublists.toArray(new List[0]);//Преобразование sublists в массив List[] и возвращение его в качестве результата выполнения метода.
    }

    //- Объявление статического метода splitList, который принимает список list и размер подсписков sublistSize.
    static List<List<Integer>> splitList(List<Integer> list, int sublistSize) {
        int size = list.size();//Получение размера списка list.
        int numSublists = (int) Math.ceil((double) size / sublistSize);//
        //Вычисление количества подсписков, округленных в большую сторону, необходимых для разбиения списка list на подсписки размером sublistSize.

        return IntStream.range(0, numSublists)//Создание потока чисел от 0 до numSublists.
                .mapToObj(i -> list.subList(i * sublistSize, Math.min((i + 1) * sublistSize, size)))
                //Для каждого i в потоке создается подсписок, начиная с i * sublistSize и заканчивая Math.min((i + 1) * sublistSize, size).
                .collect(Collectors.toList());//Сбор всех подсписков в список и возвращение этого списка как результат выполнения метода.
    }

    // Задача 12. Найти сумму квадратов простых чисел, которые являются палиндромами в заданном диапазоне.

}




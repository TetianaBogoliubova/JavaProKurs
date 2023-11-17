package homework_23_10_23;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.*;

public class Task {
    private static final Random RANDOM = new Random();

    //Метод readerWriterLine(String fileName) не срабатывает (ошибка: не находит текстовый файл).
// Пока делала задание со строкой имен.
    public List<String> readerWriterLine(String fileName) {
        List<String> nameList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("buffered.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                nameList.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return nameList;
    }

    // 1. Подсчет общего числа имен в файле
    public long countTotalNames(String fileName) {
        String[] words = fileName.split("\\s+");
        return Arrays.stream(words).count();
    }

    // 2. Нахождение уникальных имен в файле
    public Set<String> uniqueNames(String fileName) {
        Set uniqueNamesSet = Collections.singleton(stream(fileName.split("\\s+"))
                .distinct()
                .collect(toList()));
        return uniqueNamesSet;
    }

    // 3. Подсчет числа имен, содержащих заданную подстроку
    public long countNamesContainingSubstring(String fileName, String substring) {
        String[] words = fileName.split("\\s+");

        return Arrays.stream(words)
                .filter(s -> s.contains(substring))
                .count();
    }

    // 4. Нахождение имен, длина которых находится в заданном диапазоне
    public List<String> namesWithLengthInRange(String fileName, int minLength, int maxLength) {
        String[] words = fileName.split("\\s+");

        return Arrays.stream(words)
                .filter(letter -> letter.length() >= minLength && letter.length() <= maxLength)
                .collect(toList());
    }

    // 5. Вывод первых N имен в алфавитном порядке
    public List<String> firstNNamesAlphabetically(String fileName, int n) {
        String[] words = fileName.split("\\s+");

        return Arrays.stream(words)
                .limit(n)
                .sorted()
                .toList();
    }

    // 6. Нахождение пяти самых часто встречающихся имен в файле
    public List<String> topFiveCommonNames(String fileName) {
        String[] words = fileName.split("\\s+");
        Map<String, Long> namesMap = Arrays.stream(words)
                .collect(groupingBy(st -> st.toLowerCase(), counting()));

        return namesMap.entrySet().stream()
                .sorted((name1, name2) -> name2.getValue().compareTo(name1.getValue()))
                .limit(5)
                .map(stringLongEntry -> stringLongEntry.getKey())
                .collect(toList());
    }

    // 7. Нахождение имен, которые начинаются на заданную букву и встречаются больше двух раз
    public Set<String> namesStartingWithAndOccurMoreThanTwice(String fileName, char c) {
        String[] words = fileName.split("\\s+");

        Map<String, Long> namesMap = Arrays.stream(words)
                .collect(groupingBy(st -> st.toLowerCase(), counting()));

        return namesMap.entrySet().stream()
                .filter(l -> l.getValue() > 2)
                .filter(s -> s.getKey().startsWith(String.valueOf(c).toLowerCase()))
                .map(stringLongEntry -> stringLongEntry.getKey())
                .collect(toSet());
    }

    // 8. Нахождение двух имен с самой длинной и самой короткой длиной
    public Pair<String, String> longestAndShortestNames(String fileName) {
        String[] words = fileName.split("\\s+");

        Optional<String> minName = stream(words)
                .min(Comparator.comparing(s -> s.length()));

        Optional<String> maxName = Arrays.stream(words)
                .max(Comparator.comparing(s -> s.length()));
        return new Pair<>(minName.orElse(""), maxName.orElse(""));
    }

    public void getBankCard() {
        int limitNumCard = 9;
        int evenNum;
        int sum = 0;
        int cvv = RANDOM.nextInt(100, 1000);
        int dataMonth = RANDOM.nextInt(01, 12);

        int[] years = {2024, 2025, 2026, 2027, 2028};
        int index = 0;
        for (int i = 0; i < years.length; i++) {
            index = RANDOM.nextInt(years.length);
        }

        int[] numbers = new int[16];
        List<Integer> allNumbers = new ArrayList<>();
        while (allNumbers.size() < 15) {
            int num = RANDOM.nextInt(limitNumCard);
            allNumbers.add(num);
            if (allNumbers.size() % 2 == 0) {
                evenNum = num * 2;
                if (evenNum > 9) {
                    evenNum = evenNum - 9;
                }
                sum = sum + evenNum;
            }
        }
        if (sum % 10 == 0) {
            for (int j = 0; j < allNumbers.size(); j++) {
                numbers[j] = allNumbers.get(j);
            }
            String card = IntStream.of(numbers)
                    .mapToObj(in -> Integer.toString(in))
                    .collect(Collectors.joining(""));
            System.out.println("Банковская карта с верными данными: " + card + dataMonth + years[index] + cvv);
            System.out.println("Банковская карта с верными данными: " + card + "-" + dataMonth + years[index] + "-" + cvv);// для удобства чтения/проверки

        } else getBankCard();
    }
}










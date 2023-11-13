package homework_23_11_08;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MethodsAndTestsForDataBase {

    private static String phoneNumber;
    private static String firstName;
    private static String lastName;
    private static final List<String> allPhoneNumbers = new ArrayList<>();
    private static final List<String> allFirstNames = new ArrayList<>();
    private static final List<String> allLastNames = new ArrayList<>();
    private static final Map<String, String> namesAndPhoneNumbers = new HashMap<>();

    public List<String> readerWriterDB1(String fileName) {
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

    public void createNewCollectionsWithData(List<String> list) {
        for (String i : list) {
            List<String> newList = List.of(i.split("[\\s]+"));
            phoneNumber = newList.get(0);

            if (newList.size() == 5 && (i.contains("Mr.") || i.contains("Mrs."))) {
                firstName = newList.get(newList.size() - 2);
                lastName = newList.get(newList.size() - 1);
            } else if (newList.size() == 4) {
                firstName = newList.get(newList.size() - 2);
                lastName = newList.get(newList.size() - 1);
            } else {
                firstName = newList.get(newList.size() - 3);
                lastName = newList.get(newList.size() - 2);
            }

            allPhoneNumbers.add(phoneNumber);
            allFirstNames.add(firstName);
            allLastNames.add(lastName);
            namesAndPhoneNumbers.put(firstName, phoneNumber);
        }
        System.out.println(namesAndPhoneNumbers);
        //System.out.println(phoneNumber + "**" + firstName + "*" + lastName);
        System.out.println(allFirstNames);
        // System.out.println(allLastNames);
    }

    // 1. Метод для создания мапы, где ключ - первая буква имени, а значение - количество таких имен
    public void getMapOfNames() {
        Map<String, Integer> mapOfNames = new HashMap<>();
        String key = "";
        Integer value;
        for (String i : allFirstNames) {
            value = mapOfNames.get(i);
            if (value == null) {
                value = 0;
            }

            mapOfNames.put(i, value + 1);
        }
        System.out.println(mapOfNames);

        for (Map.Entry<String, Integer> i : mapOfNames.entrySet()) {
            key = i.getKey().substring(0, 1);

        }
        System.out.println(key);
    }

    // 2.- Метод для нахождения самой часто встречающейся первой буквы в именах

    public void getFirstLetterOfNames() {
        Map<String, Integer> mapOfNames = new HashMap<>();
        String key;
        Integer value;
        for (String i : allFirstNames) {
            key = i.substring(0, 1);
            value = mapOfNames.getOrDefault(key, 0);
            mapOfNames.put(key, value + 1);
        }
        mapOfNames.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }

    // 3.- Метод для создания списка номеров телефонов, где каждый номер преобразован в числовой формат

    public List<Long> getListOfPhoneNumbersLikeDigit() {
        return allPhoneNumbers.stream()
                .map(n -> Long.parseLong(n.replaceAll("[^0-9]", "")))
                .collect(Collectors.toList());
    }

    // 4.- Метод для группировки имен по длине имени
    public void groupNamesByLong() {
        Map<String, Integer> mapGroupNames = new HashMap<>();
        int longOfName;
        for (String i : allFirstNames) {
            if (i.length() > 0) {
                longOfName = i.length();
                mapGroupNames.put(i, longOfName);
            }
        }
        System.out.println(mapGroupNames);
    }

    // 5. - Метод для поиска уникальных фамилий
    public List<String> getUniqueLastNames() {
        return allLastNames.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    // 6. - Метод для создания списка имен, отсортированного в обратном алфавитном порядке
    public List<String> getListWithReversOrder() {
        allFirstNames.sort(Collections.reverseOrder());
        return allFirstNames;
    }


    // 7. - Метод для преобразования данных в формат имя=номер
    //Смотреть метод createNewCollectionsWithData(List<String> list) или создать идентичный:
    public Map<String, String> getMapWithNamesAndPhoneNumbers(List<String> list) {

        Map<String, String> newMap = new HashMap<>();

        for (String i : list) {
            List<String> newList = List.of(i.split("[\\s]+"));
            phoneNumber = newList.get(0);

            if (newList.size() == 5 && (i.contains("Mr.") || i.contains("Mrs."))) {
                firstName = newList.get(newList.size() - 2);
                lastName = newList.get(newList.size() - 1);
            } else if (newList.size() == 4) {
                firstName = newList.get(newList.size() - 2);
                lastName = newList.get(newList.size() - 1);
            } else {
                firstName = newList.get(newList.size() - 3);
                lastName = newList.get(newList.size() - 2);
            }
            newMap.put(firstName, phoneNumber);
        }
        return newMap;
    }

    // 8. - Метод для расчета средней длины имен

    public int getAverageLongOfName() {
        return (int) allFirstNames.stream()
                .mapToInt(el -> el.length())
                .average()
                .orElse(0);
    }

    // 9. - Метод для создания карты, где ключ - номер телефона, а значение - имя
    public Map<String, String> getMapWithPhoneNumbersAndNames() {
        Map<String, String> newMap = new HashMap<>();
        for (Map.Entry i : namesAndPhoneNumbers.entrySet()) {
            newMap.put((String) i.getValue(), (String) i.getKey());
        }
        return newMap;
    }

    // 10. - Метод для поиска контактов с максимальной и минимальной длиной имени
    public void searchNamesAndPhoneNumbersByLongOfNames() {
        Map.Entry<String, String> minLongMap = null;
        Map.Entry<String, String> maxLongMap = null;

        List<Map.Entry<String, String>> minLongList = new ArrayList<>();
        List<Map.Entry<String, String>> maxLongList = new ArrayList<>();

        for (Map.Entry<String, String> i : namesAndPhoneNumbers.entrySet()) {
            if (minLongMap == null || i.getKey().length() < minLongMap.getKey().length()) {
                minLongMap = i;
                minLongList.clear();
                minLongList.add(i);
            } else if (i.getKey().length() == Objects.requireNonNull(minLongMap.getKey()).length()) {
                minLongList.add(i);
            }
            if (maxLongMap == null || i.getKey().length() > maxLongMap.getKey().length()) {
                maxLongMap = i;
                maxLongList.clear();
                maxLongList.add(i);
            } else if (i.getKey().length() == Objects.requireNonNull(maxLongMap.getKey()).length()) {
                maxLongList.add(i);
            }
        }
        maxLongList.forEach(System.out::println);
        minLongList.forEach(System.out::println);

    }
}






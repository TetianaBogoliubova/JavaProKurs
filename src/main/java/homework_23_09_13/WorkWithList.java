package homework_23_09_13;

import homework_23_09_13.comparators.*;

import java.util.*;

public class WorkWithList {

    // Уровень сложности 5 из 10:

    // 1.Найти сумму всех элементов ArrayList<Integer>.
    public int getSumAllNumbers(List<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            sum = sum + integer;
        }
        return sum;
    }

    //2. Найти среднее значение элементов LinkedList<Integer>.
    public int getAverageNumbers(List<Integer> list) {
        int aver = 0;
        int sumAver = 0;

        for (Integer i : list) {
            aver += i;
            sumAver = aver / list.size();
        }
        return sumAver;
    }

    //3. Перебрать ArrayList<String> и вывести все элементы на экран.
    public String getOutputStringList(List<String> list) {
        String str = "";
        for (String i : list) {
            str += i;
        }
        return str;
    }

    //4. Перебрать LinkedList<String > и найти самую длинную строку.
    public String getLargestList(List<String> list) {
        String str = "";
        for (String i : list) {
            if (i.length() > str.length()) {
                str = i;
            }
        }
        return str;
    }

    //5. Создать ArrayList с объектами вашего собственного класса и вывести их на экран.
    public List<MyClass> getListFromMyClass(List<MyClass> list) {
        return list;
    }

//    Уровень сложности 6 из 10:

    //6. Перебрать ArrayList<Integer> и найти наименьший элемент.
    public int getLessNumber(List<Integer> list) {
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Integer current = list.get(i);
            if (current < min) {
                min = current;
            }
        }
        return min;
    }

    //7. Перебрать LinkedList<Integer> и найти наибольший элемент.
    public int getMaxNumber(List<Integer> list) {
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Integer current = list.get(i);
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

    //8. Перебрать ArrayList<String> и найти количество элементов, начинающихся с определенной буквы.
    public void getStringWithFirstLetter(List<String> list, char x) {
        int j = 0;
        for (String i : list) {
            char firstLetter = i.charAt(0);
            if (firstLetter == x) {
                j++;
            }
        }
        System.out.println("Letter " + x + " repeats " + j);

    }

    //9. Перебрать LinkedList<String> и найти первое вхождение определенной строки.
    public void getFirstEntry(List<String> list, String str) {
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            String currentWord = list.get(i);
            if (currentWord.equals(str)) {
                j = i;
                break;
            }
        }
        System.out.println("Index of first entry for " + str + " is " + j);
    }

    //10. Создать LinkedList с объектами вашего собственного класса и удалить все элементы, удовлетворяющие определенному условию.
    public List getListWithoutSpecialElements(List<MyClass> list, int arg) {
        List<MyClass> newList = new LinkedList<>();
        for (MyClass i : list) {
            if (i.getAccount() != arg) {
                newList.add(i);
            }
        }
        list.clear();
        list.addAll(newList);
        return list;
    }

//    Уровень сложности 7 из 10:

    //11. Перебрать ArrayList<Integer> и удалить все четные числа.
    public List getListWithoutEverNumbers(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();

        for (Integer i : list) {
            if (i % 2 != 0) {
                newList.add(i);
            }
        }
        list.clear();
        list.addAll(newList);
        return list;
    }

    //12. Перебрать LinkedList<Integer> и заменить все элементы, кратные 3, на нули.
    public List getListWithNumberMultiplesOfThree(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (Integer i : list) {
            if (i % 3 == 0) {
                newList.add(0);
            } else newList.add(i);
        }
        list.clear();
        list.addAll(newList);
        return list;
    }

    //13. Перебрать ArrayList<String> и объединить все элементы в одну строку.
    public void connectStrings(List<String> list) {
        String connectElement = " ";
        StringBuilder stringBuilder = new StringBuilder();

        int i = 0;
        while (i < list.size() - 1) {
            stringBuilder.append(list.get(i));
            stringBuilder.append(connectElement);
            i++;
        }
        stringBuilder.append(list.get(i));
        System.out.println(stringBuilder.toString());
    }

    //14. Перебрать LinkedList<String> и удалить все элементы, содержащие определенную подстроку.
    public List deleteElementWithString(List<String> list, String str) {
        List<String> newList = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            String currentString = list.get(i);
            if (currentString != str) {
                newList.add(list.get(i));
            }
        }
        list.clear();
        list.addAll(newList);
        return list;
    }

    //15. Создать ArrayList с объектами вашего собственного класса и вывести только те, которые удовлетворяют определенному условию.
    public void getListWithSpecialCondition(List<MyClass> list, String str1, String str2) {
        for (MyClass i : list) {
            if (i.getCategory().equals(str1) || i.getCategory().equals(str2)) {
                System.out.println(i);
            }
        }
    }
    //    Уровень сложности 8 из 10:

    //16. Перебрать ArrayList<Integer> и найти сумму квадратов всех элементов.
    public int getSumSquareNumbers(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            int square = i * i;
            sum = sum + square;

        }
        return sum;
    }

    //17. Перебрать LinkedList<Integer> и вычислить произведение всех элементов.
    public int getProductOfAllNumbers(List<Integer> list) {
        int currentProduct = 1;
        for (Integer i : list) {
            currentProduct *= i;
        }
        return currentProduct;
    }

    //18. Перебрать ArrayList<String> и найти самую короткую строку.
    public String getShortString(List<String> list) {
        String firstShotString = list.get(0);
        for (String i : list) {
            if (i.length() < firstShotString.length()) {
                firstShotString = i;
            }
        }
        return firstShotString;
    }

    //19. Перебрать LinkedList<String> и заменить все гласные буквы в каждой строке на символ '*'.
    public void changeVowelLetters(List<String> list) {

        for (String i : list) {
            System.out.println(i.replaceAll("[aeyuioAEYUIO]", "*"));
        }
    }

    //20.Создать LinkedList с объектами вашего собственного класса и отсортировать их в порядке убывания.
    public void sortListDescendingOrder(List<MyClass> list) {
        Collections.sort(list, new ComparatorMyClass_20());
        for (MyClass i : list) {
            System.out.println(i);
        }
    }

//    Уровень сложности 9 из 10:

    //21.Перебрать ArrayList<Integer> и найти второй по величине элемент.
    public int getSecondLargestNumber(List<Integer> list) {
        Collections.sort(list, Collections.reverseOrder());
        return list.get(1);
    }

    //22. Перебрать LinkedList<Integer> и вывести все элементы в обратном порядке.
    public void getListWithReverseOrder(List<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }

    //23. Перебрать ArrayList<String> и вывести все строки, содержащие только буквы.
    public void getStringWithoutNumbers(List<String> list) {

        for (String i : list) {
            if ((!i.matches(".*[0123456789].*")) && (!i.matches(".*[,:.!*_+=;<>].*"))) {
                System.out.println(i);
            }
        }
    }

    //24. Перебрать LinkedList<String> и найти самую длинную строку, не содержащую пробелов.
    public String getLongerStringWithoutSpace(List<String> list) {
        String longString = "";
        for (String i : list) {
            if ((!i.contains(" ")) && i.length() > longString.length()) {
                longString = i;
            }
        }
        return longString;
    }

    //25. Создать ArrayList с объектами вашего собственного класса и отфильтровать только уникальные элементы.
    public void getMyListWithUniqueElements(List<MyClass> list) {
        Set<MyClass> myUniqueList = new HashSet<>(list);
        System.out.println(new ArrayList<>(myUniqueList));
    }

//    Уровень сложности 10 из 10:

    //26. Перебрать ArrayList<Integer> и найти наибольшую возрастающую последовательность элементов.
    public List<Integer> getListWithLargestOrder(List<Integer> list) {
        List<Integer> largestOrder = new ArrayList<>();
        List<Integer> currentOrder = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            currentOrder.add(list.get(i));
            if (list.get(i + 1) <= list.get(i)) {
                if (currentOrder.size() > largestOrder.size()) {
                    largestOrder = new ArrayList<>(currentOrder);
                }
                currentOrder.clear();
            }
        }
        currentOrder.add(list.get(list.size() - 1));
        if (currentOrder.size() > largestOrder.size()) {
            largestOrder = new ArrayList<>(currentOrder);
        }
        return largestOrder;
    }

    //27. Перебрать LinkedList<Integer> и удалить все дубликаты элементов.
    public List deleteDuplicates(List<Integer> list) {

        int i = 0;
        while (i < list.size()) {

            int current = list.get(i);
            int count = 0;

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == current) {
                    count++;
                }
            }
            if (count > 1) {
                for (int j = 0; j < count - 1; j++) {
                    list.remove((Integer) current);
                }
            } else {
                i++;
            }
        }
        return list;
    }

    //28. Перебрать ArrayList<String> и создать новый список, содержащий только уникальные строки.
    public List createListWithUniqueStrings(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String i : list) {
            if (!newList.contains(i)) {
                newList.add(i);
            }
        }
        return newList;
    }

    //29. Перебрать LinkedList<String> и объединить все строки в одну с использованием разделителя.
    public String connectAllString(List<String> list) {

        String connectElement = " + ";
        String result = String.join(connectElement, list);
        return result;
    }

    //30. Создать LinkedList с объектами вашего собственного класса и отсортировать их по нескольким критериям.
    public void sortMyListWithDifferentCriterias(List<MyClass> list) {
        LinkedList<MyClass> newList = new LinkedList<>(list);

        Collections.sort(newList, new IdComparator());
        System.out.println(newList);
        Collections.sort(newList, new AccountComparator());
        System.out.println(newList);
        Collections.sort(newList, new NameComparator());
        System.out.println(newList);
        Collections.sort(newList, new CategoryComparator());
        System.out.println(newList);
    }


    // метод 1.
    public List<String> test1(List<String> list, int number) {
        List<String> newList = new ArrayList<>();
        for (String i : list) {
            if (number == i.length()) {
                newList.add(i);
            }
        }
        return newList;
    }

    // метод 2.
    public List<Integer> test2(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (Integer i : list) {
            if (i % 2 != 0) {
                newList.add(i);
            }
        }
        list.clear();
        list.addAll(newList);
        return list;
    }

}











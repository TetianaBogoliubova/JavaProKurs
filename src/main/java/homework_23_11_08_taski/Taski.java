package homework_23_11_08_taski;

import java.util.List;

public class Taski {

    // 1. Удаление звездочки и символа перед ней. Совпадает ли s2 и s1.
    //    s1 = aaa
    //    s2 = aaaaaa###     ##aaa###aaa

    public boolean task1(String str) {
        StringBuilder sb = new StringBuilder(str);
        String mainString = "aaa";
        int index;
        while (sb.indexOf("#") >= 0 && !sb.toString().equals(mainString)) {
            index = sb.indexOf("#");
            if (index > 0) {
                sb.delete(index - 1, index + 1);
            } else {
                sb.deleteCharAt(index);
            }
        }
        System.out.print(sb + " ");
        if (sb.toString().equals(mainString)) {
            return true;
        }
        return false;
    }

    // 2. Возвращение курсора на первоначальное место
    // s = "LDLDRURU"
    public boolean task2(String str) {

        List<String> letters = List.of(str.split(""));

        int countR = (int) letters.stream().filter(el -> el.contains("R")).count();
        int countL = (int) letters.stream().filter(el -> el.contains("L")).count();
        int countD = (int) letters.stream().filter(el -> el.contains("D")).count();
        int countU = (int) letters.stream().filter(el -> el.contains("U")).count();

        if (countL != countR || countD != countU) {
            return false;
        } else {
            return true;
        }
    }

    // 3. Поиск и подсчет указанных символов в строке
    //    j= "ahT"
    //    s = "uyahhTyRthh"     количество вх-х букв
    public int task3(String str) {
        List<String> letters = List.of(str.split(""));
        int countA = (int) letters.stream().filter(el -> el.contains("a")).count();
        int countH = (int) letters.stream().filter(el -> el.contains("h")).count();
        int countT = (int) letters.stream().filter(el -> el.contains("T")).count();
        return countA + countH + countT;

    }
}

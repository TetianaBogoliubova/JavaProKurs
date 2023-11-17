package homework_Summ_23_11_10;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Task task = new Task();

        String[] arrayStr = new String[]{"One", "Two", "Three"};
        Integer[] arrayInt = new Integer[]{1, 2, 3, 4, 5, 6};


        Filter<String> filterForString = s -> s.length() == 3;
        String[] newString = task.filterData(arrayStr, filterForString);

        System.out.println("1 string: " + Arrays.toString(arrayStr));
        System.out.println("2 string: " + Arrays.toString(newString));

        Filter<Integer> filterForInteger = in -> in % 2 == 0;
        Integer[] newInteger = task.filterData(arrayInt, filterForInteger);

        System.out.println("1 integer: " + Arrays.toString(arrayInt));
        System.out.println("2 integer: " + Arrays.toString(newInteger));
    }
}

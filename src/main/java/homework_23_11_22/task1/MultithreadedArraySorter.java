package homework_23_11_22.task1;

//Создайте класс MultithreadedArraySorter с массивом целых чисел.
//Реализуйте метод sort(), который будет разделять массив на подмассивы и сортировать их в отдельных
//потоках с помощью пула потоков newFixedThreadPool.

import java.util.Arrays;

public class MultithreadedArraySorter {

    private final int[] array = {8, 5, 9, 7, 1, 4, 3, 6, 2, 10};

    public int[] getArray() {
        return array;
    }

    public void sort() {

        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        System.out.println("Сортировка в основном потоке: " + Arrays.toString(array));
    }
}

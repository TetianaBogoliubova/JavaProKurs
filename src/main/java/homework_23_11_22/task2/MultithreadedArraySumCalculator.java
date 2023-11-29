package homework_23_11_22.task2;

// 2: Многопоточный Подсчет Суммы в Массиве
// Цель задания: Реализовать многопоточный подсчет суммы элементов в массиве целых чисел.

// Создайте класс MultithreadedArraySumCalculator с массивом целых чисел.
// Реализуйте метод calculateSum(), который будет делить массив на части и распределять подсчет суммы по
// разным потокам. Для создания потоков используйте newFixedThreadPool.

public class MultithreadedArraySumCalculator {
    private final int[] array = {1, 2, 3, 2, 3, 3, 4, 5, 1};

    public int[] getArray() {
        return array;
    }

//    public void setArray(int[] array) {
//        this.array = array;
//    }

    public void calculateSum() {
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        for (int i = 0; i < array.length; i++) {
            if (i < 3) {
                sum1 += array[i];

            } else if (i > 2 && i < 6) {
                sum2 += array[i];

            } else {
                sum3 += array[i];
            }
        }

        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
        synchronized (this) {
            System.out.print(sum1 + sum2 + sum3);
            System.out.println(" - Общая сумма массива ");
        }
    }
}


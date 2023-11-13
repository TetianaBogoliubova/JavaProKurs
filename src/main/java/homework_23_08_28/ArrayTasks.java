package homework_23_08_28;

public class ArrayTasks {
    public void getTask1(int[] array) {
        //Найти среднее арифметическое положительных элементов массива.

        double sumEvenNumbers = 0;
        int count = 0;
        for (int i : array) {
            if (i > 0) {
                sumEvenNumbers += i;
                count++;
            }
        }
        if (count > 0) {
            double average = sumEvenNumbers / count;
            System.out.println("Cреднее арифметическое положительных элементов массива = " + average);
        }
    }

    public void getTask2(int[] array) {
        //Найти сумму всех элементов в массиве, которые делятся на 3 и одновременно не делятся на 5.

        int sum = 0;

        for (int i : array) {
            if (i % 3 == 0 && i % 5 != 0) {
                sum = sum + i;
            }
        }
        System.out.println("Сумма всех элементов в массиве, которые делятся на 3 и одновременно не делятся на 5 =  " + sum);
    }

    public void getTask3(int[] array) {
        //Найти в массиве наибольшую сумму подряд идущих элементов.

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = 0;
            for (int j = i; j < array.length; j++) {
                sum = sum + array[j];

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        System.out.println("Наибольшая сумма подряд идущих элементов = " + maxSum);
    }
}

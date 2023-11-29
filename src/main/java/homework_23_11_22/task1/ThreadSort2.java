package homework_23_11_22.task1;

import java.util.Arrays;

public class ThreadSort2 implements Runnable {
    private final MultithreadedArraySorter mas;

    public ThreadSort2(MultithreadedArraySorter mas) {
        this.mas = mas;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Сортировка второй части массива ");
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = mas.getArray().length - 1; i > mas.getArray().length / 2; i--) {
                if (mas.getArray()[i] < mas.getArray()[i - 1]) {
                    temp = mas.getArray()[i];
                    mas.getArray()[i] = mas.getArray()[i - 1];
                    mas.getArray()[i - 1] = temp;
                    sorted = false;
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + Arrays.toString(mas.getArray()));
    }
}

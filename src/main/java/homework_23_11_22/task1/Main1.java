package homework_23_11_22.task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main1 {
    public static void main(String[] args) {

        MultithreadedArraySorter mas = new MultithreadedArraySorter();

        mas.sort();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new ThreadSort1(mas));
        executorService.submit(new ThreadSort2(mas));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }
}

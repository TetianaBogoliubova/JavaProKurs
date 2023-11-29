package homework_23_11_22.task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main2 {
    public static void main(String[] args) {
        MultithreadedArraySumCalculator msc = new MultithreadedArraySumCalculator();

        // msc.calculateSum(); - общий метод для основного потока

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(new ThreadSum1(msc));
        executorService.submit(new ThreadSum2(msc));
        executorService.submit(new ThreadSum3(msc));
        executorService.submit(new ThreadSum4(msc));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}

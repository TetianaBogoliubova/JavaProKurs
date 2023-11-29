package homework_23_11_22.task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main3 {
    public static void main(String[] args) {

        MultithreadedFactorialCalculator mfc = new MultithreadedFactorialCalculator();
        int iterations = 1000000;

        double pi = mfc.calculatePiLeibniz(iterations);
        System.out.println("Значение π из основного потока: " + pi);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        int halfIt = iterations / 2;

        ThreadFactorial1 thread1 = new ThreadFactorial1(mfc, 0, halfIt);
        ThreadFactorial1 thread2 = new ThreadFactorial1(mfc, halfIt, iterations);

        executorService.submit(thread1);
        executorService.submit(thread2);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();

        double piThread = thread1.getResult() + thread2.getResult();
        System.out.println("Значение π, вычисленное в двух потоках: " + piThread);
    }
}

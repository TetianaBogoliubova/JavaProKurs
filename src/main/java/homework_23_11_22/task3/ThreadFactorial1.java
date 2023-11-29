package homework_23_11_22.task3;

public class ThreadFactorial1 implements Runnable {

    private final MultithreadedFactorialCalculator mfc;
    private final int start;
    private final int end;
    private double result;

    public ThreadFactorial1(MultithreadedFactorialCalculator mfc, int start, int end) {
        this.mfc = mfc;
        this.start = start;
        this.end = end;
    }

    public double getResult() {
        return result;
    }

    @Override
    public void run() {
        double pi = 0;

        for (int i = start; i < end; i++) {
            double term = 1.0 / (2 * i + 1);
            if (i % 2 == 0) {
                pi += term;
            } else {
                pi -= term;
            }
        }
        result = 4 * pi;
    }
}

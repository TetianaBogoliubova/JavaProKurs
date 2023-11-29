package homework_23_11_22.task2;

class ThreadSum1 implements Runnable {
    MultithreadedArraySumCalculator msc;

    public ThreadSum1(MultithreadedArraySumCalculator msc) {
        this.msc = msc;
    }

    @Override
    public void run() {

        int sum1 = 0;
        for (int i = 0; i < msc.getArray().length; i++) {
            if (i < 3) {
                sum1 += msc.getArray()[i];
            }
        }
        System.out.println("Сумма чисел первой части массива: " + sum1);
    }
}

class ThreadSum2 implements Runnable {
    MultithreadedArraySumCalculator msc;

    public ThreadSum2(MultithreadedArraySumCalculator msc) {
        this.msc = msc;
    }

    @Override
    public void run() {

        int sum2 = 0;
        for (int i = 0; i < msc.getArray().length; i++) {
            if (i > 2 && i < 6) {
                sum2 += msc.getArray()[i];
            }
        }
        System.out.println("Сумма чисел второй части массива: " + sum2);
    }
}

class ThreadSum3 implements Runnable {
    MultithreadedArraySumCalculator msc;

    public ThreadSum3(MultithreadedArraySumCalculator msc) {
        this.msc = msc;
    }

    @Override
    public void run() {

        int sum3 = 0;
        for (int i = 0; i < msc.getArray().length; i++) {
            if (i > 5) {
                sum3 += msc.getArray()[i];
            }
        }
        System.out.println("Сумма чисел третей части массива: " + sum3);
    }
}

class ThreadSum4 implements Runnable {
    MultithreadedArraySumCalculator msc;

    public ThreadSum4(MultithreadedArraySumCalculator msc) {
        this.msc = msc;
    }

    @Override
    public void run() {
        msc.calculateSum();
    }
}

package homework_23_11_27;

import java.io.*;

public class Restaurant {

    private boolean isReady = false;

    public void createFileForReview() {
        try {
            File file = new File("count_of_review.txt");
            if (file.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("false");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void countAllReview(String filePath, String phrase) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (int i = 0; i < 50; i++) {
                writer.write(phrase + "\n - " + i++);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void cookDish1() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Cook готовит заказ");
        isReady = true;
        System.out.println("Заказ готов");
        notifyAll();
    }

    public synchronized void takeDish(String name) {
        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " забрал блюдо");
        notifyAll();
        System.out.println(name + " разносит заказы по залу");

        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " принес повару новые заказы");
        isReady = true;
        notifyAll();
    }
}


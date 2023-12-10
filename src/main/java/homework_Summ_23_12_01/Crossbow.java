package homework_Summ_23_12_01;

import java.util.Scanner;
//Арбалет. См. класс Crossbow в репозитории.
//Стрелок robinHood в одном потоке стреляет из арбалета, его помощник servant в другом потоке приносит
//ему колчан, когда стрелы закончатся.
//Заготовка логики в классе Crossbow. Доработать логику, чтобы:
//    - стрельба продолжалась бесконечно
//    - количество приносимых стрел каждый раз определял бы пользователь, вводя число arrows через консоль

public class Crossbow {
    private final Scanner scanner = new Scanner(System.in);

    synchronized public void fire() {
        while (true) {
            System.out.println("Enter the number of arrows");
            int arrows = scanner.nextInt();

            for (int idx = arrows; idx >= 0; idx--) {
                if (idx != 0) {
                    System.out.println("The arrow is " + (arrows - idx + 1) + " right on the target!");
                } else {
                    System.out.println("The arrows are over");
                    System.out.println("Count arrows " + arrows);
                    System.out.println("Carry a new quiver with arrows!!");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    synchronized public void reload() {
        System.out.println("New arrows on the way!");
        notify();
    }

    public static void main(String[] args) {
        Crossbow crossbow1 = new Crossbow();
        Thread robinHood = new Thread(crossbow1::fire);
        Thread servant = new Thread(crossbow1::reload);

        robinHood.start();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        servant.start();
    }
}

package addPracticeTasks.test;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Play {
    private String player1 = new Faker().country().capital().toUpperCase();
    private String player2 = new Faker().country().capital().toUpperCase();
    private List<String> allCity = new ArrayList<>();

    public void playStart() {
        System.out.println("Начало игры!");
        System.out.println("Игрок № 1 вводит первый город: " + player1);
        System.out.println("Игрок № 2 вводит первый город: " + player2);
        if (!player1.equals(player2)) {
            if (!allCity.contains(player1)) {
                allCity.add(player1);
            } else {
                player1 = new Faker().country().capital().toUpperCase();
                allCity.add(player1);
            }
            if (!allCity.contains(player2)) {
                allCity.add(player2);

            } else {
                player2 = new Faker().country().capital().toUpperCase();
                allCity.add(player2);
            }
        }
        System.out.println("Первые города игроков: " + allCity);
    }

    public void playOn() {

        do {
            System.out.println("Города игроков разные, поэтому они сохраняются в общей базе");
            System.out.print("Игрок № 1 вводит название города: ");
            System.out.println(player1 = new Faker().country().capital().toUpperCase());
            System.out.print("Игрок № 2 вводит название города: ");
            System.out.println(player2 = new Faker().country().capital().toUpperCase());

            if (!allCity.contains(player1)) {
                allCity.add(player1);
            }
            if (!allCity.contains(player2)) {
                allCity.add(player2);
            }
            Collections.sort(allCity);

            System.out.println(allCity);

        } while (!player1.equals(player2) || !allCity.contains(player1) || !allCity.contains(player2));
        System.out.println("Города игроков совпали, игра закончилась!");
    }
}








package homework_23_11_29;

import javax.xml.crypto.Data;
import java.util.*;

public class GeneralPlay {
    List<List<Player>> result2 = new ArrayList<>();
    Player player = new Player();
    private double countPlayer1;
    private double countPlayer2;
    private Player player1;
    private Player player2;
    private List<List<Player>> allPairs = new ArrayList<>();


    public List<List<Player>> getAllPairs() {
        return allPairs;
    }

    public void setAllPairs(List<List<Player>> allPairs) {
        this.allPairs = allPairs;
    }

    public double getCountPlayer1() {
        return countPlayer1;
    }

    public void setCountPlayer1(double countPlayer1) {
        this.countPlayer1 = countPlayer1;
    }

    public double getCountPlayer2() {
        return countPlayer2;
    }

    public void setCountPlayer2(double countPlayer2) {
        this.countPlayer2 = countPlayer2;
    }

    public void playAllPlayers(List<Player> list) {

        Map<Integer, Double> result1 = new HashMap<>();
        Map<Integer, Double> result2 = new HashMap<>();

        // List<List<Player>> allPairs = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                player1 = list.get(i);
                player2 = list.get(j);

                if (player1.getPositions().contains(Position.PAPER) && player2.getPositions().contains(Position.STONE) ||
                        player1.getPositions().contains(Position.STONE) && player2.getPositions().contains(Position.SCISSORS) ||
                        player1.getPositions().contains(Position.SCISSORS) && player2.getPositions().contains(Position.PAPER)) {

                    setCountPlayer1(countPlayer1 + 1);
                    setCountPlayer2(countPlayer2 + 0);

                    result1.put(player1.getId(), getCountPlayer1());
                    result1.put(player2.getId(), getCountPlayer2());


                } else if (player1.getPositions().contains(Position.PAPER) && player2.getPositions().contains(Position.PAPER) ||
                        player1.getPositions().contains(Position.STONE) && player2.getPositions().contains(Position.STONE) ||
                        player1.getPositions().contains(Position.SCISSORS) && player2.getPositions().contains(Position.SCISSORS)) {
                    setCountPlayer1(countPlayer1 + 0.5);
                    setCountPlayer2(countPlayer2 + 0.5);

                    result1.put(player1.getId(), getCountPlayer1());
                    result1.put(player2.getId(), getCountPlayer2());

                } else {
                    setCountPlayer1(countPlayer1 + 0);
                    setCountPlayer2(countPlayer2 + 1);
                }
                // result1.put(player1.getId(), result1.getOrDefault(player1.getId(), 0.0) + countPlayer1);
                // result2.put(player2.getId(), result2.getOrDefault(player2.getId(), 0.0) + countPlayer2);

                // result2.putIfAbsent(player2.getId(), 0.0);
                result1.put(player1.getId(), getCountPlayer1());
                result1.put(player2.getId(), getCountPlayer2());
            }
        }

        // result1.put(player1.getId(), countPlayer1);
        //result2.put(player2.getId(), countPlayer2);
        //////////////////////////////////////////////////////////////////
        // // System.out.println(" Pl1 - " + player1);
        // // System.out.println(" Pl2 - " + player2);
        List<Player> playersPair = new ArrayList<>();
        playersPair.add(player1);
        playersPair.add(player2);
        allPairs.add(playersPair);
        System.out.println("count1 = " + countPlayer1 + "; count2 = " + countPlayer2);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(allPairs);
    }


    public double playLogic(Position player1, Position player2) {
        if (player1.equals(Position.PAPER) && player2.equals(Position.STONE) ||
                player1.equals(Position.STONE) && player2.equals(Position.SCISSORS) ||
                player1.equals(Position.SCISSORS) && player2.equals(Position.PAPER)) {
            System.out.print("Player 1 получает ");
            return countPlayer1 + 1;

        } else if (player1.equals(player2)) {
            System.out.print("Player 1 получает ");
            return countPlayer1 + 0.5;

        } else if (player2.equals(player1)) {
            System.out.print("Player 2 получает ");
            return countPlayer2 + 0.5;
        } else {
            System.out.print("Player 2 получает ");
            return countPlayer2 + 1;
        }

    }

    public void sravnenie(List<List<Player>> list) {

        Position indP1 = null;
        Position indP2 = null;
        Player pl1;
        Player pl2;

        for (List<Player> p : list) {
            pl1 = p.get(0);
            pl2 = p.get(1);

            for (int i = 0; i < pl1.getPositions().size(); i++) {
                for (int j = 0; j < pl2.getPositions().size(); j++) {
                    indP1 = pl1.getPositions().get(i);
                    indP2 = pl2.getPositions().get(j);
                    playLogic(indP1, indP2);
                }
            }
            System.out.println(pl1);
            System.out.println(pl2);
        }

        System.out.println("Position - " + playLogic(indP1, indP2));
    }

    //////////////////
    public void playAllPlayers1(List<Player> list) {
        Map<Integer, Double> result1 = new HashMap<>();
        // Map<Integer, Double> result2 = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            Player player1 = list.get(i);

            for (int j = i + 1; j < list.size(); j++) {
                Player player2 = list.get(j);

                // double countPlayer1 = calculateScore(player1, player2);
                //double countPlayer2 = calculateScore(player2, player1);

                // Обновляем результаты для обоих игроков
                result1.put(player1.getId(), result1.getOrDefault(player1.getId(), 0.0) + countPlayer1);
                result1.put(player2.getId(), result1.getOrDefault(player2.getId(), 0.0) + countPlayer2);

                // Добавляем результаты для игрока 2, если он еще не добавлен
                // result2.putIfAbsent(player2.getId(), 0.0);
            }
        }

        System.out.println("count1 = " + result1);
        // System.out.println("count2 = " + result2);
    }

    private double calculateScore(Player pl1, Player pl2) {//(Player player1, Player player2) {

        double count1 = 0;
        double count2 = 0;

        if (player1.getPositions().contains(Position.PAPER) && player2.getPositions().contains(Position.STONE) ||
                player1.getPositions().contains(Position.STONE) && player2.getPositions().contains(Position.SCISSORS) ||
                player1.getPositions().contains(Position.SCISSORS) && player2.getPositions().contains(Position.PAPER)) {
            return count1 += 1.0;
        } else if (player1.getPositions().contains(Position.PAPER) && player2.getPositions().contains(Position.PAPER) ||
                player1.getPositions().contains(Position.STONE) && player2.getPositions().contains(Position.STONE) ||
                player1.getPositions().contains(Position.SCISSORS) && player2.getPositions().contains(Position.SCISSORS)) {
            return count1 += 0.5;
        } else if (player1.getPositions().contains(Position.PAPER) && player2.getPositions().contains(Position.PAPER) ||
                player1.getPositions().contains(Position.STONE) && player2.getPositions().contains(Position.STONE) ||
                player1.getPositions().contains(Position.SCISSORS) && player2.getPositions().contains(Position.SCISSORS)) {
            return count2 += 0.5;

        } else {
            return count2 += 1;
        }
    }


    public void playAllPlayers2(List<Player> list) {

        List<Player> result1 = new ArrayList<>();
        List<Player> result2 = new ArrayList<>();

        Map<Integer, Double> res1 = new HashMap<>();
        Map<Integer, Double> res2 = new HashMap<>();
        //double count1 = 0;
        // double count2 = 0;

        // List<List<Player>> allPairs = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                player1 = list.get(i);
                player2 = list.get(j);

                result1.add(player1);
                result1.add(player2);
                ///////////////////////////////////

                if (player1.getPositions().contains(Position.PAPER) && player2.getPositions().contains(Position.STONE) ||
                        player1.getPositions().contains(Position.STONE) && player2.getPositions().contains(Position.SCISSORS) ||
                        player1.getPositions().contains(Position.SCISSORS) && player2.getPositions().contains(Position.PAPER)) {
                    countPlayer1 += 1.0;
                } else if (player1.getPositions().contains(Position.PAPER) && player2.getPositions().contains(Position.PAPER) ||
                        player1.getPositions().contains(Position.STONE) && player2.getPositions().contains(Position.STONE) ||
                        player1.getPositions().contains(Position.SCISSORS) && player2.getPositions().contains(Position.SCISSORS)) {
                    countPlayer1 += 0.5;
                    countPlayer2 += 0.5;

                } else {
                    countPlayer2 += 1;
                }


                // double xx = playLogic2(player1.getPositions(), player2.getPositions());
                //double yy = playLogic2(player2.getPositions(), player1.getPositions());
                // res1.put(player1.getId(), res1.getOrDefault(player1.getId(), 0.0) + countPlayer1);
                // res2.put(player2.getId(), res2.getOrDefault(player2.getId(), 0.0) + countPlayer2);
                res1.put(player1.getId(), countPlayer1);
                res1.put(player2.getId(), countPlayer2);
            }
        }

        // System.out.println("count1 = " + countPlayer1 + "; count2 = " + countPlayer2);
        System.out.println("******************" + result1);
        // System.out.println(result2);
        System.out.println(countPlayer1);
        System.out.println(countPlayer2);
        //System.out.println(allPairs);

        System.out.println("!!!" + res1);
        System.out.println("!!!!!!" + res2);
    }


    public double playLogic2(List<Position> l1, List<Position> l2) {


        if (player1.getPositions().contains(Position.PAPER) && player2.getPositions().contains(Position.STONE) ||
                player1.getPositions().contains(Position.STONE) && player2.getPositions().contains(Position.SCISSORS) ||
                player1.getPositions().contains(Position.SCISSORS) && player2.getPositions().contains(Position.PAPER)) {
            return countPlayer1 + 1;

        } else if (player1 == player2) {
            return countPlayer1 + 0.5;

        } else if (player2 == player1) {
            return countPlayer2 + 0.5;
        } else {
            return countPlayer2 + 1;
        }
    }


    public void playAllPlayers3(List<Player> list) {
        // List<List<Player>> result2 = new ArrayList<>();
        Map<Integer, Double> res1 = new HashMap<>();
        Map<Integer, Double> res2 = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            List<Player> result1 = new ArrayList<>();  // Создаем новый объект списка result1 после каждой итерации внешнего цикла
            Player player1 = list.get(i);

            for (int j = i + 1; j < list.size(); j++) {
                Player player2 = list.get(j);

                result1.add(player1);
                result1.add(player2);

                // double xx = playLogic2(player1.getPositions(), player2.getPositions());
                //  double yy = playLogic2(player2.getPositions(), player1.getPositions());
//
                // res1.put(player1.getId(), res1.getOrDefault(player1.getId(), 0.0) + xx);
                // res1.put(player2.getId(), res1.getOrDefault(player1.getId(), 0.0) + yy);
//                res2.put(player2.getId(), res2.getOrDefault(player2.getId(), 0.0) + yy);
            }

            result2.add(result1);  // Добавляем result1 в общий список result2 после каждой итерации внешнего цикла
        }

        System.out.println("Results 1: " + res1);
        System.out.println("Results 2: " + res2);
        System.out.println("Result 2: " + result2);
    }


}



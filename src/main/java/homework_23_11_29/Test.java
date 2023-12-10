package homework_23_11_29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

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




    public void playAllPlayers000(List<Player> list) {

        Map<Integer, Double> result1 = new HashMap<>();
        Map<Integer, Double> result2 = new HashMap<>();


        // List<List<Player>> allPairs = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                player1 = list.get(i);
                player2 = list.get(j);

                playLogic000(player1,  player2);

                if (player1.getPositions().contains(Position.PAPER) && player2.getPositions().contains(Position.STONE) ||
                        player1.getPositions().contains(Position.STONE) && player2.getPositions().contains(Position.SCISSORS) ||
                        player1.getPositions().contains(Position.SCISSORS) && player2.getPositions().contains(Position.PAPER)) {
                    countPlayer1 += 1;
                    countPlayer2 += 0;


                   // //result1.put(player1.getId(), countPlayer1);
                   // // result2.put(player2.getId(), countPlayer2);

                } else if (player1.getPositions().contains(Position.PAPER) && player2.getPositions().contains(Position.PAPER) ||
                        player1.getPositions().contains(Position.STONE) && player2.getPositions().contains(Position.STONE) ||
                        player1.getPositions().contains(Position.SCISSORS) && player2.getPositions().contains(Position.SCISSORS)) {
                    countPlayer1 += 0.5;
                    countPlayer2 += 0.5;

                   // //result1.put(player1.getId(), countPlayer1);
                    //// result2.put(player2.getId(), countPlayer2);

                } else {//if (player2.getPositions().contains(Position.PAPER) && player1.getPositions().contains(Position.STONE) ||
//                        player2.getPositions().contains(Position.STONE) && player1.getPositions().contains(Position.SCISSORS) ||
//                        player2.getPositions().contains(Position.SCISSORS) && player1.getPositions().contains(Position.PAPER))
                    countPlayer2 += 1;
                    countPlayer1 += 0;
                }
                // result1.put(player1.getId(), result1.getOrDefault(player1.getId(), 0.0) + countPlayer1);
                // result2.put(player2.getId(), result2.getOrDefault(player2.getId(), 0.0) + countPlayer2);

                result2.putIfAbsent(player2.getId(), 0.0);
                result1.put(player1.getId(), countPlayer1);
                result2.put(player2.getId(), countPlayer2);
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

    public Map<Integer, Double> playLogic000(Player player1, Player player2) {



        Map<Integer, Double> result1 = new HashMap<>();
        Map<Integer, Double> result2 = new HashMap<>();

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
return result1;
    }


}

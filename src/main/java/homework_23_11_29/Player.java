package homework_23_11_29;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;



public class Player {//extends Thread {

    GeneratorOfPositions gp = new GeneratorOfPositions();
    private static int currentId = 0;
    private int id;
    private String name;
    private final static Faker FAKER = new Faker();
    private List<Position> positions;
   // private Exchanger<Position> exchanger;
    private List<Player> allPlayers = new ArrayList<>();

    public Player() {
    }

    public Player(int id, String name, List<Position> positions){//, Exchanger<Position> exchanger){
      // ++currentId;
        this.id = id;
        this.name = name;
        this.positions = positions;
       // this.exchanger = exchanger;
       // this.start();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Player> getAllPlayers() {
        return allPlayers;
    }

    public void setAllPlayers(List<Player> allPlayers) {
        this.allPlayers = allPlayers;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public List<Player> setPlayersInList() {
        while (allPlayers.size() < 50) {
            Player player = new Player(++currentId,  FAKER.name().name(), gp.getRandomPosition());
            allPlayers.add(player);//new Player(++currentId, FAKER.name().name(), gp.getRandomPosition())); //exchanger));
        }
        return allPlayers;
     }


//    private void play(Position mainPlayer, Position anotherPlayer) {
//        if (player1 == Position.PAPER && player2 == Position.STONE ||
//                mainPlayer == Position.STONE && anotherPlayer == Position.SCISSORS ||
//                mainPlayer == Position.SCISSORS && anotherPlayer == Position.PAPER) {
//            System.out.println("***[ " + name + " ]: WINNER!***");
//        }
//    }


    //    private void play(Position mainPlayer, Position anotherPlayer) {
//        if (player1 == Position.PAPER && player2 == Position.STONE ||
//                player1 == Position.STONE && player2 == Position.SCISSORS ||
//                player1 == Position.SCISSORS && player2 == Position.PAPER) {
//            System.out.println("***[ " + name + " ]: WINNER!***");
//        }
//    }





//    @Override
//    public void run() {
//        Position reply;
//        for (Position p : positions) {
//            try {
//                reply = exchanger.exchange(p);
//                play(p, reply);
//                sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }


    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", positions=" + positions +
                '}';
    }
}
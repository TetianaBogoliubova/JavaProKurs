package homework_23_11_29;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * - Создать класс для генерации игроков (50 шт)
 * - Создать класс для генерации листа Position(10 раз)
 * - Все игроки должны сыграть "каждый с каждым"
 * - Если победа то +1 если поражение то -1 ничья 0,5
 * - Составить таблицу игроков и вывести на экран тройку лидеров
 * - Если у тройки лидеров одинаковые очки - они переигрывают ТО кол-во раз пока кол-во очков не станет разным.
 * <p>
 * - CDL для генерации игроков.
 */
public class Main {
    private final static Faker FAKER = new Faker();

    public static void main(String[] args) { Test test = new Test();
        GeneratorOfPositions gp = new GeneratorOfPositions();
        Player player = new Player();
        GeneralPlay generalPlay = new GeneralPlay();

        Exchanger<Position> exchanger = new Exchanger<>();

        List<Position> mainPlayerList = new ArrayList<>();
        mainPlayerList.add(Position.SCISSORS);
        mainPlayerList.add(Position.STONE);
        mainPlayerList.add(Position.SCISSORS);
        mainPlayerList.add(Position.PAPER);
        mainPlayerList.add(Position.SCISSORS);

        List<Position> anotherPlayerList = new ArrayList<>();
        anotherPlayerList.add(Position.STONE);
        anotherPlayerList.add(Position.PAPER);
        anotherPlayerList.add(Position.SCISSORS);
        anotherPlayerList.add(Position.STONE);
        anotherPlayerList.add(Position.PAPER);

        System.out.println(gp.getRandomPosition());

        // System.out.println( new Player(id, FAKER.name().name(), gp.getRandomPosition()));//, exchanger));
        // new Player(FAKER.name().name(), anotherPlayerList);//, exchanger);
        System.out.println("Общий список всех игроков - 50 человек: " + player.setPlayersInList());
       generalPlay.playAllPlayers(player.getAllPlayers());

//        for (List<Player> i : generalPlay.getAllPairs()) {
//            System.out.println("отдельные пары " + i);
//        }

        //System.out.println( generalPlay.playLogic(Position.SCISSORS, Position.STONE));
//generalPlay.sravnenie(generalPlay.getAllPairs());


        test.playAllPlayers000(player.getAllPlayers());
    }
}





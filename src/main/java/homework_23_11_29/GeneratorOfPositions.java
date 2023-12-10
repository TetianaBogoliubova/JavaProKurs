package homework_23_11_29;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GeneratorOfPositions {

   private Random random = new Random();
   private List<Position> allPosition = Arrays.asList(Position.PAPER, Position.STONE, Position.SCISSORS);
   private int ranPosition = random.nextInt(Position.values().length);
    public List <Position> getRandomPosition() {
        List<Position> positionsOfPlayer = new ArrayList<>();

        while (positionsOfPlayer.size() < 10) {
            positionsOfPlayer.add(Position.values()[random.nextInt(Position.values().length)]);

        }
        return positionsOfPlayer;

    }


}

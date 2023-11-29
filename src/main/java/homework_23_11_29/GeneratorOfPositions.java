package homework_23_11_29;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GeneratorOfPositions {
    public Position getRandomPosition() {
        Random random = new Random();
         List<Position> allPosition = Arrays.asList(Position.PAPER, Position.STONE, Position.SCISSORS);
        int ranIndex = random.nextInt(allPosition.size());
        return allPosition.get(ranIndex);
    }


}

package homework_23_08_28;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {

            array[i] = random.nextInt(-20, 20);
            System.out.print(array[i] + ", ");
        }
        System.out.println();
        ArrayTasks arrayTasks = new ArrayTasks();
        arrayTasks.getTask1(array);
        arrayTasks.getTask2(array);
        arrayTasks.getTask3(array);
    }
}

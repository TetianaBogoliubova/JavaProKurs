package homework_23_12_06;

import java.util.Arrays;
import java.util.List;

public class MathUtils {
    public static int calculateSum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }
        return sum;
    }
}

//          *** исправленный ***
class MathUtilsCorrect {
    public static int calculateSum(int[] numbers) {
        return Arrays.stream(numbers).boxed().mapToInt(integer -> integer.intValue()).sum();
    }
}
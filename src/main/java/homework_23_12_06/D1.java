package homework_23_12_06;

import java.util.Arrays;
import java.util.List;

public class D1 {
    public double calculateAverageValueForGivenList(List<Double> listOfNumbers) {
        double sumOfAllValues = 0;
        for (double currentValue : listOfNumbers) {
            sumOfAllValues += currentValue;
        }
        return sumOfAllValues / listOfNumbers.size();
    }

}

//          *** исправленный ***
class D1Correct {
    public double getAverageValue(List<Double> list) {
        double sum = 0;
        for (double i : list) {
            sum += i;
        }
        return sum / list.size();

//        *** или ***
//        return list.stream()
//                .mapToDouble(Double::doubleValue)
//                .average()
//                .orElse(0.0);
    }
}





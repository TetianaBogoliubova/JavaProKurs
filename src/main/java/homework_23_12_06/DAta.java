package homework_23_12_06;

import java.util.List;

public class DAta {
    public double calculateAverage(List<Double> numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }

        double average = sum / numbers.size();

        double variance = 0;
        for (double num : numbers) {
            variance += Math.pow(num - average, 2);
        }
        double standardDeviation = Math.sqrt(variance / numbers.size());

        return standardDeviation;
    }
}
//          *** исправления ***
class StandardDeviation {
    private double sum;
    private double average;
    private double variance;
    private double standardDeviation;

    public double countStandardDeviation(List<Double> numbers) {

        for (double num : numbers) {
            sum += num;
            average = sum / numbers.size();
            variance += Math.pow(num - average, 2);
        }
        return standardDeviation = Math.sqrt(variance / numbers.size());
    }
}

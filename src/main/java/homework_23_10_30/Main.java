package homework_23_10_30;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int[] array = {1, 2, 3, 4};

        System.out.println(calculator.add(5, 10));
        System.out.println(calculator.subtract(10, 5));
        System.out.println(calculator.multiply(2, 5));
        System.out.println(calculator.divide(10, 2));
        System.out.println(calculator.power(3, 2));
        System.out.println(calculator.factorial(3));
        System.out.println(calculator.isEven(6));
        System.out.println(calculator.findMax(array));
        System.out.println(calculator.isPrime(17));
        System.out.println(calculator.toBaseString(2, 2));
        System.out.println(calculator.sqrt(9));
        System.out.println(calculator.reverseString("1234"));
        System.out.println(calculator.isPalindrome("1221"));
        System.out.println(calculator.gcd(50, 25));
        System.out.println(calculator.productOfArray(array));
        System.out.println(calculator.lengthOfLongestWord("1 12 123 1234"));
        System.out.println(calculator.celsiusToFahrenheit(25));
        System.out.println(calculator.containsSubstring("1 2 3 4 5 6", "2"));
        System.out.println(calculator.sumOfDigits(256));
        System.out.println(calculator.sumOfDigitsForLongNumbers(12345));
        System.out.println(calculator.isLeapYear(1400));
    }
}

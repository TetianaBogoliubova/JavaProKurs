package homework_23_12_06;

public class SUT {
    public static String toUpperCase1(String input) {
        return input.toUpperCase();
    }

    public static String toLowerCase2(String input) {
        return input.toLowerCase();
    }

    public static char[] toCharArray2(String input) {
        char[] result = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            result[i] = input.charAt(i);
        }
        return result;
    }
}

//          *** исправленный ***
class TransformString {
    public static String getUpperCase(String input) {
        return input.toUpperCase();
    }

    public static String getLowerCase(String input) {
        return input.toLowerCase();
    }

    public static char[] getCharArray(String input) {
        return input.toCharArray();
    }
}

package homework_23_12_06;

public class SU {
    public static String formatName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public static String formatAddress(String street, String city, String zipCode) {
        return street + ", " + city + ", " + zipCode;
    }

    // Дублирование кода форматирования строки
    public static String formatString(String... parts) {
        StringBuilder builder = new StringBuilder();
        for (String part : parts) {
            builder.append(part).append(", ");
        }
        return builder.toString().trim();
    }
}

//          *** исправленный ***
class Customer {

    //переменные, если класс создан для хранения и передачи информации о чем-либо (напр.: о Customer)
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String zipCode;
    private String parts;

    public static String formatName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public static String formatAddress(String street, String city, String zipCode) {
        return street + ", " + city + ", " + zipCode;
    }

    public static String formatString(String... parts) {
        StringBuilder builder = new StringBuilder();
        for (String part : parts) {
            builder.append(part).append(", ");
        }
        return builder.toString().trim();
    }
}
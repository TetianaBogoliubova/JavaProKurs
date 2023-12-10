package homework_23_12_06;

import java.util.stream.Collectors;

public class StringUtils {

    public static String toUpperCase(String input) {
        // Сложная реализация для простой операции
        // ...
        return input.chars()
                .mapToObj(Character::toString)
                .map(s -> {
                    // Добавляем дополнительную логику преобразования, например, пропуск знаков препинания
                    if (s.equals(" ")) {
                        return " ";
                    } else {
                        return s.toUpperCase();
                    }
                })
                .collect(Collectors.joining());
    }
}

//          *** исправленный ***
class StringUtilsCorrect {

    public static String getUpperCase(String input) {
        return input.replaceAll(" ", " ").toUpperCase();
    }
}
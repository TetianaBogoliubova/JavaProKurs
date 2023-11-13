package homework_23_08_30.allEnums;
//1.2. Size - Перечисление для представления размеров одежды:
public enum Size {

    WOMEN_SIZE {
        @Override
        String getSize() {
            return "S = 36, M = 38, L = 40";
        }
    },
    MEN_SIZE {
        @Override
        String getSize() {
            return "S = 42, M = 44, L = 46";
        }
    },
    TEEN_SIZE {
        @Override
        String getSize() {
            return "12-14 age = 38 - 40; 14-16 age = 42 - 44";
        }
    },
    CHILDREN_SIZE {
        @Override
        String getSize() {
            return "5-8 age = 28 - 32; 9-11 age = 34 - 38";
        }
    };
abstract String getSize();
}

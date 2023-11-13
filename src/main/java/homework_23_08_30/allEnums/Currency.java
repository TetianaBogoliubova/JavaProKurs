package homework_23_08_30.allEnums;
//1.3. Currency - Перечисление для представления валют для цен товаров:
public enum Currency {
    UAH ("₴"),
    USD ("$"),
    EUR ("€");

    private final String symbol;
    Currency(String symbol) {

        this.symbol = symbol;
    }

    public String getSymbol() {

        return symbol;
    }
}

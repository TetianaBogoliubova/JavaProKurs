package homework_23_09_27_roulette;

public class Player {

    private int inputNumber; //номер, который вводит игрок
    private String inputSection;// секция (odd/even), которую вводит игрок
    private int inputSerios;// порядковый номер серии, который вводит игрок
    private int numberForComplit;//порядковый номер комплита, который вводит игрок
    private int winNumber;//выигрышный номер на рулетке
    private int gitonsCount; //количество жетонов, которые поставил игрок

    private int quantityGitons = 100;//начальное количество жетонов для игры

    public Player() {
    }

    public Player(int inputNumber, String inputSection, int inputSerios, int numberForComplit, int winNumber, int gitonsCount, int quantityGitons) {
        this.inputNumber = inputNumber;
        this.inputSection = inputSection;
        this.inputSerios = inputSerios;
        this.numberForComplit = numberForComplit;
        this.winNumber = winNumber;
        this.gitonsCount = gitonsCount;
        this.quantityGitons = quantityGitons;
    }

    public int getInputNumber() {
        return inputNumber;
    }

    public int setInputNumber(int inputNumber) {
        this.inputNumber = inputNumber;
        return inputNumber;
    }

    public int getGitonsCount() {
        return gitonsCount;
    }

    public void setGitonsCount(int gitonsCount) {
        this.gitonsCount = gitonsCount;
    }

    public String getInputSection() {
        return inputSection;
    }

    public void setInputSection(String inputSection) {
        this.inputSection = inputSection;
    }

    public int getQuantityGitons() {
        return quantityGitons;
    }

    public int getWinNumber() {
        return winNumber;
    }

    public void setWinNumber(int winNumber) {
        this.winNumber = winNumber;
    }

    public int getNumberForComplit() {
        return numberForComplit;
    }

    public void setNumberForComplit(int numberForComplit) {
        this.numberForComplit = numberForComplit;
    }

    public int getInputSerios() {
        return inputSerios;
    }

    public int setInputSerios(int inputSerios) {
        this.inputSerios = inputSerios;
        return inputSerios;
    }
}

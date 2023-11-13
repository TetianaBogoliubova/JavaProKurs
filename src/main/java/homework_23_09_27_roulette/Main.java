package homework_23_09_27_roulette;

public class Main {
    public static void main(String[] args) {
        GameProcess gp = new GameProcess();
        Player player = new Player();
        System.out.println("Для начала игры Вам дается " + player.getQuantityGitons() + " жетонов. Пожалуйста, делайте Ваши ставки");

        gp.putBetOnColor();
        gp.putBetOnSection();
        gp.putBetOnNumber();
        gp.playWithSeries();
        gp.playWithComplit1();

    }
}

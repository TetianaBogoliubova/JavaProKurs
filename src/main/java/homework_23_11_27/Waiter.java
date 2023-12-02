package homework_23_11_27;

public class Waiter extends Thread {
    private final String name;
    private final Restaurant restaurant;

    public Waiter(String name, Restaurant restaurant) {
        this.name = name;
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            restaurant.takeDish(name);
        }
    }
}
package homework_23_11_27;

public class Cook extends Thread {
    private final Restaurant restaurant;

    public Cook(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        restaurant.cookDish1();
    }
}

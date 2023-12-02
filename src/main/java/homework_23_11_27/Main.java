package homework_23_11_27;

public class Main {

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Cook cook = new Cook(restaurant);
        DaemonThread daemonTread = new DaemonThread(restaurant);

        Waiter w1 = new Waiter("Waiter 1", restaurant);
        Waiter w2 = new Waiter("Waiter 2", restaurant);

        cook.start();
        w1.start();
        w2.start();
        daemonTread.start();
    }
}

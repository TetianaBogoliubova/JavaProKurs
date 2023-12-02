package homework_23_11_27;

public class DaemonThread extends Thread {

    private final Restaurant restaurant;

    public DaemonThread(Restaurant restaurant) {
        setDaemon(true);
        this.restaurant = restaurant;
    }

    @Override
    public void run() {

        restaurant.createFileForReview();

        String filePath = "count_of_review.txt";
        String phrase = " - New review";


        while (true) {
            System.out.println("Работает подсчет отзывов за текущий день: DaemonThread");
            try {
                Thread.sleep(200);
                restaurant.countAllReview(filePath, phrase);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}




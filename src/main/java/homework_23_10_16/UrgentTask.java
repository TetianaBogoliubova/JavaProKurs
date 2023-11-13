package homework_23_10_16;

import java.util.Date;

public class UrgentTask extends Task {

    private static final int URGENT_PRIORITY = 1;

    public UrgentTask(String title, double reward) {
        super(title, new Date(), URGENT_PRIORITY, reward);
    }

    //Подсчет стоимости выполнения срочной задачи = увеличение стоимости в 2 раза
    @Override
    public double calculatePayment() {
        if (getPriority() == URGENT_PRIORITY) {
            return getReward() * 2;
        } else {
            return getReward();
        }
    }
}

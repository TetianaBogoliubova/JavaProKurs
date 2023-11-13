package homework_23_10_16;

import java.util.Date;

public class PriorityTask extends Task {

    public PriorityTask(String title, int priority, double reward) {
        super(title, new Date(), priority, reward);
    }

    private int requiredPriority = 4; // (требуемый приоритет для выполнения).

    //Подсчет стоимости выполнения задачи, если приоритет задачи соответствует требуемому.
    @Override
    public double calculatePayment() {
        if (requiredPriority >= getPriority() && getPriority() > 1) {
            return getReward() + getReward() * 0.2;
        } else
            return getReward();
    }
}


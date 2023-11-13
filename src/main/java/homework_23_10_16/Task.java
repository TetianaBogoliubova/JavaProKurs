package homework_23_10_16;

import java.util.Date;

public class Task {

    String title; // (название задачи)
    private Date deadline; // (срок выполнения)
    private int priority; // (приоритет)
    private double reward; // (стоимость выполнения)

    public Task(String title, Date deadline, int priority, double reward) {
        this.title = title;
        this.deadline = deadline;
        this.priority = priority;
        this.reward = reward;
    }

    public String getTitle() {
        return title;
    }

    public int getPriority() {
        return priority;
    }

    public double getReward() {
        return reward;
    }

    public double calculatePayment() {//возвращает стоимость выполнения задачи в зависимости от приоритета.
        return 0;
    }
}

package homework_23_10_16;

import java.util.ArrayList;
import java.util.List;

public class TaskManager<T extends Task> {

    private String title;
    private double reward;
    private List<T> tasks = new ArrayList<>();

    public TaskManager(String title, double reward) {
        this.title = title;
        this.reward = reward;
    }

    public void addTask(T newTask) {//добавляет задачу в систему
        tasks.add(newTask);
        System.out.println("Добавлена новая задача: " + newTask.getTitle());
    }

    public void calculateTotalPayment() {
        double sum = 0;
        for (T i : tasks) {
            sum = sum + i.getReward();
        }
        System.out.println("sum = " + sum);
    }
}

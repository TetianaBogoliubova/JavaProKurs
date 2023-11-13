package homework_23_10_16;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    private static final Faker FAKER = new Faker();
    private static final SimpleDateFormat currentData = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) {

        UrgentTask urgentTask = new UrgentTask(FAKER.hacker().verb(), 2000);
        PriorityTask priorityTask = new PriorityTask(FAKER.hacker().verb(), 2, 1500);

        System.out.println("Расчет стоимость срочной задачи с приоритетом 1 - " + urgentTask.calculatePayment() + " Дата выполнения задачи: " + currentData.format(new Date()));
        System.out.println("Требуемый приоритет для выполнения задачи от 2 до 4. Надбавка при расчете - 20% - " + priorityTask.calculatePayment());

        TaskManager<UrgentTask> allUrgentTasks = new TaskManager<>(FAKER.hacker().verb(), 0);
        TaskManager<PriorityTask> allPriorityTasks = new TaskManager<>(FAKER.hacker().verb(), 0);

        allUrgentTasks.addTask(new UrgentTask(FAKER.hacker().verb(), 1000));
        allUrgentTasks.addTask(new UrgentTask(FAKER.hacker().verb(), 1500));
        allUrgentTasks.addTask(new UrgentTask(FAKER.hacker().verb(), 2000));
        allUrgentTasks.addTask(new UrgentTask(FAKER.hacker().verb(), 1800));
        allUrgentTasks.addTask(new UrgentTask(FAKER.hacker().verb(), 1900));

        allPriorityTasks.addTask(new PriorityTask(FAKER.hacker().verb(), 3, 1700));
        allPriorityTasks.addTask(new PriorityTask(FAKER.hacker().verb(), 5, 1100));
        allPriorityTasks.addTask(new PriorityTask(FAKER.hacker().verb(), 2, 1300));
        allPriorityTasks.addTask(new PriorityTask(FAKER.hacker().verb(), 4, 1600));
        allPriorityTasks.addTask(new PriorityTask(FAKER.hacker().verb(), 2, 2100));

        System.out.println("Сумма задач с наивысшим приоритетом: ");
        allUrgentTasks.calculateTotalPayment();
        System.out.println("Сумма задач с различными степенями приоритета: ");
        allPriorityTasks.calculateTotalPayment();
    }
}

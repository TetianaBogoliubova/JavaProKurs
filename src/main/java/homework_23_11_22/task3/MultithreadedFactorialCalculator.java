package homework_23_11_22.task3;

// Многопоточное Вычисление Пи по Формуле Лейбница
// Цель задания: Написать многопоточную программу для вычисления числа Пи с помощью ряда Лейбница.
// Описание задания:
// Создайте класс MultithreadedFactorialCalculator.
// Разделите задачу вычисления факториала на подзадачи, каждая из которых вычисляет произведение
// определенного диапазона чисел. Используйте newFixedThreadPool для распределения этих подзадач между потоками.
public class MultithreadedFactorialCalculator {

    public static double calculatePiLeibniz(int iterations) {
        double pi = 0;

        for (int i = 0; i < iterations; i++) {
            double term = 1.0 / (2 * i + 1);
            if (i % 2 == 0) {
                pi += term;
            } else {
                pi -= term;
            }
        }
        return 4 * pi;
    }
}








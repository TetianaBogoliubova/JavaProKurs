package homework_23_10_23;

import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {
        Task task = new Task();
        String line1 = "Alexander Sophia James Ava Ethan Avery Oliver Charlotte Benjamin Amelia Lucas Mia" +
                "Mason Harper Logan Anthony Ava Isaiah Harper Blake Ella Jordan Scarlett  Carter Leah  " +
                "Owen Chloe Jonathan Aria Wyatt Nora Connor Riley Jeremiah Lily Cameron Ellie Josiah Zoey " +
                "Adrian Addison Colton Aubrey Eli Hazel Robert Sophie Hunter Bella Jaxon Mila Kevin Abigail" +
                "Angel Stella Zachary Avery Ella Jacob Scarlett Michael Luna William Layla Aiden Chloe " +
                "Daniel Isla Matthew Zoe Samuel Leah Joseph Aria David Nora Joshua Riley Andrew Lily  " +
                "Nicholas Ellie Jackson Zoey Ryan Addison Christopher Aubrey Gabriel Hazel Brandon Sophie" +
                "Aaron Bella Isaac Mila Henry Abigail Sebastian Stella Dylan Avery Nathan Zoe Liam Amelia " +
                "Caleb Mia John Charlotte Luke Luna";

        System.out.println(line1);

        //System.out.println(task.readerWriterLine("name"));
        System.out.println("1. Общее число имен в файле: " + task.countTotalNames(line1));
        System.out.println("2. Уникальные имена в файле: " + task.uniqueNames(line1));
        System.out.println("3. Число имен, содержащих заданную подстроку: " + task.countNamesContainingSubstring(line1, "Ava"));
        System.out.println("4. Iмена, длина которых находится в заданном диапазоне: " + task.namesWithLengthInRange(line1, 3, 4));
        System.out.println("5. Первые имена в алфавитном порядке, согласно заданному количеству: " + task.firstNNamesAlphabetically(line1, 5));
        System.out.println("6. Пять самых часто встречающихся имен в файле: " + task.topFiveCommonNames(line1));
        System.out.println("7. Iмена, которые начинаются на заданную букву и встречаются больше двух раз: " + task.namesStartingWithAndOccurMoreThanTwice(line1, 'A'));
        System.out.println("8. Пара имен с самой длинной и самой короткой длиной: " + task.longestAndShortestNames(line1));
        task.getBankCard();
    }
}

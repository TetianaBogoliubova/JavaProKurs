package homework_Summ_23_11_10;
// Написать метод T[] filter(T[] t, Filter filter), который принимает на
// вход массив (любого типа) и производит фильтрацию данных согласно реализации интерфейса Filter
// (например, через лямбда-выражение). Интерфейс Filter имеет метод apply (T t), с помощью которого можно будет
// указывать способ фильтрации.

//interface Filter {
//    boolean apply(T t);
//}
//    Проверьте как работает метод на строках или других объектах.
//
//        Пример применения:
//        String[] filtered = filter(new String[]{"One", "Two", "Three"}, o1 -> o1.length() == 3);
//        Integer[] filteredInts = filter(new Integer[]{0, 1, 2, 3, 4, 5}, i -> (i % 2 == 0));
//        либо:
//
//        Integer[] filteredInts = filter(new Integer[]{0, 1, 2, 3, 4, 5}, new Filter() {
//@Override
//public boolean apply(Integer i) {
//        return (i % 2 == 0);
//        }
//        });


import java.util.Arrays;

public class Task {

    public <T> T[] filterData(T[] t, Filter<T> filter) {
        return Arrays.stream(t)
                .filter(el -> filter.apply(el))
                .toArray(n -> Arrays.copyOf(t, n));
    }

    public <T> T[] filterStringData(T[] arr, Filter<T> filter) {
        return Arrays.stream(arr)
                .filter(t1 -> filter.apply(t1))
                .toArray(s -> Arrays.copyOf(arr, s));
    }

}

package homework_23_09_13.comparators;

import homework_23_09_13.MyClass;

import java.util.Comparator;

public class CategoryComparator implements Comparator<MyClass> {

    @Override
    public int compare(MyClass o1, MyClass o2) {
        return o1.getCategory().compareTo(o2.getCategory());
    }
}

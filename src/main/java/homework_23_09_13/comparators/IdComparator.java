package homework_23_09_13.comparators;

import homework_23_09_13.MyClass;

import java.util.Comparator;

public class IdComparator implements Comparator<MyClass> {
    @Override
    public int compare(MyClass o1, MyClass o2) {
        return Integer.compare(o2.getId(), o2.getId());
    }
}

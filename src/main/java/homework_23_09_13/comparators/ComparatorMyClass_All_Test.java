package homework_23_09_13.comparators;

import homework_23_09_13.MyClass;

import java.util.Comparator;

public class ComparatorMyClass_All_Test implements Comparator<MyClass> {
    @Override
    public int compare(MyClass o1, MyClass o2) {
        int result = Integer.compare(o1.getId(), o2.getId());
        if (result == 0) {
            result = Integer.compare(o1.getAccount(), (o2.getAccount()));
            if (result == 0) {
                result = o1.getName().compareTo(o2.getName());
                if (result == 0) {
                    result = o1.getCategory().compareTo(o2.getCategory());
                }
            }
        }
        return result;
    }
}


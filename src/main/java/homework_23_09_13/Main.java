package homework_23_09_13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        WorkWithList workWithList = new WorkWithList();
        MyClass myClass1 = new MyClass(01, "Name1", 1111, "cat_1");
        MyClass myClass2 = new MyClass(02, "Name2", 2222, "cat_2");
        MyClass myClass3 = new MyClass(03, "Name3", 3333, "cat_3");
        MyClass myClass4 = new MyClass(04, "Name4", 4444, "cat_4");
        MyClass myClass5 = new MyClass(05, "Name5", 5555, "cat_5");
        MyClass myClass6 = new MyClass(04, "Name6", 6666, "cat_6");
        MyClass myClass7 = new MyClass(05, "Name7", 7777, "cat_7");


        List<MyClass> arrayMyClass1 = new ArrayList<>();
        arrayMyClass1.add(myClass1);
        arrayMyClass1.add(myClass2);
        arrayMyClass1.add(myClass3);
        arrayMyClass1.add(myClass4);
        arrayMyClass1.add(myClass5);

        List<MyClass> arrayMyClass2 = new ArrayList<>();
        arrayMyClass2.add(myClass1);
        arrayMyClass2.add(myClass2);
        arrayMyClass2.add(myClass3);
        arrayMyClass2.add(myClass4);
        arrayMyClass2.add(myClass5);
        arrayMyClass2.add(myClass6);
        arrayMyClass2.add(myClass7);


        List<MyClass> linkedMyClass1 = new LinkedList<>();
        linkedMyClass1.add(myClass1);
        linkedMyClass1.add(myClass2);
        linkedMyClass1.add(myClass3);
        linkedMyClass1.add(myClass4);
        linkedMyClass1.add(myClass5);

        List<MyClass> linkedMyClass2 = new LinkedList<>();
        linkedMyClass2.add(myClass5);
        linkedMyClass2.add(myClass3);
        linkedMyClass2.add(myClass1);
        linkedMyClass2.add(myClass2);
        linkedMyClass2.add(myClass5);

        List<MyClass> linkedMyClass3 = new LinkedList<>();
        linkedMyClass3.add(myClass1);
        linkedMyClass3.add(myClass2);
        linkedMyClass3.add(myClass4);
        linkedMyClass3.add(myClass4);
        linkedMyClass3.add(myClass2);


        List<Integer> list_array1 = new ArrayList<>();
        list_array1.add(23);
        list_array1.add(5);
        list_array1.add(6);
        list_array1.add(87);
        list_array1.add(11);

        List<Integer> list_array2 = new ArrayList<>();
        list_array2.add(23);
        list_array2.add(5);
        list_array2.add(6);
        list_array2.add(87);
        list_array2.add(11);

        List<Integer> list_array3 = new LinkedList<>();
        list_array3.add(23);
        list_array3.add(4);
        list_array3.add(5);
        list_array3.add(87);
        list_array3.add(11);

        List<String> list_array4 = new ArrayList<>();
        list_array4.add("One");
        list_array4.add("Two");
        list_array4.add("Three");
        list_array4.add("Four");
        list_array4.add("Five");

        List<String> list_array5 = new ArrayList<>();
        list_array5.add("One11");
        list_array5.add("Two");
        list_array5.add("Thre e33");
        list_array5.add("Four");
        list_array5.add("Five55");

        List<String> list_array6 = new ArrayList<>();
        list_array6.add("One");
        list_array6.add("Four");
        list_array6.add("Three");
        list_array6.add("Four");
        list_array6.add("Five");


        List<Integer> list_linked1 = new LinkedList<>();
        list_linked1.add(34);
        list_linked1.add(15);
        list_linked1.add(63);
        list_linked1.add(2);
        list_linked1.add(11);

        List<Integer> list_linked2 = new LinkedList<>();
        list_linked2.add(5);
        list_linked2.add(43);
        list_linked2.add(11);
        list_linked2.add(11);
        list_linked2.add(6);

        List<Integer> list_linked3 = new LinkedList<>();
        list_linked3.add(5);
        list_linked3.add(43);
        list_linked3.add(11);
        list_linked3.add(11);
        list_linked3.add(6);

        List<String> list_linked4 = new LinkedList<>();
        list_linked4.add("Six");
        list_linked4.add("Seven");
        list_linked4.add("Eight");
        list_linked4.add("Nine");
        list_linked4.add("Ten");


        System.out.println(workWithList.getSumAllNumbers(list_array1));
        System.out.println(workWithList.getAverageNumbers(list_linked1));
        System.out.println(workWithList.getOutputStringList(list_array4));
        System.out.println(workWithList.getLargestList(list_linked4));
        System.out.println(workWithList.getListFromMyClass(arrayMyClass1));
        System.out.println();

        System.out.println(workWithList.getLessNumber(list_array1));
        System.out.println(workWithList.getMaxNumber(list_linked1));
        workWithList.getStringWithFirstLetter(list_array4, 'F');
        workWithList.getFirstEntry(list_linked4, "Nine");
        System.out.println(workWithList.getListWithoutSpecialElements(linkedMyClass1, 333));
        System.out.println();

        System.out.println(workWithList.getListWithoutEverNumbers(list_array1));
        System.out.println(workWithList.getListWithNumberMultiplesOfThree(list_linked1));
        workWithList.connectStrings(list_array4);
        System.out.println(workWithList.deleteElementWithString(list_linked4, "Eight"));
        workWithList.getListWithSpecialCondition(arrayMyClass1, "cat_1", "cat_3");
        System.out.println();

        System.out.println(workWithList.getSumSquareNumbers(list_array1));
        System.out.println(workWithList.getProductOfAllNumbers(list_linked2));
        System.out.println(workWithList.getShortString(list_array4));
        workWithList.changeVowelLetters(list_linked4);
        workWithList.sortListDescendingOrder(linkedMyClass2);
        System.out.println();

        System.out.println(workWithList.getSecondLargestNumber(list_linked2));
        workWithList.getListWithReverseOrder(list_array3);
        workWithList.getStringWithoutNumbers(list_array5);
        System.out.println(workWithList.getLongerStringWithoutSpace(list_array5));
        workWithList.getMyListWithUniqueElements(arrayMyClass1);
        System.out.println();

        System.out.println(workWithList.getListWithLargestOrder(list_array2));
        System.out.println(workWithList.deleteDuplicates(list_linked3));
        System.out.println(workWithList.createListWithUniqueStrings(list_array6));
        System.out.println(workWithList.connectAllString(list_linked4));
        workWithList.sortMyListWithDifferentCriterias(linkedMyClass2);

        System.out.println();
        System.out.println(workWithList.test1(list_array6, 4));
        System.out.println(workWithList.test2(list_array1));
    }
}


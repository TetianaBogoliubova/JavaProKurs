package homework_23_11_08;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MethodsAndTestsForDataBase md = new MethodsAndTestsForDataBase();

        List<String> names = md.readerWriterDB1("src/main/dataBase.txt");


        System.out.println(names);
       // md.xx("src/main/dataBase.txt");
        System.out.println();
       // md.getMapOfNames(names);
         //md.getMapOfNames2(names);
        md.createNewCollectionsWithData(names);
     //   Map<String, Integer> resultOfMethod2 = md.getMapOfNames();
        md.getMapOfNames();
        md.getFirstLetterOfNames();
        System.out.println(md.getListOfPhoneNumbersLikeDigit());
        md.groupNamesByLong();
        System.out.println(md.getUniqueLastNames());
        System.out.println(md.getListWithReversOrder());
        System.out.println(md.getMapWithNamesAndPhoneNumbers(names));
        System.out.println(md.getAverageLongOfName());
        System.out.println(md.getMapWithPhoneNumbersAndNames());
        md.searchNamesAndPhoneNumbersByLongOfNames();
    }
}

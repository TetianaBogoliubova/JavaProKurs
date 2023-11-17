package homework_23_11_08;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

// Тесты № 3, 4, 5, 8 по отдельности срабатывают. А при общей проверке - нет. Не понимаю почему.

class MethodsAndTestsForDataBaseTest {
    private static MethodsAndTestsForDataBase mfd;
    private static final List<String> phoneNumbers = new ArrayList<>();
    private static final List<String> firstNames = new ArrayList<>();
    private static final List<String> lastNames = new ArrayList<>();
    private static final List<String> generalList = new ArrayList<>();
    private static final Map<String, String> namesAndPhoneNumbers = new HashMap<>();

    List<String> createGeneralList() {

        generalList.add("1111 - Mr. Tom LastName1");
        generalList.add("2222 - Ted LastName2");
        generalList.add("3333 - Mrs. Sara LastName3");
        generalList.add("4444 - Kamilla LastName4 CD");
        return generalList;
    }

    @BeforeEach
    void setUp() {

        mfd = new MethodsAndTestsForDataBase();
        phoneNumbers.clear();
        firstNames.clear();
        lastNames.clear();
        namesAndPhoneNumbers.clear();
        generalList.clear();
        mfd.createNewCollectionsWithData(createGeneralList());

        phoneNumbers.add("1111");
        phoneNumbers.add("2222");
        phoneNumbers.add("3333");
        phoneNumbers.add("4444");

        firstNames.add("Tom");
        firstNames.add("Ted");
        firstNames.add("Sara");
        firstNames.add("Kamilla");

        lastNames.add("LastName1");
        lastNames.add("LastName2");
        lastNames.add("LastName3");
        lastNames.add("LastName4");

        namesAndPhoneNumbers.put("Tom", "1111");
        namesAndPhoneNumbers.put("Ted", "2222");
        namesAndPhoneNumbers.put("Sara", "3333");
        namesAndPhoneNumbers.put("Kamilla", "4444");
    }

    @AfterEach
    void clearAll() {
        phoneNumbers.clear();
        firstNames.clear();
        lastNames.clear();
        namesAndPhoneNumbers.clear();
        generalList.clear();
    }

    // 1.
    @Test
    void readerWriterDBCheckBufferedWriterTest() throws IOException {

        Path tempFile = Files.createTempFile("testfile", "txt");
        String testLine = tempFile.toString();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testLine))) {
            writer.write("String 1");
            writer.newLine();
            writer.write("String 2");
            writer.newLine();
            writer.write("String 3");
        }
        List<String> result = mfd.readerWriterDB(testLine);
        assertEquals(3, result.size());
        assertEquals("String 1", result.get(0));
        assertEquals("String 2", result.get(1));
        assertEquals("String 3", result.get(2));
    }

    @Test
    void readerWriterDBCheckBufferedReaderTest() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("buffered.txt"))) {
            writer.write("String 1");
            writer.newLine();
            writer.write("String 2");
            writer.newLine();
            writer.write("String 3");
        }
        String bufferedTempTestFile = "buffered.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(bufferedTempTestFile))) {
            assertEquals("String 1", bufferedReader.readLine());
            assertEquals("String 2", bufferedReader.readLine());
            assertEquals("String 3", bufferedReader.readLine());
            assertNull(bufferedReader.readLine());
        }
    }

    @Test
    void readerWriterDBExceptionTest() {
        assertThrows(RuntimeException.class, () -> mfd.readerWriterDB(null));
    }

    // 2.
    @Test
    void createNewCollectionsWithDataForListOfPhoneNumbersTest() {
        assertEquals(4, phoneNumbers.size());
    }

    @Test
    void createNewCollectionsWithDataNameWithMrAndMrsTest() {
        assertTrue(firstNames.contains("Tom"));
        assertTrue(lastNames.contains("LastName1"));
    }

    @Test
    void createNewCollectionsWithDataFourElementsTest() {
        assertTrue(firstNames.contains("Ted"));
        assertTrue(lastNames.contains("LastName2"));
    }

    @Test
    void createNewCollectionsWithDataFiveElementsTest() {
        assertTrue(firstNames.contains("Kamilla"));
        assertTrue(lastNames.contains("LastName3"));
    }

    @Test
    void createNewCollectionsWithDataForMapOfNamesAndNumbersTest() {
        assertEquals(4, namesAndPhoneNumbers.size());
        namesAndPhoneNumbers.clear();
    }

    // 3.
    @Test
    void getMapOfNames1() {
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("Tom", 1);
        testMap.put("Ted", 1);
        testMap.put("Sara", 1);
        testMap.put("Kamilla", 1);
        assertEquals(testMap, mfd.getMapOfNames());

    }
    // Второй вариант такого же теста:
//        @Test
//        void getMapOfNames2() {
//        Map<String, Integer> result = mfd.getMapOfNames();
//        assertEquals(1, result.get("Tom").intValue());
//        assertEquals(1, result.get("Ted").intValue());
//        assertEquals(1, result.get("Sara").intValue());
//        assertEquals(1, result.get("Kamilla").intValue());
//    }

    // 4.
    @Test
    void getFirstLetterOfNamesTest1() {

        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("T", 2);
        testMap.put("S", 1);
        testMap.put("K", 1);
        assertEquals(testMap, mfd.getFirstLetterOfNames());
    }

    // 5.
    @Test
    void getListOfPhoneNumbersLikeDigitTest() {
        List<Long> testList = new ArrayList<>();
        testList.add(1111L);
        testList.add(2222L);
        testList.add(3333L);
        testList.add(4444L);
        assertEquals(testList, mfd.getListOfPhoneNumbersLikeDigit());
    }

    // 6.
    @Test
    void groupNamesByLongTest() {
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("Tom", 3);
        testMap.put("Ted", 3);
        testMap.put("Sara", 4);
        testMap.put("Kamilla", 7);
        assertEquals(testMap, mfd.groupNamesByLong());
    }

    // 7.
    @Test
    void getUniqueLastNamesTest() {
        List<String> testList = new ArrayList<>();
        lastNames.add("LastName3");
        testList.add("LastName1");
        testList.add("LastName2");
        testList.add("LastName3");
        testList.add("LastName4");
        assertEquals(5, lastNames.size());
        assertEquals(testList, mfd.getUniqueLastNames());
        assertEquals(4, testList.size());
    }

    // 8.
    @Test
    void getListWithReversOrderTest() {
        List<String> testList = new ArrayList<>();
        testList.add("Tom");
        testList.add("Ted");
        testList.add("Sara");
        testList.add("Kamilla");
        assertEquals(testList, mfd.getListWithReversOrder());
    }

    // 9. (Тесты как для метода № 2)
    @Test
    void getMapWithNamesAndPhoneNumbersForListOfPhoneNumbersTest() {
        assertEquals(4, phoneNumbers.size());
    }

    @Test
    void getMapWithNamesAndPhoneNumbersWithMrAndMrsTest() {
        assertTrue(firstNames.contains("Tom"));
        assertTrue(lastNames.contains("LastName1"));
    }

    @Test
    void getMapWithNamesAndPhoneNumbersFourElementsTest() {
        assertTrue(firstNames.contains("Ted"));
        assertTrue(lastNames.contains("LastName2"));
    }

    @Test
    void getMapWithNamesAndPhoneNumbersFiveElementsTest() {
        assertTrue(firstNames.contains("Kamilla"));
        assertTrue(lastNames.contains("LastName3"));
    }

    // 10.
    @Test
    void getAverageLongOfNameTest() {
        int sumAllNames = (firstNames.get(0).length() + firstNames.get(1).length() + firstNames.get(2).length() + firstNames.get(3).length());
        int expected = sumAllNames / firstNames.size();
        assertEquals(expected, mfd.getAverageLongOfName());
    }

    // 11.
    @Test
    void getMapWithPhoneNumbersAndNamesTest() {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("1111", "Tom");
        testMap.put("2222", "Ted");
        testMap.put("3333", "Sara");
        testMap.put("4444", "Kamilla");
        assertEquals(testMap, mfd.getMapWithPhoneNumbersAndNames());
    }

    // 12.
    @Test
    void searchNamesAndPhoneNumbersByLongOfNamesTest() {
        List<Map.Entry<String, String>> testMinMap = mfd.getMinLongList();
        List<Map.Entry<String, String>> testMaxMap = mfd.getMaxLongList();
        mfd.searchNamesAndPhoneNumbersByLongOfNames();
        assertEquals(2, mfd.getMinLongList().size());
        assertEquals(1, mfd.getMaxLongList().size());
        assertEquals(testMinMap, mfd.getMinLongList());
        assertEquals(testMaxMap, mfd.getMaxLongList());
    }
}
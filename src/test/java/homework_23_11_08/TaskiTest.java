package homework_23_11_08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskiTest {
    Taski taski = new Taski();

    // 1.
    @Test
    void task1PositiveTest() {
        String str = "aa##aaa";
        boolean result = taski.task1(str);
        assertTrue(result);
    }

    @Test
    void task1NegativeTest() {
        String str = "aaa##aaa";
        boolean result = taski.task1(str);
        assertFalse(result);
    }

    // 2.
    @Test
    void task2PositiveTest() {
        String str = "LDLDRURU";
        boolean result = taski.task2(str);
        assertTrue(result);
    }

    @Test
    void task2NegativeRiteAndLeftTest() {
        String str = "LDLDRURUR";
        boolean result = taski.task2(str);
        assertFalse(result);
    }

    @Test
    void task2NegativeDoneAndUpTest() {
        String str = "DLDLDRURU";
        boolean result = taski.task2(str);
        assertFalse(result);
    }

    // 3.
    @Test
    void task3Test() {
        String str = "ayhT";
        int expected = 3;
        assertEquals(expected, taski.task3(str));
    }
}
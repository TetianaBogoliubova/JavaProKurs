package homework_23_11_01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private static final Author author1 = new Author("Name1", 2001);
    private static int countCopies;

    private Book creatBook() {
        return new Book("Title1", author1, "isbn1", 1);
    }

    // 1.
    @Test
    void setCopiesPositiveTest() {
        countCopies = 1;
        assertEquals(countCopies, creatBook().getCopies());
    }

    @Test
    void setCopiesWithExceptionTest() {
        countCopies = -1;
        assertThrows(IllegalArgumentException.class, () -> creatBook().setCopies(countCopies));
    }

    // 2.
    @Test
    void equalsPositiveTest() {
        Book thisBook = creatBook();
        assertEquals(creatBook(), thisBook);
    }

    @Test
    void equalsWithNullTest() {
        Book checkBook = null;
        assertNotEquals(creatBook(), checkBook);
    }

    @Test
    void equalsWithDifferentClassTest() {
        Book book = creatBook();
        String anotherClass = "Another class";
        assertNotEquals(book, anotherClass);
    }

    @Test
    void equalsWithSomeIsbntTest() {
        Book book1 = creatBook();
        Book book2 = new Book("Title2", author1, "isbn1", 5);
        assertEquals(book1, book2);
    }

    @Test
    void equalsWithDifferentIsbntTest() {
        Book book1 = creatBook();
        Book book2 = new Book("Title2", author1, "1234", 5);
        assertNotEquals(book1, book2);
    }
}
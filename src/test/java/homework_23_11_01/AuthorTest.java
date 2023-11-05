package homework_23_11_01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {
    private static final Author author1 = new Author("Name1", 2001);

    @Test
    void equalsPositiveTest() {
        Author checkAuthor = new Author("Name1", 2001);
        Author author = new Author("Name1", 2001);
        assertEquals(author, checkAuthor);
    }

    @Test
    void equalsWithNullTest() {
        Author checkAuthor = null;
        assertNotEquals(author1, checkAuthor);
    }

    @Test
    void equalsWithDifferentClassTest() {
        String anotherClass = "Another class";
        assertNotEquals(author1, anotherClass);
    }

    @Test
    void equalsWithSomeNameTest() {
        Author authorFirst = author1;
        Author authorSecond = new Author("Name1", 1967);
        assertEquals(authorFirst, authorSecond);
    }

    @Test
    void equalsWithDifferentNameTest() {
        Author authorFirst = author1;
        Author authorSecond = new Author("Name100", 2001);
        assertNotEquals(authorFirst, authorSecond);
    }
}
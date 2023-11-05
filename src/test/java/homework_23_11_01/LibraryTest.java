package homework_23_11_01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private static final Library library = new Library();
    private static final Author newAuthor = new Author("Name2", 2002);
    private static final List<Author> authors = new ArrayList<>();

    private Book creatBook() {
        Author author1 = new Author("Name1", 2001);
        return new Book("Title1", author1, "isbn1", 1);
    }

    @BeforeEach
    void setUp() {
        library.clearAuthor();
        library.clearBook();
        library.addBook(creatBook());
    }

    // 1.
    @Test
    void addBookPositiveTest() {
        library.addBook(creatBook());
        assertEquals(1, library.getNumberOfBooks());
    }// Не понимаю, почему в этом тесте не учитывается условие @BeforeEach!
    // (добавление в список одной книги). expected должен быть 2, но выдает желаемое 1.
    // Не вижу, где у меня ошибка.

    @Test
    void addBookWithExceptionTest() {
        Book book = null;
        assertThrows(IllegalArgumentException.class, () -> library.addBook(book));
    }

    @Test
    void addBookWithNewAuthorsPositiveTest() {
        Book bookWithNewAuthor = new Book("Title1", newAuthor, "isbn1", 1);
        library.addBook(bookWithNewAuthor);
        assertEquals(2, library.getNumberOfAuthors());
        assertTrue(library.getAuthors().contains(bookWithNewAuthor.getAuthor()));
    }

    @Test
    void addBookWithNewAuthorsNegativeTest() {
        library.addBook(creatBook());
        assertEquals(1, library.getNumberOfAuthors());
    }

    // 2.
    @Test
    void removeBookTest() {
        library.removeBook(creatBook());
        assertEquals(0, library.getNumberOfBooks());
    }

    @Test
    void removeBookWithExceptionTest() {
        Book book = null;
        assertThrows(IllegalArgumentException.class, () -> library.removeBook(book));
    }

    // 3.
    @Test
    void getBooksByAuthorPositiveTest() {
        Author author = new Author("Name1", 2001);
        Book book = creatBook();
        List<Book> expected = new ArrayList<>();
        expected.add(book);
        assertEquals(expected, library.getBooksByAuthor(author));
    }

    @Test
    void getBooksByAuthorNegativeTest() {
        List<Book> booksAndAuthors = library.getBooksByAuthor(newAuthor);
        assertEquals(Collections.emptyList(), booksAndAuthors);
    }

    // 4.
    @Test
    void getAllAuthorsTest() {
        List<Author> expected = new ArrayList<>();
        expected.add(new Author("Name1", 2001));
        assertEquals(expected, library.getAllAuthors());
    }

    // 5.
    @Test
    void findBookByISBNPositiveTest() {
        String isnb = "isbn1";
        Book book = creatBook();
        assertEquals(book, library.findBookByISBN(isnb));
    }

    @Test
    void findBookByISBNNegativeTest() {
        String isnb = "1234";
        assertNull(library.findBookByISBN(isnb));
    }

    // 6.
    @Test
    void searchBooksByTitlePositiveTest() {
        String title = "Title1";
        Book book = creatBook();
        List<Book> expected = new ArrayList<>();
        expected.add(book);
        assertEquals(expected, library.searchBooksByTitle(title));
    }

    @Test
    void searchBooksByTitleNegativeTest() {
        String title = "Title2";
        List<Book> bookAndTitle = library.searchBooksByTitle(title);
        assertEquals(Collections.emptyList(), bookAndTitle);
    }

    // 7.
    @Test
    void addCopiesTest() {
        Book book = creatBook();
        int additionalCopies = 2;
        int expected = book.getCopies() + additionalCopies;
        library.addCopies(book, additionalCopies);
        assertEquals(expected, book.getCopies());
    }

    @Test
    void addCopiesWithExceptionTest() {
        Book book = new Book("Title2", newAuthor, "isbn2", 2);
        library.addBook(creatBook());
        assertThrows(IllegalArgumentException.class, () -> library.addCopies(book, 2));
    }

    // 8.
    @Test
    void lendBookPositiveTest() {
        Book book = creatBook();
        library.addBook(creatBook());
        int expected = book.getCopies();
        library.lendBook(book);
        assertEquals(expected - 1, book.getCopies());
    }

    @Test
    void lendBookWithExceptionAnotherBookTest() {
        Book book = new Book("Title2", newAuthor, "isbn2", 2);
        library.addBook(creatBook());
        assertThrows(IllegalArgumentException.class, () -> library.lendBook(book));
    }

    @Test
    void lendBookWithExceptionBookLessZeroTest() {
        Book book = new Book("Title2", newAuthor, "isbn2", 0);
        library.addBook(book);
        assertThrows(IllegalArgumentException.class, () -> library.lendBook(book));
    }

    // 9.
    @Test
    void returnBookPositiveTest() {
        Book book = creatBook();
        library.addBook(creatBook());
        int excepted = book.getCopies();
        library.returnBook(book);
        assertEquals(excepted + 1, book.getCopies());
    }

    @Test
    void returnBookWithExceptionTest() {
        Book book = new Book("Title2", newAuthor, "isbn2", 0);
        library.addBook(creatBook());
        assertThrows(IllegalArgumentException.class, () -> library.returnBook(book));
    }

    // 10.
    @Test
    void getNumberOfBooksTest() {
        Book book = creatBook();
        library.addBook(book);
        assertEquals(1, library.getNumberOfBooks());
    } //второй тест из всех, где также не учитывается условие @BeforeEach
    //(добавление в список одной книги). Наверное, та же ошибка, но не понимаю,
    // в чем она.

    // 11.
    @Test
    void getNumberOfAuthorsTest() {
        Author author = new Author("Name1", 2001);
        authors.add(author);
        assertEquals(1, library.getNumberOfAuthors());
    }

    // 12.
    @Test
    void clearBookTest() {
        library.clearBook();
        int numberOfBooks = library.getNumberOfBooks();
        assertEquals(0, numberOfBooks);
    }

    // 13.
    @Test
    void clearAuthorTest() {
        library.clearAuthor();
        int numberOfAuthor = library.getNumberOfAuthors();
        assertEquals(0, numberOfAuthor);
    }
}
package homework_23_11_01;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Library {
    private final Set<Book> books;
    private final List<Author> authors;

    public List<Author> getAuthors() {
        return authors;
    }

    public Library() {
        this.books = new HashSet<>();
        this.authors = new ArrayList<>();
    }

    // 1.
    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        books.add(book);

        if (!authors.contains(book.getAuthor())) {
            authors.add(book.getAuthor());
        }
        System.out.println(books);
        System.out.println(authors);
    }

    // 2.
    public void removeBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        books.remove(book);
        System.out.println(books);
    }

    // 3.
    public List<Book> getBooksByAuthor(Author author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    // 4.
    public List<Author> getAllAuthors() {
        return new ArrayList<>(authors);
    }

    // 5.
    public Book findBookByISBN(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    // 6.
    public List<Book> searchBooksByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    // 7.
    public void addCopies(Book book, int additionalCopies) {
        if (!books.contains(book)) {
            throw new IllegalArgumentException("Book is not in the library");
        }
        book.setCopies(book.getCopies() + additionalCopies);
    }

    // 8.
    public void lendBook(Book book) {
        if (!books.contains(book) || book.getCopies() <= 0) {
            throw new IllegalArgumentException("Book is not available");
        }
        book.setCopies(book.getCopies() - 1);
    }

    // 9.
    public void returnBook(Book book) {
        if (!books.contains(book)) {
            throw new IllegalArgumentException("Book is not from this library");
        }
        book.setCopies(book.getCopies() + 1);
    }

    // 10.
    public int getNumberOfBooks() {
        return books.size();
    }

    // 11.
    public int getNumberOfAuthors() {
        return authors.size();
    }

    // 12.
    public void clearBook() {
        books.clear();
    }

    // 13.
    public void clearAuthor() {
        authors.clear();
    }
}


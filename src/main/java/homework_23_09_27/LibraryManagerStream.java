package homework_23_09_27;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryManagerStream {
    Generator generator = new Generator();
    LibraryManager libraryManager = new LibraryManager();
    List<Book> borrowedBooks = new ArrayList<>();
    List<Book> reservedBooks = new ArrayList<>();

    public List<Book> setUpBooks() {

        while (libraryManager.libraryCatalog.size() < 70) {
            Book book = new Book(
                    generator.getBookId(),
                    generator.getBookTitle(),
                    generator.getBookAuthor(),
                    generator.getBookGenre(),
                    generator.getBookYear(),
                    generator.getBookAvailable()
            );
            libraryManager.libraryCatalog.add(book);
        }
        return libraryManager.libraryCatalog;
    }

    public List<LibraryUser> setUpUsers() {
        while (libraryManager.libraryUsers.size() < 30) {
            LibraryUser libraryUser = new LibraryUser(
                    generator.getUserId(),
                    generator.getUserName(),
                    generator.getUserEmail(),
                    generator.getUserPhone(),
                    borrowedBooks.toString(),
                    reservedBooks.toString()
            );
            libraryManager.libraryUsers.add(libraryUser);
        }
        return libraryManager.libraryUsers;
    }

    // 1. Метод, который возвращает список доступных книг заданного жанра.
    public List<Book> listAvailableBooksByGenre2(Genre genre) {
        return libraryManager.libraryCatalog.stream()
                .filter(book -> book.getBookGenre().equals(genre) && book.isBookAvailable())
                .toList();

    }

    // 2. Метод,который возвращает множество адресов электронной почты пользователей, зарезервировавших книги.
    public Set<String> listUserEmailsWithReservedBooks2() {
        Set<String> setWithEmail = libraryManager.libraryUsers.stream()
                .filter(us -> us.getUserBooksReserved() != null)
                .map(libraryUser -> libraryUser.getUserEmail())
                .collect(Collectors.toSet());
        return setWithEmail;
    }

    // 3. Метод, который добавляет новую книгу в библиотеку.
    public void addBookToLibrary2(int bookId, String bookTitle, String bookAuthor, Genre bookGenre, int bookYear, boolean bookAvailable) {
        Book book = new Book(bookId, bookTitle, bookAuthor, bookGenre, bookYear, bookAvailable);
        libraryManager.libraryCatalog.add(book);
        System.out.println("В библиотеку добавлена новая книга: " + book);
    }

    // 4. Метод, который удаляет книгу из библиотеки.
    public void removeBookFromLibrary2(boolean bookAvailable) {
        libraryManager.libraryCatalog = libraryManager.libraryCatalog.stream()
                .filter(b -> b.isBookAvailable() == bookAvailable)
                .collect(Collectors.toList());
        System.out.println("Удаление книги из каталога по категории 'Доступность': " + libraryManager.libraryCatalog); //удаление возможно и по всем остальным характеристикам.
    }

    // 5. Метод, который позволяет пользователю взять книгу в аренду.
    public void borrowBook2(String userName, int bookId, String bookTitle, String bookAuthor, Genre bookGenre,
                            int bookYear, boolean bookAvailable) {
        Book borrowedBook = new Book(bookId, bookTitle, bookAuthor, bookGenre, bookYear, bookAvailable);

        libraryManager.libraryCatalog = libraryManager.libraryCatalog.stream()
                .filter(b -> b.getBookTitle().equals(bookTitle))
                .collect(Collectors.toList());
        libraryManager.libraryUsers = libraryManager.libraryUsers.stream()
                .filter(u -> u.getUserName().equals(userName))
                .collect(Collectors.toList());
        borrowedBooks.add(borrowedBook);
        System.out.println("Пользователь " + userName + " взял книгу: " + bookTitle + " в аренду");
    }

    // 6 .Метод, который позволяет пользователю зарезервировать книгу.
    public void reserveBook2(String userName, int bookId, String bookTitle, String bookAuthor, Genre bookGenre,
                             int bookYear, boolean bookAvailable) {
        Book reservedbook = new Book(bookId, bookTitle, bookAuthor, bookGenre, bookYear, bookAvailable);

        libraryManager.libraryCatalog = libraryManager.libraryCatalog.stream()
                .filter(b -> b.getBookTitle().equals(bookTitle))
                .collect(Collectors.toList());
        libraryManager.libraryUsers = libraryManager.libraryUsers.stream()
                .filter(u -> u.getUserName().equals(userName))
                .collect(Collectors.toList());
        reservedBooks.add(reservedbook);
        System.out.println("Пользователь " + userName + " поставил книгу: " + bookTitle + " в резерв");
    }
}





package homework_23_09_27;

import java.util.*;

public class LibraryManager {
    Generator generator = new Generator();
    List<Book> libraryCatalog = new ArrayList<>();
    List<LibraryUser> libraryUsers = new ArrayList<>();
    List<Book> borrowedBooks = new ArrayList<>();
    List<Book> reservedBooks = new ArrayList<>();

    public List<Book> setUpBooks() {

        while (libraryCatalog.size() < 70) {
            Book book = new Book(
                    generator.getBookId(),
                    generator.getBookTitle(),
                    generator.getBookAuthor(),
                    generator.getBookGenre(),
                    generator.getBookYear(),
                    generator.getBookAvailable()
            );
            libraryCatalog.add(book);
        }
        return libraryCatalog;
    }

    public List<LibraryUser> setUpUsers() {
        while (libraryUsers.size() < 30) {
            LibraryUser libraryUser = new LibraryUser(
                    generator.getUserId(),
                    generator.getUserName(),
                    generator.getUserEmail(),
                    generator.getUserPhone(),
                    borrowedBooks.toString(),
                    reservedBooks.toString()
            );
            libraryUsers.add(libraryUser);
        }
        return libraryUsers;
    }

    // 1.Метод, который возвращает список доступных книг заданного жанра.
    public List<Book> listAvailableBooksByGenre(Genre genre) {
        List<Book> newList = new ArrayList<>();
        for (Book i : libraryCatalog) {
            if (i.getBookGenre().equals(genre)) {
                newList.add(i);
            }
        }
        return newList;
    }

    // 2. Метод,который возвращает множество адресов электронной почты пользователей, зарезервировавших книги.
    public Set<String> listUserEmailsWithReservedBooks() {
        Set<String> setWithEmail = new HashSet<>();
        for (LibraryUser i : libraryUsers) {
            if (i.getUserBooksReserved() != null) {
                setWithEmail.add(i.getUserEmail());
            }
        }
        return setWithEmail;
    }

    // 3. Метод, который добавляет новую книгу в библиотеку.
    public void addBookToLibrary(int bookId, String bookTitle, String bookAuthor, Genre bookGenre, int bookYear, boolean bookAvailable) {
        Book book = new Book(bookId, bookTitle, bookAuthor, bookGenre, bookYear, bookAvailable);
        libraryCatalog.add(book);
        System.out.println("В библиотеку добавлена новая книга: " + book);
    }

    // 4. Метод, который удаляет книгу из библиотеки.
    public void removeBookFromLibrary(boolean bookAvailable) {
        Iterator<Book> iterator = libraryCatalog.iterator();
        while (iterator.hasNext()) {
            Book i = iterator.next();
            if (i.isBookAvailable() == bookAvailable) {
                iterator.remove();
            }
        }
        System.out.println("Удаление книги из каталога по категории 'Доступность': " + libraryCatalog); //удаление возможно и по всем остальным характеристикам.
    }

    // 5. Метод, который позволяет пользователю взять книгу в аренду.
    public void borrowBook(String userName, int bookId, String bookTitle, String bookAuthor, Genre bookGenre, int bookYear, boolean bookAvailable) {
        Book book = new Book(bookId, bookTitle, bookAuthor, bookGenre, bookYear, bookAvailable);
        for (LibraryUser i : libraryUsers) {
            if (i.getUserName().equals(userName)) {
                for (Book j : libraryCatalog) {
                    if (j.getBookTitle().equals(bookTitle)) {
                        borrowedBooks.add(book);
                    } else System.out.println("Эта книга сейчас недоступна");
                }
            }
        }
        System.out.println("Пользователь " + userName + "взял книгу: " + book + " в аренду");
    }

    // 6 .Метод, который позволяет пользователю зарезервировать книгу.
    public void reserveBook(String userName, int bookId, String bookTitle, String bookAuthor, Genre bookGenre, int bookYear, boolean bookAvailable) {
        Book book = new Book(bookId, bookTitle, bookAuthor, bookGenre, bookYear, bookAvailable);
        for (LibraryUser i : libraryUsers) {
            if (i.getUserName().equals(userName)) {
                for (Book j : libraryCatalog) {
                    if (j.getBookTitle().equals(bookTitle)) {
                        reservedBooks.add(book);
                    }
                }
            }
        }
        System.out.println("Пользователь " + userName + "поставил книгу: " + book + " в резерв");
    }
}
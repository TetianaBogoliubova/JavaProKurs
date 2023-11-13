package homework_23_09_27;

import com.github.javafaker.Faker;

import java.util.Random;

public class Generator {
    Random random = new Random();
    Faker faker = new Faker();

    private LibraryManager libraryManager;

    public Generator() {
    }

    public int getBookId() {
        int bookId = random.nextInt(1, 100);
        return bookId;
    }

    public String getBookTitle() {
        String bookTitle = faker.book().title();
        return bookTitle;
    }

    public String getBookAuthor() {
        String bookAuthor = faker.book().author();
        return bookAuthor;
    }

    public Genre getBookGenre() {
        Book book = new Book();
        Genre[] genres = Genre.values();
        int indexGenre = random.nextInt(genres.length);
        book.setBookGenre(genres[indexGenre]);
        return book.getBookGenre();
    }

    public int getBookYear() {
        int bookYear = random.nextInt(1930, 2023);
        return bookYear;
    }

    public boolean getBookAvailable() {
        boolean bookAvailable = random.nextBoolean();
        return bookAvailable;
    }

    public int getUserId() {
        int userId = random.nextInt(1, 100);
        return userId;
    }

    public String getUserName() {
        String userName = faker.name().fullName();
        return userName;
    }

    public String getUserEmail() {
        String userEmail = faker.internet().emailAddress();
        return userEmail;
    }

    public int getUserPhone() {
        int UserPhone = random.nextInt(1000000, 9000000);
        return UserPhone;
    }

    public Book getUserBooksBorrowed() {
        if (libraryManager != null) {
            return libraryManager.libraryCatalog.get(random.nextInt(libraryManager.libraryCatalog.size()));
        }
        return null;
    }

    public Book getUserBooksReserved() {
        if (libraryManager != null && !libraryManager.libraryCatalog.isEmpty()) {
            return libraryManager.libraryCatalog.get(random.nextInt(libraryManager.libraryCatalog.size()));
        }
        return null;
    }
}

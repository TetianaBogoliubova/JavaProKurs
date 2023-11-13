package homework_23_09_27;

public class Main {
    public static void main(String[] args) {
        LibraryManagerStream lms = new LibraryManagerStream();
        LibraryManager libraryManager = new LibraryManager();
        Generator generator = new Generator();

        System.out.println("Формирование каталога книг" + libraryManager.setUpBooks());
        System.out.println("Формирование каталога пользователей: " + libraryManager.setUpUsers());
        System.out.println("Список доступных книг заданного жанра: " + libraryManager.listAvailableBooksByGenre(Genre.ROMAN));
        System.out.println("Список адресов электронной почты пользователей, зарезервировавших книги: " + libraryManager.listUserEmailsWithReservedBooks());
        libraryManager.addBookToLibrary(generator.getBookId(), generator.getBookTitle(), generator.getBookAuthor(), generator.getBookGenre(), generator.getBookYear(), generator.getBookAvailable());
        libraryManager.removeBookFromLibrary(false);
        libraryManager.borrowBook(generator.getUserName(), generator.getBookId(), generator.getBookTitle(), generator.getBookAuthor(), generator.getBookGenre(), generator.getBookYear(), generator.getBookAvailable());
        libraryManager.reserveBook(generator.getUserName(), generator.getBookId(), generator.getBookTitle(), generator.getBookAuthor(), generator.getBookGenre(), generator.getBookYear(), generator.getBookAvailable());
        System.out.println("----------------------------");
        System.out.println("Методы из класса LibraryManagerStream()");
        System.out.println("Формирование каталога книг" + lms.setUpBooks());
        System.out.println("Формирование каталога пользователей: " + lms.setUpUsers());
        System.out.println("Список доступных книг заданного жанра: " + lms.listAvailableBooksByGenre2(Genre.CLASSIC));
        System.out.println("Список адресов электронной почты пользователей, зарезервировавших книги: " + lms.listUserEmailsWithReservedBooks2());
        lms.addBookToLibrary2(generator.getBookId(), generator.getBookTitle(), generator.getBookAuthor(), generator.getBookGenre(), generator.getBookYear(), generator.getBookAvailable());
        lms.removeBookFromLibrary2(false);
        lms.borrowBook2(generator.getUserName(), generator.getBookId(), generator.getBookTitle(), generator.getBookAuthor(), generator.getBookGenre(), generator.getBookYear(), generator.getBookAvailable());
        lms.reserveBook2(generator.getUserName(), generator.getBookId(), generator.getBookTitle(), generator.getBookAuthor(), generator.getBookGenre(), generator.getBookYear(), generator.getBookAvailable());
    }
}

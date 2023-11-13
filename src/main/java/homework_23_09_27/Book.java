package homework_23_09_27;

public class Book {

    private int bookId; //Уникальный идентификатор книги.
    private String bookTitle;//Название книги.
    private String bookAuthor;// Автор книги.
    private Genre bookGenre; //Жанр книги.
    private int bookYear; //Год издания книги.
    private boolean bookAvailable; //Доступность книги (true - доступна, false - не доступна).

    public Book() {
    }

    public Book(int bookId, String bookTitle, String bookAuthor, Genre bookGenre, int bookYear, boolean bookAvailable) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
        this.bookYear = bookYear;
        this.bookAvailable = bookAvailable;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public Genre getBookGenre() {
        return bookGenre;
    }

    public boolean isBookAvailable() {
        return bookAvailable;
    }

    public void setBookGenre(Genre bookGenre) {
        this.bookGenre = bookGenre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookGenre='" + bookGenre + '\'' +
                ", bookYear=" + bookYear +
                ", bookAvailable=" + bookAvailable +
                '}';
    }
}

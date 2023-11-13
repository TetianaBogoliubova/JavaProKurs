package homework_23_09_27;

public class LibraryUser {
    private int userId;// Уникальный идентификатор пользователя библиотеки.
    private String userName; //Iмя пользователя.
    private String userEmail;//Электронная почта пользователя.
    private int userPhone;//Номер телефона пользователя.
    private String userBooksBorrowed;//Список книг, взятых пользователем в аренду.
    private String userBooksReserved; //Множество книг, зарезервированных пользователем

    public LibraryUser(int userId, String userName, String userEmail, int userPhone, String userBooksBorrowed, String userBooksReserved) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userBooksBorrowed = userBooksBorrowed;
        this.userBooksReserved = userBooksReserved;
    }
    public String getUserName() {
        return userName;
    }

    public int getUserId() {
        return userId;
    }

    public int getUserPhone() {
        return userPhone;
    }

    public String getUserBooksBorrowed() {
        return userBooksBorrowed;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserBooksReserved() {
        return userBooksReserved;
    }

    @Override
    public String toString() {
        return "LibraryUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone=" + userPhone +
                ", userBooksBorrowed='" + userBooksBorrowed + '\'' +
                ", userBooksReserved='" + userBooksReserved + '\'' +
                '}';
    }
}

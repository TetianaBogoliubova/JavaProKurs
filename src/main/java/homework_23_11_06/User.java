package homework_23_11_06;

/**
 * Задание 2: Сервис уведомлений с зависимостями
 * Бизнес логика:
 * <p>
 * User - класс пользователя, содержащий информацию о пользователе.
 * EmailService - сервис для отправки электронной почты.
 * NotificationService - сервис для отправки уведомлений, который использует EmailService.
 */
public class User {
    private final String id;
    private final String email;

    public User(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}

interface EmailService {
    boolean sendEmail(String toAddress, String subject, String body);
}

class NotificationService implements EmailService {
    private final EmailService emailService;

    @Override
    public boolean sendEmail(String toAddress, String subject, String body) {
        return false;
    }

    public NotificationService(EmailService emailService) {////////////////
        this.emailService = emailService;
    }

    public boolean notifyUser(User user, String subject, String message) {
        return emailService.sendEmail(user.getEmail(), subject, message);
    }
}

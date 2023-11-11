package homework_23_11_06;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {

    @InjectMocks
    private NotificationService notificationService;
    @Mock
    private EmailService emailService;
    @Mock
    private User user;

    @Test
    void sendEmailTest() {
        String toAddress = "Address";
        String subject = "Subject";
        String body = "Body";
        boolean expended = false;
        assertEquals(expended, notificationService.sendEmail(toAddress, subject, body));
    }

    @Test
    void notifyUserTest() {
        String toAddress = user.getEmail();
        String subject = "Subject";
        String body = "Body";

        Mockito.when(emailService.sendEmail(toAddress, subject, body)).thenReturn(false);
        boolean expended = false;
        assertEquals(expended, notificationService.notifyUser(user, subject, body));

        Mockito.verify(emailService).sendEmail(toAddress, subject, body);
    }
}
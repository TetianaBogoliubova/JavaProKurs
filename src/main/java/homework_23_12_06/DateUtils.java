package homework_23_12_06;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String formatDateForDisplay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    public static String formatTimeForDisplay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(date);
    }

    public static String formatDateTimeForDisplay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(date);
    }
}
//          *** исправленный ***
 class DateUtilsCorrect {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static String formatDateForDisplay(Date date) {
        if (date == null){
            return "No date";
        }
        return DATE_FORMAT.format(date);
    }

    public static String formatTimeForDisplay(Date date) {
        if (date == null){
            return "No time";
        }
        return TIME_FORMAT.format(date);
    }

    public static String formatDateTimeForDisplay(Date date) {
        if (date == null){
            return "No date and time";
        }
        return DATE_TIME_FORMAT.format(date);
    }
}

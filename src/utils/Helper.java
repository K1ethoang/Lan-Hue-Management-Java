package utils;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.sql.Time;
import java.util.Currency;

/**
 *
 * @author kieth
 */
public class Helper {

    public static String formatDateToPrint(Date date) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return (String) df.format(date);
    }

    public static String formatDateToSet(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return (String) df.format(date);
    }

    public static String formatTimeToSet(Time time) {
        DateFormat df = new SimpleDateFormat("hh:mm:ss");
        return (String) df.format(time);
    }

    public static String getMonth(Date date) {
        DateFormat df = new SimpleDateFormat("MM");
        return (String) df.format(date);
    }

    public static String formatPriceToDisplay(double number) {
        // Create a new Locale
        Locale vn = new Locale("vi", "VN");
        // Create a formatter given the Locale
        NumberFormat dongFormat = NumberFormat.getCurrencyInstance(vn);
        // Format the Number into a Currency String
        String s = dongFormat.format(number);
        return s;
    }

    public static String removeSpaceInString(String s) {
        if (s != null) {
            return (String) s.replace(" ", "");
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(formatPriceToDisplay(100000.0));
    }

}

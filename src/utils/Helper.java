package utils;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

    public static String getMonth(Date date) {
        DateFormat df = new SimpleDateFormat("MM");
        return (String) df.format(date);
    }

    public static String formatPriceToDisplay(double number) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String s = currencyVN.format(number);
        return s;
    }

}

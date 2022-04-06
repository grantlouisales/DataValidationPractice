import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DataValidationPractice {

    final String cisIDFormat = "\\w\\w\\w\\w-\\w\\w\\w\\w";
    final String pidFormat = "\\w\\w\\w\\w-\\w\\w\\w";
    final String dateFormat = "yyyy-MM-dd";

    public void isCorrectCisIDFormat(String cisID, String re) {
        Pattern pt = Pattern.compile(re);
        Matcher mt = pt.matcher(cisID);

        if (!mt.matches()) {
            System.out.println("Write to file");
        }
    }

    public void isCorrectPIDFormat(String PID, String re2) {
        Pattern pt2 = Pattern.compile(re2);
        Matcher mt2 = pt2.matcher(PID);

        if (!mt2.matches()) {
            System.out.println("Write to file");
        }
    }

    public void isCorrectDateFormat(String value, String format) {
    // Use this link to check date format -> https://stackoverflow.com/questions/20231539/java-check-the-date-format-of-current-string-is-according-to-required-format-or#:~:text=is%20not%20useful-,Show%20activity%20on%20this%20post.,in%20different%20format%20or%20invalid.%20%7D
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                System.out.println("Write to file");
            }

        } catch (ParseException ex) {
            System.out.println("Write data to file");
        }
    }

    public void isAhnentafelValid(String ahnentafel) {

        try {
            int ahnentafelInt = Integer.parseInt(ahnentafel);
            boolean result = ahnentafelInt >= 1;

            if (!result) {
                System.out.println("Ahnentafel not big enough to be valid");
            }

        } catch (NumberFormatException ex) {
            System.out.println("Not an Integer");
        }
    }

    public void isValueEmpty(String value) {
        if (value.isEmpty()) {
            System.out.println("Write to file");
        }
    }

    public static void main(String[] args) {
        DataValidationPractice demo = new DataValidationPractice();

        demo.isCorrectDateFormat("2014-09-12", demo.dateFormat);
//        // Test if ahnentafel is working
//        demo.isAhnentafelValid("-10"); // Manually prints out message
//        demo.isAhnentafelValid("-10T"); // Error Message
//        demo.isAhnentafelValid("0"); // Error
//        demo.isAhnentafelValid("1"); // 1
//        demo.isAhnentafelValid("100"); // 100
//        demo.isAhnentafelValid(""); // 100
    }
}

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DataValidationPractice {

    public void isCorrectCisIDFormat(String cisID, String re, Pattern pt, Matcher mt) {
        if (!mt.matches()) {
            System.out.println("Write to file");
        }
    }

    public void isCorrectPIDFormat(String PID, String re, Pattern pt, Matcher mt) {

    }

    public void isCorrectDateFormat(String date) {
    // Use this link to check date format -> https://stackoverflow.com/questions/20231539/java-check-the-date-format-of-current-string-is-according-to-required-format-or#:~:text=is%20not%20useful-,Show%20activity%20on%20this%20post.,in%20different%20format%20or%20invalid.%20%7D

    }

    public void isAhnentafelValid(String ahnentafel) {

        try {
            int ahnentafelInt = Integer.parseInt(ahnentafel);
            boolean result = ahnentafelInt >= 1;

            if (!result) {
                // Write data to file since it is not correct
                System.out.println("Ahnentafel not big enough to be valid");
            }

        } catch (NumberFormatException ex) {
            // Will also write data to file if incorrect
            System.out.println("Not an Integer");
        }
    }

    public void isEmpty() {

    }

    public static void main(String[] args) {
        DataValidationPractice demo = new DataValidationPractice();

//        String re = "\\w\\w\\w\\w-\\w\\w\\w\\w";
//        String text = "MMMDXLCHP";
//        Pattern pt = Pattern.compile(re);
//        Matcher mt = pt.matcher(text);
//
//        demo.isCorrectCisIDFormat(text, re, pt, mt);


//        // Test if ahnentafel is working
//        demo.isAhnentafelValid("-10"); // Manually prints out message
//        demo.isAhnentafelValid("-10T"); // Error Message
//        demo.isAhnentafelValid("0"); // Error
//        demo.isAhnentafelValid("1"); // 1
//        demo.isAhnentafelValid("100"); // 100
    }
}

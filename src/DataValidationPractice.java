import java.io.FileWriter;

public class DataValidationPractice {

    public void isCorrectCisIDFormat(String cisID) {

    }

    public void isCorrectPIDFormat(String PID) {

    }

    public void isCorrectDateFormat(String date) {

    }

    public void isAhnentafelValid(String ahnentafel, FileWriter fw) {

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

        // Test if ahnentafel is working
        demo.isAhnentafelValid("-10"); // Manually prints out message
        demo.isAhnentafelValid("-10T"); // Error Message
        demo.isAhnentafelValid("0"); // Error
        demo.isAhnentafelValid("1"); // 1
        demo.isAhnentafelValid("100"); // 100
    }
}

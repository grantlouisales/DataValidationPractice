import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DataValidationPractice {

    final String cisIDFormat = "\\w\\w\\w\\w-\\w\\w\\w\\w";
    final String pidFormat = "\\w\\w\\w\\w-\\w\\w\\w";
    final String dateFormat = "yyyy-MM-dd";
    public int patronIdIndex = 0;
    public int ancestorPidIndex = 0;
    public int ancestorNameIndex = 0;
    public int ahnentafelIndex = 0;


    public void isCorrectCisIDFormat(String cisID, String re) {
        if(!cisID.matches(re)) System.out.println("Write to file ");
    }

    public void isCorrectPIDFormat(String PID, String re2) {
        if (!PID.matches(re2)) System.out.println("Write to file ");
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
            float ahnentafelFloat = Float.parseFloat(ahnentafel);
            boolean result = ahnentafelFloat >= 1;

            if (!result) System.out.println("Ahnentafel not big enough to be valid ");

        } catch (NumberFormatException ex) {
            System.out.println("Not an Integer");
        }
    }

    public void isValueEmpty(String value) {
        if (value.isEmpty()) System.out.println("Write to file");
    }

    public void findAndSetIndexes(String[] headerLine) {
        int currIndex = 0; // Go off the index to grab
        for (String value : headerLine) {
            String cleanedValue = value.replaceAll("\"", "");

            switch (cleanedValue) {
                case "patron_id" -> patronIdIndex = currIndex;
                case "ancestor_pid" -> ancestorPidIndex = currIndex;
                case "ancestor_name" -> ancestorNameIndex = currIndex;
                case "ahnentafel" -> ahnentafelIndex = currIndex;
            }
            currIndex++;
        }
    }

    public static void main(String[] args) {
        DataValidationPractice demo = new DataValidationPractice();
        demo.isCorrectCisIDFormat("LL08-HDK1", demo.cisIDFormat);

//        try {
//            String path = ""; // File to read from
//            String line = "";
//            int currLine = 1;

//            BufferedReader br = new BufferedReader(new FileReader(path));
//            String[] headerValues = br.readLine().split("\t"); // Removes the header file line
//
//            demo.findAndSetIndexes(headerValues);
//
//            while((line = br.readLine()) != null) {
//                String[] lineValues = line.split("\t"); // Removes the header file line
//
//                String patronId = lineValues[demo.patronIdIndex].replaceAll("\"", "");
//                String ancestorPid = lineValues[demo.ancestorPidIndex].replaceAll("\"", "");
//                String ancestorName = lineValues[demo.ancestorNameIndex].replaceAll("\"", "");
//                String ahnentafel = lineValues[demo.ahnentafelIndex].replaceAll("\"", "");
//
//                demo.isCorrectCisIDFormat(patronId, demo.cisIDFormat, currLine);
//                demo.isCorrectPIDFormat(ancestorPid, demo.pidFormat, currLine);
//                demo.isValueEmpty(ancestorName, currLine);
//                demo.isAhnentafelValid(ahnentafel, currLine);
//                currLine++;
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}

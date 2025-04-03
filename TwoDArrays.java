import java.util.Random;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;

/**.
 * Class generates random marks for students and writes them to a CSV file.*
 * @author Tony Tran
 * @version 1.0
 * @since 2025-04-01
 */
final class TwoDArrays {
    /**
     * This is a private constructor to satisfy style checker.
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private TwoDArrays() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This method generates random marks for each student.
     * @param marks 2D array of students and their marks
     */
    public static void generateMarks(final String[][] marks) {
        // Create a random number generator
        Random random = new Random();
        // Generate random marks for each student
        for (int i = 1; i < marks.length; i++) {
            for (int j = 1; j < marks[0].length; j++) {
                // Generate random marks
                int mark = (int) (random.nextGaussian() * 10 + 75);
                marks[i][j] = String.valueOf(mark);
            }
        }
    }
    /**
     * This is the main method to run the program.
     * @param args
     */
    public static void main(final String[] args) throws Exception {
        File studentFile = new File("Unit1-08-students.txt");
        File assignFile = new File("Unit1-08-assignments.txt");
        Scanner scannerStudent = new Scanner(studentFile);
        Scanner scannerAssign = new Scanner(assignFile);
        // Create a CSV file to write the data
        FileWriter csvWriter = new FileWriter("marks.csv");
        // Create a 2D array to hold the students and their marks
        String[][] studentArray = new String[15][6];
        Random random = new Random();
        // Putting Students in the first column
        studentArray[0][0] = "Student";
        for (int i = 1; i < studentArray.length; i++) {
            studentArray[i][0] = scannerStudent.nextLine();
        }
        // Puts Assignments in the first row
        for (int i = 1; i < studentArray[0].length; i++) {
            studentArray[0][i] = scannerAssign.nextLine();
        }
        // Generate marks
        generateMarks(studentArray);
        // CSV file
        for (int i = 0; i < studentArray.length; i++) {
            for (int j = 0; j < studentArray[0].length; j++) {
                // Write the student name and marks to the CSV file
                csvWriter.write(studentArray[i][j]);
                if (j < studentArray[0].length - 1) {
                    // Add a comma between values
                    csvWriter.write(",");
                }
            }
            csvWriter.write("\n");
        }
        // Close the scanners and writer
        scannerStudent.close();
        scannerAssign.close();
        csvWriter.close();
        System.out.println(Arrays.deepToString(studentArray));
    }
}

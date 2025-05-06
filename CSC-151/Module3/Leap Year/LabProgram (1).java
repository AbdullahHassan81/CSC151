import java.util.Scanner;

public class LabProgram {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int inputYear;
      boolean isLeapYear;
      isLeapYear = false;
      inputYear = scnr.nextInt(); // Read user input for the year

      // Check for leap year conditions
      if ((inputYear % 4 == 0 && inputYear % 100 != 0) || (inputYear % 400 == 0)) {
         isLeapYear = true; // Set isLeapYear to true if a leap year
      }

      // Output the result based on isLeapYear
      if (isLeapYear) {
         System.out.println(inputYear + " - leap year"); // Output if it's a leap year
      } else {
         System.out.println(inputYear + " - not a leap year"); // Output if not
      }
    }
}
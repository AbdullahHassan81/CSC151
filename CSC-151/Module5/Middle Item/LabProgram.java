import java.util.Scanner; 
import java.util.ArrayList;
import java.util.List;

public class LabProgram {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      List<Integer> userValues = new ArrayList<>(); // Use a list to handle dynamic input

      // Collect user input until a negative number is entered
      int input;
      while (true) {
          input = scnr.nextInt(); // Read input
          if (input < 0) { // Check if the input is negative
           // Since we assume the number of integers is always odd,
          // we calculate the middle index
          int middleIndex = userValues.size() / 2; // Calculate the middle index
          int middleValue = userValues.get(middleIndex); // Get the middle integer

      // Print the middle integer
      System.out.println("Middle item: " + middleValue); // Output the result
              break; // Exit the loop if it's negative
          }
          if (userValues.size() > 9) { // Check if we already have 9 numbers
              System.out.println("Too many numbers"); // Changed print to println for better output
              break;
          }
          userValues.add(input); // Add valid input to the list
      }
   }
}

import java.util.Scanner; 

public class LabProgram {
   public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
      int currValue;
      int valuesSum = 0;       // Initialize sum of values
      int numValues = 0;       // Initialize number of values
      int maxValue = Integer.MIN_VALUE; // Initialize max value to the smallest integer

      // Read integers from input
      while (true) {
         currValue = scnr.nextInt(); // Gets the next value
         
         if (currValue < 0) { // Check if the value is negative
            break; // Exit loop if it's negative
         }

         valuesSum += currValue; // Add to sum
         numValues++; // Increment the count of non-negative values
         
         if(currValue > maxValue) { // Check for maximum value
            maxValue = currValue; // Update maxValue if currValue is greater
         }
      }
      
      // Calculate average
      double average = (double) valuesSum / numValues;

      // Print maximum and average values
      System.out.printf("%d %.2f\n", maxValue, average); // Correctly format output
      //System.out.printf(maxValue + "%.2f\n" + average);
      //System.out.println(maxValue + " " + average);             // Output max value
   }
}
    


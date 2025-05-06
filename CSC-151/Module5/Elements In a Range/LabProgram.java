import java.util.Scanner;
import java.util.ArrayList;

public class LabProgram {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        // Read the number of integers to expect
        int n = scnr.nextInt(); // First input is the count of integers
        int[] intList = new int[n]; // Create an array of size n

        // Read the integers into the array
        for (int i = 0; i < n; i++) {
            intList[i] = scnr.nextInt(); // Store each integer in the array
        }

        // Read the lower and upper bounds
        int lowerBound = scnr.nextInt();
        int upperBound = scnr.nextInt();

        // Output the integers within the specified range
        for (int i = 0; i < n; i++) {
            // Check if the current integer is within bounds
            if (intList[i] >= lowerBound && intList[i] <= upperBound) {
                System.out.print(intList[i] + ","); // Print the integer followed by a comma
            }
        }
        
        System.out.println(); // Print a newline after the output
        
        scnr.close(); // Close the scanner
    }
}

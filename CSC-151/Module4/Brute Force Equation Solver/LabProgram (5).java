import java.util.Scanner; 

public class LabProgram {
   public static void main(String[] args) {
      
         // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter coefficients for the first equation ax + by = c
        int a = scanner.nextInt(); // Read coefficient a
        int b = scanner.nextInt(); // Read coefficient b
        int c = scanner.nextInt(); // Read constant c

        // Prompt the user to enter coefficients for the second equation dx + ey = f
        int d = scanner.nextInt(); // Read coefficient d
        int e = scanner.nextInt(); // Read coefficient e
        int f = scanner.nextInt(); // Read constant f

        boolean foundSolution = false; // Flag to check if a solution is found

        // Start a brute force search for integers x and y in the range -10 to 10
        for (int x = -10; x <= 10; x++) { // Loop over x from -10 to 10
            for (int y = -10; y <= 10; y++) { // Loop over y from -10 to 10
                // Check if the current x and y satisfy both equations
                if (a * x + b * y == c && d * x + e * y == f) {
                    // If both equations are satisfied, print the solution
                    System.out.printf("x = %d, y = %d%n",x, y);
                    foundSolution = true; // Set the flag to true that a solution is found
                    break; // Exit the inner loop since the solution is found
                }
            }
            // Break the outer loop if a solution has been found
            if (foundSolution) {
                break; // Exit the outer loop
            }
        }

        // After checking all possible x and y, check if no solution was found
        if (!foundSolution) {
            System.out.println("There is no solution"); // Print message if no solution exists
        }
   }
}
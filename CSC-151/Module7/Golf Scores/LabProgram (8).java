import java.util.Scanner;

public class LabProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read user input for strokes and par
        int strokes = scanner.nextInt();
        int par = scanner.nextInt();
        
        String scoreName = ""; // Initialize score name

        // Check par validity
        if (par == 3 || par == 4 || par == 5) {
            // Determine the score name based on the number of strokes
            if (strokes == par - 2) {
                scoreName = "Eagle"; // Two strokes less than par
            } else if (strokes == par - 1) {
                scoreName = "Birdie"; // One stroke less than par
            } else if (strokes == par) {
                scoreName = "Par"; // Equal to par
            } else if (strokes == par + 1) {
                scoreName = "Bogey"; // One stroke more than par
            } else {
                scoreName = "Error"; // Invalid score
            }
        } else {
            scoreName = "Error"; // Invalid par value
        }
        
        // Print the score name or error message
        System.out.println(scoreName);
    }
}
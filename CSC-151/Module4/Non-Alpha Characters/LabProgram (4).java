import java.util.Scanner;

public class LabProgram {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
        String input;

        input = in.nextLine(); // Changed to nextLine() to capture the whole input

        // Use StringBuilder to build the result string with only alphabetic characters
        StringBuilder result = new StringBuilder();

        // Loop through each character in the input
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // Check if the character is alphabetic
            if (Character.isLetter(c)) {
                result.append(c); // Add it to the result if it's a letter
            }
        }

        // Print the cleaned input
        System.out.println(result.toString());
    }
}

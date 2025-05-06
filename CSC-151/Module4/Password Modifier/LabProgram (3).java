import java.util.Scanner;

public class LabProgram {
   public static void main(String[] args) {
      Scanner k = new Scanner(System.in);
      String userPass;

      // Get the Password   
      userPass = k.next(); // Reads input correctly
      
      // Loop through each character in the input string
      for (char c : userPass.toCharArray()) { // Convert to char array
         // Use switch to check each character and print the replacement
         switch (c) { // Switch statement to check each character
            case 'i':
               System.out.print("1"); // Use print instead of println to stay on the same line
               break; // Exit switch after case
            case 'a':
               System.out.print("@");
               break; // Exit switch after case
            case 'm':
               System.out.print("M");
               break; // Exit switch after case
            case 'B':
               System.out.print("8");
               break; // Exit switch after case
            case 's':
               System.out.print("$");
               break; // Exit switch after case
            default:
               // If character doesn't match any case, we print it as is
               System.out.print(c); // Use print to stay on the same line
         }
      }
      System.out.println("!"); // Print "!" at the end of the output    
   }
}
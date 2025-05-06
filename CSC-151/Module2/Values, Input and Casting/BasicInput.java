import java.util.Scanner;

public class BasicInput {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int userInt;
      double userDouble;
      // TODO: Define char and string variables similarly
      char userChar; 
      String userString; 
      
      System.out.println("Enter integer:");
      userInt = scnr.nextInt();

      System.out.println("Enter double:");
      userDouble = scnr.nextDouble();

       System.out.println("Enter character:");
      userChar = scnr.next().charAt(0);  // Read a string and get the first character

      System.out.println("Enter string:");
      userString = scnr.next();  // Read the string

      // Step 1: Output the four values on a single line separated by a space
      System.out.println(userInt + " " + userDouble + " " + userChar + " " + userString);

      // Step 2: Output the four values in reverse
      System.out.println(userString + " " + userChar + " " + userDouble + " " + userInt);

      // Step 3: Cast the double to an integer and output that integer
      System.out.println(userDouble + " cast to an integer is " + (int)userDouble);  // Cast double to integer
   }
}
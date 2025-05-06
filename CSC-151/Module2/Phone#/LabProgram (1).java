import java.util.Scanner;

public class LabProgram {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String phoneNumber = scnr.next();
      //I used Java tutor

      // Check if the phone number matches the expected format
      if (phoneNumber.matches("\\d{10}")) { // matches 10 digits
         // Format the phone number as (000) 000-0000
         String formattedPhoneNumber = String.format("(%s) %s-%s", 
            phoneNumber.substring(0, 3), // area code
            phoneNumber.substring(3, 6), // prefix
            phoneNumber.substring(6) // line number
         );
         System.out.println(formattedPhoneNumber);
      } else {
         System.out.println("Invalid phone number format. Please use 10 digits.");
      }
   }
}
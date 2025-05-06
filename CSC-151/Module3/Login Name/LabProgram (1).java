import java.util.Scanner;

public class LabProgram {

	public static void main(String[] args) {
        Scanner k = new Scanner(System.in);

        String firstName, lastName; 
        int digit; 
        
         // Get the first and last name
        firstName = k.next();

        lastName = k.next();

        // Get 4 numbers
        digit = k.nextInt();

        // Prepare login name
        String loginName = ""; // Variable to store the login name

        // Check the length of the first name
        if (firstName.length() < 6) {
            loginName += firstName; // Use the whole first name if it's less than 6 letters
        } else {
            loginName += firstName.substring(0, 6); // Use the first 6 letters of the first name
        }
        
        loginName += lastName.charAt(0); // Add the first letter of the last name
        loginName += "_"; // Add an underscore
        loginName += digit % 10; // Add the last digit of the number entered

        System.out.println("Your login name: " + loginName); // Print the login name
	}
}
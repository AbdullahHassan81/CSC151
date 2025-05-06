import java.util.Scanner; 

public class LabProgram {
   public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);

       // Declare coin values in pennies
        int dollarValue = 100;
        int quarterValue = 25;
        int dimeValue = 10;
        int nickelValue = 5;
        int pennyValue = 1;
        
        // Input the total amount in pennies from the user
        int totalPennies = scnr.nextInt();

        if (totalPennies ==0 ) {
            System.out.println("No change");
            return;
        }
        
        // Calculate the number of each coin type
        int dollars = totalPennies / dollarValue; // Calculate dollars
        totalPennies %= dollarValue; // Remainder after accounting for dollars
        
        int quarters = totalPennies / quarterValue; // Calculate quarters
        totalPennies %= quarterValue; // Remainder after accounting for quarters
                
        int dimes = totalPennies / dimeValue; // Calculate dimes
        totalPennies %= dimeValue; // Remainder after accounting for dimes
        
        int nickels = totalPennies / nickelValue; // Calculate nickels
        totalPennies %= nickelValue; // Remainder after accounting for nickels
        
        int pennies = totalPennies; // Remaining amount is all pennies

       
        // Output the number of each coin, singular or plural
        if (dollars > 0) {
            System.out.println(dollars + (dollars > 1 ? " Dollars" : " Dollar"));
        }
        if (quarters > 0) {
            System.out.println(quarters + (quarters > 1 ? " Quarters" : " Quarter"));
        }
        if (dimes > 0) {
            System.out.println(dimes + (dimes > 1 ? " Dimes" : " Dime"));
        }
        if (nickels > 0) {
            System.out.println(nickels + (nickels > 1 ? " Nickels" : " Nickel"));
        }
        if (pennies > 0) {
            System.out.println(pennies + (pennies > 1 ? " Pennies" : " Penny"));
        }
   }
}
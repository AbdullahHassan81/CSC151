import java.util.Scanner;

public class LabProgram {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      //getting the variables
      double nickels = 0.05, dimes = 0.10, quarters = 0.25, number_of_nickels, number_of_dimes, number_of_quarters, total_quarters = 0, total_dimes, total_nickels, total_money;
      int dollars; 

      //System.out.print("How many nickels do you have? ");
      number_of_nickels = scnr.nextDouble();
    
      total_nickels = number_of_nickels * nickels;
      //System.out.println(total_nickels);

      //System.out.print("How many dimes do you have? ");
      number_of_dimes = scnr.nextDouble();

      total_dimes = number_of_dimes * dimes;
      //System.out.println(total_dimes);

      //System.out.println("How many quarters do you have? ");
      number_of_quarters = scnr.nextDouble();

      total_quarters = number_of_quarters * quarters; 
      //System.out.println(total_quarters);

      total_money = total_quarters + total_dimes + total_nickels; 
      System.out.printf("Amount: $%.2f\n", total_money);



   }
}
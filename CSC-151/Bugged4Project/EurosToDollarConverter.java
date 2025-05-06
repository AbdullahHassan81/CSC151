/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package faytechcc.edu.eurostodollarconverter;
import java.util.Scanner;
/**
 *
 * @author hassana5237
 */
public class EurosToDollarConverter {
    //main method 
    public static void main(String[] args) {
        // call the other methods
        displayMenu(); 
        DollarsToEuros();
    }
    
    
//display menu
    public static void displayMenu(){
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println("Menu");
        System.out.println();
        System.out.println("1) Option 1\n2) Option 2\n3) Exit");
        System.out.print("Selection: ");
        
        switch(in.nextInt())
        {
            case 1: 
                System.out.println();
                System.out.println("You picked option 1!");
                break; 
            case 2:
                System.out.println();
                System.out.println("You picked option 2!");
                break;
            case 3:
                System.out.println();
                System.out.println("Exiting the program");
                displayMenu();
                break;
    }
    }
    // Convert to Mehthod
    public static void EurosToDollars() {
        Scanner k = new Scanner(System.in);

        double euros;
        double dollarPerEuros;
        double grossDollars;
        double fee;
        
        System.out.println("Welcome to the Euros to Dollars Converter.\n"); 
        System.out.print("How many euros do you want to convert? ");
        euros = k.nextDouble();
        System.out.print("What is the dollars-per-euros exchange rate? "); 
        dollarPerEuros = k.nextDouble();
        grossDollars = euros * dollarPerEuros;
        System.out.println(euros + " Euros => " + grossDollars
        + " Gross Dollars.");
        System.out.print("\nWhat is the dollar-per-euro Fee Percentage % ? ");
        double rate = k.nextDouble(); 
        
        fee = grossDollars * rate/100;
        double netDollars = grossDollars - fee;
        
        System.out.println("Thank you for using the Euros to Dollars Converter.\n");
	System.out.println("Please check your Math.\n");	
        System.out.println(euros + " \tEuros\n " + 
                dollarPerEuros + " \tDollars Per Euros Exchange Rate\n" +
                grossDollars + " \tGross Dollars\n" +
                rate + " \tFee Percentage %\n" +
                fee + " \tFee in Dollars\n" +
                netDollars + " \tNet Dollars\n"); 

    }
    //Convert to another method
    public static void DollarsToEuros()  {
        double dollars;
        double eurosPerDollar;
        double grossEuros;
        double fee;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the Dollars to Euros Converter.\n");            
        System.out.print("How many dollars do you want to convert? ");        
        dollars = keyboard.nextDouble();        
        System.out.print("What is the euros-per-dollar exchange rate? ");        
        eurosPerDollar = keyboard.nextDouble();        
        grossEuros = dollars * eurosPerDollar;        
        System.out.println(dollars + " Dollars => " + grossEuros
         + " Gross Euros.");
        System.out.print("\nWhat is the euros-per-dollar Fee Percentage % ? ");        
        double rate = keyboard.nextDouble(); 
        
        
        fee = grossEuros * rate / 100;
        double netEuros = grossEuros - fee;
        
	System.out.println("Thank you for using the Dollars to Euros Converter.\n");
	System.out.println("Please check your Math.\n");	
        System.out.println(dollars + " \tDollars\n " + 
                eurosPerDollar + " \tEuros Per Dollar Exchange Rate\n" +
                grossEuros + " \tGross Euros\n" +
                rate + " \tFee Percentage %\n" +
                fee + " \tFee in Euros\n" +
                netEuros + " \tNet Euros\n");        
    }
    
    //loop the method and call the fucntions
    public static void looping() { 
        int choice = 0;
    
        if (choice ==1)
        {
            EurosToDollars(); //the exchange rate fee is .92
        }
        else if (choice ==2)
        { 
            DollarsToEuros();
        }
        else if (choice ==3)
        {
        System.out.print("Program Terminated");
        }
    }       
}

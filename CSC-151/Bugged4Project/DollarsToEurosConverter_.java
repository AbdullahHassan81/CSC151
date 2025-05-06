package DollarstoEurosConverter;

/*
 * This program...      //Your Block COMMENT Here  ////////////////////////////
 * 
 *
 *
*/


import java.util.Scanner;
public class DollarsToEurosConverter_{
    public static void main(String[] args)
   {    
   }  
        //the euro dollar exchannge rate is 1.0
        //make it a method
     
        
        public static void EurostoDollars()  {
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
}    


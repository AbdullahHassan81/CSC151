import java.util.Scanner;

public class LabProgram {
   public static void main(String[] args) {
      Scanner k = new Scanner(System.in);
      int currentPrice; 
      int lastMonthsPrice; 
    //I used java tutor to help me out
      
     
      currentPrice = k.nextInt();
    

      lastMonthsPrice = k.nextInt();

      double mortgage = (currentPrice * 0.051)/12;

      System.out.print("This house is $" + currentPrice);
      System.out.print(". ");
      System.out.print("The change is $" + (currentPrice - lastMonthsPrice) + " since last month");
      System.out.println(".");
      System.out.print("The estimated monthly mortgage is $" + mortgage);
      System.out.println(".");
   }
}

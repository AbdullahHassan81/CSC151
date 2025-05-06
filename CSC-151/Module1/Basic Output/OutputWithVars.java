import java.util.Scanner; 
//I used java tutor 
//I used AI to find out how to implement exponents in java

public class OutputWithVars {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int userNum;

      System.out.println("Enter integer:");
      userNum = scnr.nextInt();  
      
      System.out.println("You entered: " + userNum);

      //I used AI tutor to do this part 
      int sq = (int) Math.pow(userNum, 2);
      System.out.print(userNum);
      System.out.println(" squared is " + sq);

      //The code below is the previous code to the one up top
      //int sq = userNum ^*2;
      //System.out.print(userNum);
      //System.out.println(" squared is" + sq);
      //sq = scnr.nextInt();

      //Also used Java tutor for this as well
      int cu = (int) Math.pow(userNum, 3); 
      System.out.print("And " + userNum);
      System.out.print(" cubed is " + cu);
      System.out.println("!!");

      //This below is the previous code for the one up top
      //int cu = userNum * userNum; 
      //System.out.print("And " + userNum);
      //System.out.print(" cubed is " + cu);
      //System.out.println("!!");
      //sq = scnr.nextInt();

      int num;
      System.out.println("Enter another integer:");
      num = scnr.nextInt();

      System.out.print(userNum + " + ");
      System.out.print(num + " is ");
      System.out.println(userNum + num);
      
      System.out.print(userNum + " * ");
      System.out.print(num + " is ");
      System.out.println(userNum * num);
   }
}
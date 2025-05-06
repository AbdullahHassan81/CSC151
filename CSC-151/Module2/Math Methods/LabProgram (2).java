import java.util.Scanner;

public class LabProgram {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      //what I did wrong was add a print statement when It was already being printed with the calculations down below
      //System.out.println(" ");
      double x = scnr.nextDouble();
      double y = scnr.nextDouble();
      double z = scnr.nextDouble();
     //used AI Java Tutor to help
     // use Math.pow for exponents 
     // use Math.abs for absolute value
     // use Math.sqrt for square root
      double zax = Math.pow(x, z);
      double combo = Math.pow(x, Math.pow(y, z)); 
      double absoluteY = Math.abs(y);
      double sqrtXY = Math.sqrt(Math.pow(x * y, z));

      System.out.print(zax + " ");
      System.out.print(combo + " ");
      System.out.print(absoluteY + " ");
      System.out.println(sqrtXY);
   }
}

import java.util.Scanner;

public class PeopleWeights {
public static void main(String[] args) {
Scanner scnr = new Scanner(System.in);
final int peopleNum = 5; // amount of people being weighed 
double[] peopleWeight  = new double[peopleNum]; // the array 
int i;
double sumVal; // all elements added together 
double maxVal; // the maximum element
 // tell them to fill the array
 System.out.println("Enter weight 1:");
 System.out.println("Enter weight 2:");
 System.out.println("Enter weight 3:");
 System.out.println("Enter weight 4:");
 System.out.println("Enter weight 5:");
 // printing out what they typed
 System.out.print("You entered: ");
 for (i = 0; i < peopleWeight.length; ++i) {
 peopleWeight[i] = scnr.nextDouble();
 System.out.print( peopleWeight[i] + " ");
 }
 System.out.println(""); // adding all elements together
 sumVal = 0;
 for (i = 0; i < peopleWeight.length; ++i) {
 sumVal = sumVal + peopleWeight[i]  ;
 }
 maxVal = 0; // getting the max value
 for (i = 0; i < peopleWeight.length; ++i) {
 if (peopleWeight[i] > maxVal) {
 maxVal = peopleWeight[i];
 }
 } // the printing format
 System.out.println("");
 System.out.println("Total weight: " + sumVal);
 System.out.print("Average weight: ");
 System.out.println(sumVal / 5); 
 System.out.print("Max weight: ");
 System.out.println(maxVal);
}
}
import java.util.Scanner; 

public class LabProgram {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in); 
      int highwayNumber;
      int primaryNumber;

      highwayNumber = scnr.nextInt();
      //used AI tutor to help me fix somethings up
      //interstate highways 1-99 (odd #'s go north n south)(even #'s go east n west)
      //auxiliary highways 100-999 and are indicated by the rightmost two digits
      // Check if the highway number is in the valid range
      // Check if the highway number is valid (1-999)
      if (highwayNumber >= 1 && highwayNumber <= 999) {
          // Examine if it's a primary highway (1-99)
          if (highwayNumber < 100) {
              if (highwayNumber % 2 == 0) {
                  System.out.println("I-" + highwayNumber + " is primary, going east/west."); 
              } else {
                  System.out.println("I-" + highwayNumber + " is primary, going north/south.");
              }
          } 
          // Examine if it's an auxiliary highway (100-999)
          else if (highwayNumber >= 100 && highwayNumber < 1000) {
              primaryNumber = highwayNumber % 100; // Calculate primary number from auxiliary
              // Check for numbers ending in '00'
              if (primaryNumber == 0) {
                  System.out.println(highwayNumber + " is not a valid interstate highway number.");
              } else {
                  // Decide direction based on original highwayNumber
                  if (highwayNumber % 2 == 0) {
                      System.out.println("I-" + highwayNumber + " is auxiliary, serving I-" + primaryNumber + ", going east/west.");
                  } else {
                      System.out.println("I-" + highwayNumber + " is auxiliary, serving I-" + primaryNumber + ", going north/south.");
                  }
              }
          }
      } else {
          // If it's not in between 1-999, it's not a valid interstate 
          System.out.println(highwayNumber + " is not a valid interstate highway number.");
      }
   }
}

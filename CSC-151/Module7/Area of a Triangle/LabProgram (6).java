import java.util.Scanner;

public class LabProgram {

    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        
        // Declare variables for the lengths of the triangle's sides
        float a, b, c;

        // Prompt user for the lengths of the sides of the triangle
        a = k.nextFloat(); // Length of side a
        b = k.nextFloat(); // Length of side b
        c = k.nextFloat(); // Length of side c

        // Calculate the semi-perimeter of the triangle
        float s = (a + b + c) / 2; // s is half of the perimeter

        // Calculate the area of the triangle using Heron's formula
        float area = (float)Math.sqrt(s * (s - a) * (s - b) * (s - c)); // Heron's formula to calculate area

        // Print the area with two decimal places
        System.out.printf("Triangle area = %.2f\n", area); // Display the area
    }
}
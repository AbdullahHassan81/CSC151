import java.util.Scanner;

public class LabProgram {

    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);

        // Initialize variables for radius and height as doubles
        double radius, height;

        // Prompt user for radius and height
        radius = k.nextDouble(); // Read the radius
        height = k.nextDouble(); // Read the height

        // Calculate volume using the formula: Volume = πr²h
        double volume = Math.PI * Math.pow(radius, 2) * height; // Use Math.pow for r^2

        // Calculate area using the formula: Area = 2πrh + 2πr²
        double area = 2 * Math.PI * radius * height + 2 * Math.PI * Math.pow(radius, 2); // Area calculation

        // Print the volume and area with two decimal places
        System.out.printf("Volume (cubic inches): %.2f\n", volume); // Print calculated volume
        System.out.printf("Surface area (square inches): %.2f\n", area); // Print calculated area
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerRoster {
    public static void main(String[] args) {
        // Create Scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // ArrayLists to store jersey numbers and ratings
        ArrayList<Integer> jerseyNumbers = new ArrayList<>();
        ArrayList<Integer> playerRatings = new ArrayList<>();
        
        // Get 5 jersey numbers and ratings from the user
        System.out.println("Enter 5 player jersey numbers and ratings:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter player " + (i+1) + "'s jersey number: ");
            int jersey = scanner.nextInt();
            System.out.print("Enter player " + (i+1) + "'s rating (1-9): ");
            int rating = scanner.nextInt();
            
            jerseyNumbers.add(jersey);
            playerRatings.add(rating);
        }
        
        // Display the roster
        System.out.println("\nROSTER");
        for (int i = 0; i < jerseyNumbers.size(); i++) {
            System.out.println("Player " + (i+1) + " -- Jersey number: " + jerseyNumbers.get(i) + ", Rating: " + playerRatings.get(i));
        }
        
        // Menu options
        char choice = ' ';
        while (choice != 'q') {
            // Display menu
            System.out.println("\nMENU");
            System.out.println("a - Add player");
            System.out.println("d - Remove player");
            System.out.println("u - Update player rating");
            System.out.println("r - Output players above a rating");
            System.out.println("o - Output roster");
            System.out.println("p - Replace player");
            System.out.println("q - Quit");
            
            System.out.print("\nChoose an option: ");
            choice = scanner.next().charAt(0);
            
            switch (choice) {
                case 'o':
                    // Display the roster
                    System.out.println("\nROSTER");
                    for (int i = 0; i < jerseyNumbers.size(); i++) {
                        System.out.println("Player " + (i+1) + " -- Jersey number: " + jerseyNumbers.get(i) + ", Rating: " + playerRatings.get(i));
                    }
                    break;
                case 'a':
                    // Add a new player
                    System.out.print("Enter new player's jersey number (0-99): ");
                    int jersey = scanner.nextInt();
                    System.out.print("Enter new player's rating (1-9): ");
                    int rating = scanner.nextInt();
                    jerseyNumbers.add(jersey);
                    playerRatings.add(rating);
                    break;
                case 'd':
                    // Remove a player
                    System.out.print("Enter a jersey number: ");
                    int jerseyToRemove = scanner.nextInt();
                    if (jerseyNumbers.contains(jerseyToRemove)) {
                        int index = jerseyNumbers.indexOf(jerseyToRemove);
                        jerseyNumbers.remove(index);
                        playerRatings.remove(index);
                    } else {
                        System.out.println("Player with jersey number " + jerseyToRemove + " not found.");
                    }
                    break;
                case 'u':
                    // Update a player's rating
                    System.out.print("Enter a jersey number: ");
                    int jerseyToUpdate = scanner.nextInt();
                    if (jerseyNumbers.contains(jerseyToUpdate)) {
                        int index = jerseyNumbers.indexOf(jerseyToUpdate);
                        System.out.print("Enter a new rating: ");
                        int newRating = scanner.nextInt();
                        playerRatings.set(index, newRating);
                    } else {
                        System.out.println("Player with jersey number " + jerseyToUpdate + " not found.");
                    }
                    break;
                case 'r':
                    // Display players above a rating
                    System.out.print("Enter a rating: ");
                    int ratingThreshold = scanner.nextInt();
                    System.out.println("\nABOVE " + ratingThreshold);
                    for (int i = 0; i < jerseyNumbers.size(); i++) {
                        if (playerRatings.get(i) > ratingThreshold) {
                            System.out.println("Player " + (i+1) + " -- Jersey number: " + jerseyNumbers.get(i) + ", Rating: " + playerRatings.get(i));
                        }
                    }
                    break;
                case 'p':
                    // Replace a player completely
                    System.out.print("Enter a jersey number for the player to replace: ");
                    int jerseyToReplace = scanner.nextInt();
                    if (jerseyNumbers.contains(jerseyToReplace)) {
                        int index = jerseyNumbers.indexOf(jerseyToReplace);
                        System.out.print("Enter new player's jersey number (0-99): ");
                        int newJersey = scanner.nextInt();
                        System.out.print("Enter new player's rating (1-9): ");
                        int newRating = scanner.nextInt();
                        jerseyNumbers.set(index, newJersey);
                        playerRatings.set(index, newRating);
                    } else {
                        System.out.println("Player with jersey number " + jerseyToReplace + " not found.");
                    }
                    break;
                case 'q':
                    // Quit the program
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        
        scanner.close();
    }
}
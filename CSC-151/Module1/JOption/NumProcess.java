/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.faytechcc.numprocess;

import javax.swing.JOptionPane;

/**
 *
 * @author hassana5237
 */
public class NumProcess {

      /*
     * Processes a string input and attempts to convert it to an integer.
     * This method demonstrates basic input validation and error handling.
     * 
     * Things to consider:
     * 1. What should happen if the user enters nothing?
     * 2. What should happen if the user enters "abc"?
     * 3. What should happen if the user enters "3.14"?
     * 
     * 
     * @param input The string that should be converted to an integer
     */
    

        public static void main(String[] args) {
        //Program will guess the # we are thinking of from 1-100
        //Make an object so we can call our Function
        NumProcess p = new NumProcess();
        
        //Number guessing game
        p.showMessage("This is the Number Guessing Game!");
        p.showMessage("Enter number from 1-100. I won't peek!");
        Integer userNum = p.getInteger();
        Integer guess = 50; //start in the middle
        Integer low =1;
        Integer high = 100;
        Integer feedback; // 1 too high, 2 too low, 3 for just right
        final int TOO_HIGH = 1;
        final int TOO_LOW  = 2;
        final int RIGHT    = 3;
        Boolean keep_playing = true;
        
        //Until Computer guesses right
        while(keep_playing){
            //Have the computer guess
            p.showMessage("Is it " + guess + "?");
            //Find out if its too high, too low or right
            p.showMessage("Enter 1 for too high,2 for too low, 3 if its just right.");
            feedback = p.getInteger();
            //if just right, computer wins
            if (feedback == RIGHT) {
                p.showMessage("Computer Wins!");
                if (guess != userNum){
                    p.showMessage("Wait, you let me win...");
                }
            }
            if (feedback == TOO_HIGH) {
                //next guess is lower
                high = guess;
                guess = (low + high) / 2;
            }
            else if (feedback == TOO_LOW) {
                //next guess is higher
                low = guess; 
                guess =  (low + high) / 2;
            }
            else{
                //user gave bad feedback, cpu quits
                p.showMessage("Thats not 1, 2, 3, so I give up.");
                keep_playing = false;
                return; //game over
            }
        }
    } 
    
    public void showMessage(String message){
        JOptionPane.showMessageDialog(null,message);
    }
    public Integer getInteger(){
        Integer answer = -1; // the number of user types
        while (answer == -1) {
        // process: ask for number, validate it and than move on
        //inputs always a string
        String userInput = JOptionPane.showInputDialog("Enter an integer:");
        //convert it into a number
        answer = this.process(userInput);
        //Show what we did
        if (answer == -1){
            JOptionPane.showMessageDialog(null, "That's not an Integer!");
        }
        else {
            //Debug message
            JOptionPane.showMessageDialog(null, "You enetered: " + answer);
            }
        
        }
        return answer;
    }
    
    public Integer process(String input) {
        //Convert the string into an int
        //exception handling
        Integer number = -1; // or some wrong value
        try {
            number = Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            System.err.println(input + " is not an Integer!");
        }
        return number;
        }

  
    
}
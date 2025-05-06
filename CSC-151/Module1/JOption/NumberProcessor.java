/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.faytechcc.numberprocessor;

/**
 *
 * @author hassana5237
 */
import javax.swing.JOptionPane;
public class NumberProcessor {
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
        edu.faytechcc.numberprocesser2.NumberProcessor processor = new edu.faytechcc.numberprocesser2.NumberProcessor();
        
        // Test Case 1: Ask for a number
        Integer num1 = processor.getInteger();
       
    /**
     *
     * @return
     */
    public Integer getInteger(){
        Integer answer = -1; // the number of user types
        // process: ask for number, validate it and than move on
        //inputs always a string
        String userInput = JOptionPane.showInputDialog("Enter a whole number:");
        
        //convert it into a number
        Integer result = this.process(userInput);
        //Show what we did
        if (result == -1){
            JOptionPane.showMessageDialog(null, "That's not an Integer!");
        }
        else {
            JOptionPane.showMessageDialog(null, result);
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
    

        
        
    



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package edu.faytechcc.jan21test1_hassana;

import javax.swing.JOptionPane;

/**
 *
 * @author hassana5237
 */
public class Jan21test1_hassana 
{

    public static void main(String[] args) 
            //learn how to put stuff in joptionpane
            // and learn how to get stuff off 
            //input() and print() if you python
    {
        //Display welcoming message
        JOptionPane.showMessageDialog(null, "Welcome to Input and Output Demo! ");
        //Ask for name 
        String nickname = JOptionPane.showInputDialog("What should I call you?");
        //Say hey 
        String helloMessage = "Nice To Meet You " + nickname;
        JOptionPane.showMessageDialog(null, helloMessage);
        
    }
}

/* 
copiolt said 

import java.swing.JOptionPane; 

public class Main 
{
    public static void main(String[] args) {
    //Display a welcome message
JOption.showMEssageDialog(null, "Welcome to Generative AI Demo!");

String input = JOprionPane.showInputDialog("Enter a prompt for the AI:");

String aiResponse(input);

JOptionPane.showMessageDialog(null, "'AI Response: " + aiResponse);

return "You said: " + input + ". This is a stimulated AI response.";

*/


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

 package edu.faytechcc.volumeofrectangle;
 import java.util.Scanner;
 
 /**
  *
  * @author hassana5237
  */
 public class VolumeofRectangle {
 
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double volume, length = 0, width = 0, height = 0;
        //find the volume of a rectanlge 
        //volume = length * width * height
        System.out.print("The length is ");
        length = in.nextDouble();
        System.out.print("The width is ");
        width = in.nextDouble();
        System.out.print("The height is ");
        height = in.nextDouble();
        volume = length * width * height;
        System.out.print("The volume of rectangle is ");
        System.out.println(volume);

         //find out what shape the user wants  
         System.out.println("What shape do you want to find the area of? ");
         String shape = in.next();
         //Do the calculations 
         //area = length * width 
        
         //loop it so user can run multiple problems 
         //volume = height * length * width 
         //find the volume of a rectangle
         // use deciscion structures 
     }
 }
 
/**
   * file: driverDFA.java
   * author: Connor Fitzpatrick
   * course: CMPT 440
   * assignment: Final Project
   * due date: May 14, 2020
   * version: 1.3
   * 
   * This file contains the driver  
   * required for running the program
   * through command line terminal
*/


import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class driverDFA {
  public static void main(String[] args) {
    int i = 0; // integer assigned to while loop so that the user can try again
		
    Scanner keyboard = new Scanner(System.in);
		
    // the while loop below allows for the user to either quit the program or retry
	while(i == 0) {
	  BuddySystem m = new BuddySystem();
	  m.reset();
	  m.process();
	  System.out.println();
	  System.out.println("Would you like to restart?");
	  System.out.println("Yes: 0    No: 1");
	  try {
		  i = keyboard.nextInt();
	  } // try()
	  catch (InputMismatchException exception) {
		  System.out.println("");
		  System.out.println("Please enter '0' or '1'");
		  keyboard.next();
      } catch(ArrayIndexOutOfBoundsException ex) {
		System.out.println("");
	    System.out.println("Please enter '0' or '1'");
	  } // catch()
    } // while
  } // main()
} // driverDFA

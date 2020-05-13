/**
   * file: BuddySystem.java
   * author: Connor Fitzpatrick
   * course: CMPT 440
   * assignment: HW 1
   * due date: May 14, 2020
   * version: 1.3
   * 
   * This file contains the all of the  
   * Methods and code for the state transitioning
   * And handling
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class BuddySystem {
  // List of States
	
  static Scanner keyboard = new Scanner(System.in);
	
  private static final int q0 = 0; // Starting state: Is he starting with shots?
  private static final int q1 = 1; // Which drinking game?
  private static final int q2 = 2; // Mean friends?
  private static final int q3 = 3; // Won pong game?
  private static final int q4 = 4; // Got capped?	
  private static final int q5 = 5; // Taken more than four shots?
  private static final int q6 = 6; // Going to bar?
  private static final int q7 = 7; // Many girls at bar?
  private static final int q8 = 8; // 2 A.M. yet?
  private static final int q9 = 9; // Is he dancing with a girl?
  private static final int q10 = 10; // Have he and the girl kissed?
  private static final int q11 = 11; // Has he taken the girl home?
  private static final int q12 = 12; // Is he hungry?
  private static final int q13 = 13; // Has he eaten his food?
  private static final int q14 = 14; // Is he laying on the couch?
  private static final int q15 = 15; // End State: Not blacked out
  private static final int q16 = 16; // End State: Blacked out
  private static final int q17 = 17; // Error state
	
  private static int prevState = 0; // previous state's value 
	
  private static int state; // current state's value
	
  //double array of possible states
  private static int[][] delta = {{q16, q1},   // q0
								  {q2, q3},    // q1
								  {q16, q1},   // q2
								  {q3, q4},    // q3
								  {q16, q5},   // q4
								  {q16, q6},   // q5
								  {q7, q16},   // q6
								  {q8, q16},   // q7
								  {q12, q9},   // q8
								  {q10, q8},   // q9
								  {q11, q8},   // q10
								  {q15, q8},   // q11
								  {q13, q14},  // q12
								  {q15, q14},  // q13
								  {q16, q15},  // q14	
								  {q15, q15},  // q15
								  {q16, q16}}; // q16
	
  // the following method resets the state back to the starting state (q0)
  public static void reset() {
    state = q0;
  } // reset()
	
  // The following method will calls the interview method to ask a question. process() then
  // records the user's response and transitions into a new state depending on the response given
  static void process() {
	// while not in end state
    while(state != q15 && state != q16) {
	  interview();
	  try {
		int num = keyboard.nextInt();
	    state = delta[state][num];
	  } // try()
	  catch (InputMismatchException exception) {
		  System.out.println("");
		  System.out.println("Please enter '0' or '1'");
		  keyboard.next();
      }
	  catch(ArrayIndexOutOfBoundsException ex) {
		System.out.println("");
	    System.out.println("Please enter '0' or '1'");
	  } // catch()
	} // while()
    // interview is called again to display result once end state is reached
	interview();
  } // process()
	
  // The following method displays questions or responses to the user depending
  // on the current state via switch statement
  public static void interview() {
    switch(state) {
	case 0: 
	  System.out.println();
	  System.out.println("Is his first drink of the night a shot?");
	  System.out.println("Yes: 0    No: 1");
	  prevState = 0;
	  break;
	case 1: 
	  System.out.println();
	  System.out.println("It is game time!");
	  System.out.println("Is he playing stack cup or pong?");
	  System.out.println("Stack cup: 0    Pong: 1");
	  prevState = 1;
	  break;
	case 2: 
	  System.out.println();
	  System.out.println("Are his friends teaming up on him?");
	  System.out.println("Yes: 0    No: 1");
	  prevState = 2;
	  break;
	case 3: 
	  System.out.println();
	  // if statement's purpose is to avoid asking the user the same question
	  // if this state is revisited
	  if (prevState == 1) {
	    System.out.println("He's never said no to a game of beer pong!");
		System.out.println("Did he win?");
	  } // if()
	  else {
		System.out.println("Did he win again?");
	  } // else()
	  System.out.println("Yes: 0    No: 1");
	  prevState = 3;
	  break;
	case 4: 
	  System.out.println();
	  System.out.println("Sounds like its time for everyone to go to the bar");
	  System.out.println("Was he forced to chug?");
	  System.out.println("Yes: 0    No: 1");
	  prevState = 4;
	  break;
	case 5: 
	  System.out.println();
	  System.out.println("Has he taken more than four shots?");
	  System.out.println("Yes: 0    No: 1");
	  prevState = 5;
	  break;
	case 6: 
	  System.out.println();
	  System.out.println("Is he going to the bar?");
	  System.out.println("Yes: 0    No: 1");
	  prevState = 6;
	  break;
    case 7: 
	  System.out.println();
	  System.out.println("Are there many girls in the bar?");
	  System.out.println("Yes: 0    No: 1");
	  prevState = 7;
	  break;
	case 8: 
	  System.out.println();
	  System.out.println("Is it 2 A.M. yet?");
	  System.out.println("Yes: 0    No: 1");
	  prevState = 8;
	  break;
	case 9: 
	  System.out.println();
	  System.out.println("Is he dancing with a girl?");
	  System.out.println("Yes: 0    No: 1");
	  prevState = 9;
	  break;
	case 10: 
	  System.out.println();
	  System.out.println("Did he manage to get a kiss?");
	  System.out.println("Yes: 0    No: 1");
	  prevState = 10;
   	  break;
	case 11: 
	  System.out.println();
	  System.out.println("Did he manage to take her home?");
	  System.out.println("Yes: 0    No: 1");
	  prevState = 11;
	  break;
	case 12: 
	  System.out.println();
	  System.out.println("After a fun night, its time to leave the bar.");
	  System.out.println("Is he hungry?");
	  System.out.println("Yes: 0    No: 1");
	  prevState = 12;
	  break;
	case 13: 
	  System.out.println();
	  System.out.println("Time for some McDonalds!");
	  System.out.println("Is he eating the meal that he bought?");
	  System.out.println("Yes: 0    No: 1");
	  prevState = 13;
	  break;
    case 14: 
	  System.out.println();
	  System.out.println("Home at last!");
	  System.out.println("Is he laying on couch instead of going to bed?");
	  System.out.println("Yes: 0    No: 1");
	  prevState = 14;
	  break;
	case 15: 
	  System.out.println();
	  System.out.println("He has survived his night out!");
	  System.out.println(":)");
	  break;
    case 16: 
	  System.out.println();
	  // if else statements are meant to provide the user with an explanation as to
	  // why this state(q16) was reached since this one is negative for the user and should
	  // be avoided
	  if(prevState == 0) {
	    System.out.println("Shots are never a smart way for him to start the night");
	  } // if()
	  else if (prevState == 2) {
		System.out.println("Wow he really does have the worst friends");
	  } // else if()
	  else if (prevState == 4) {
		System.out.println("Him getting capped is never a good sign.");
	  } // else if()
	  else if (prevState == 5) {
		System.out.println("More than four shots? That never ends well!");
	  } // else if()
	  else if (prevState == 6) {
		System.out.println("He never misses the bar! Something must be wrong!");
	  } // else if()
	  else if (prevState == 7) {
	    System.out.println("I don't know why, but for some reason he always");
		System.out.println("gets sick in the bar when few girls are around.");
	  } // else if()
	  else if(prevState == 13) {
		System.out.println("He's too sick or slumped to eat at the moment.");
	  } // else if()
	  else if (prevState == 14) {
		System.out.println("He always gets sick on that couch for some reason.");
	  } // else if()
	  System.out.println();
	  System.out.println("He is blacked out :(");
	  break;
	} // switch()
  } // interview()
} // SaturdayNight

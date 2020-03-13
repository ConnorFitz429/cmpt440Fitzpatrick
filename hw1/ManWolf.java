/**
   * file: ManWolf.java
   * author: Connor Fitzpatrick
   * course: CMPT 440
   * assignment: HW 1
   * due date: March 13, 2020
   * version: 1.3
   * 
   * This file contains the all of the  
   * Methods and code for the state transitioning
   * And handling
*/


public class ManWolf {
	
   // list of states
   private static final int q0 = 0;
   private static final int q1 = 1;
   private static final int q2 = 2;
   private static final int q3 = 3;
   private static final int q4 = 4;
   private static final int q5 = 5;
   private static final int q6 = 6;
   private static final int q7 = 7;
   private static final int q8 = 8;
   private static final int q9 = 9;
   private static final int q10 = 10;
	
   private static int state;
	
   // double array of possible states depending on what man moves
   // Order: nothing, wolf, goat, crops
   static private int[][] delta = {{q10, q10, q1, q10},
								   {q2, q10, q0, q10},
								   {q1, q3, q10, q5},
								   {q10, q2, q4, q10},
								   {q10, q10, q3, q7},
								   {q10, q10, q6, q2},
								   {q10, q7, q5, q10},
								   {q8, q6, q10, q4},
								   {q7, q10, q9, q10},
								   {q10, q10, q8, q10},
								   {q10, q10, q10, q10}};
  
   // Following method returns current state to starting state
   public void reset() {
      state = q0;
   } // reset()
	
   
   /* Return value: a boolean, to know whether
    * or not the inputted string was accepted. */
   public boolean accepted() {
      return state == q9;
   } // accepted()
	
   
   
   /* Return value: a calculated char, to know what
    * state in the x axis applies for the string's letter */
   public static char toInt(char c) {
      if(c == 'n') {
	     c = '0';
	  } // if()
	  else if(c == 'w') {
		 c = '1';
	  } // else if()
	  else if(c == 'g') {
		 c = '2';
	  } // else if()
	  else if(c == 'c') {
		 c = '3';
	  } // else if()
	  else {
	     c = '4';
	  } // else()
	  return c;
   } // toInt()

   
   
   // Following method will take the string and switch from transition state to
   // transition state depending on which letter is being looked at
   static void process(String in) {
      for(int i = 0; i < in.length(); i++) {
	     char c = in.charAt(i);
	     c = toInt(c);
	     // try to change to the state that is in following location in delta double array
	     try {
	        state = delta[state][c- '0'];
         } // try()
	     catch(ArrayIndexOutOfBoundsException ex) {
		    state = q10;
	     } // catch()
	  } // for()
   } // process()
} // ManWolf	

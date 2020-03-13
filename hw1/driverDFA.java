/**
   * file: driverDFA.java
   * author: Connor Fitzpatrick
   * course: CMPT 440
   * assignment: HW 1
   * due date: March 13, 2020
   * version: 1.3
   * 
   * This file contains the driver  
   * required for running the program
   * through command line terminal
*/

import java.io.*;

public class driverDFA {
   public static void main(String[] args) throws IOException {
      ManWolf m = new ManWolf();
//	  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//	  String s = in.readLine();
	  String s = args[0];
		
	  m.reset();
      m.process(s);
	  if(m.accepted()) {
	     System.out.println(s + " is a solution!");
	  } else {
	     System.out.println(s + " is not a solution");
	  } // else()
   } // main()
} // driverDFA

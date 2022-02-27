package squarerootproject;
import java.util.Scanner;

/**
 * Solves the square root of any user entered number
 * without the use of the math methods
 * 
 * @author Cameron Smith (camerons03)
 * @version 2022.02.26
 */
public class SquareRootSolver {
  private static final double MIN = 0.0000000000001;
  private static double num;
  
  /**
   * Main method that runs the program
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("Welcome to the Square Root Solver!"
      + "\nPlease enter the number you would like to find the square root of: ");
    
    Scanner scan = new Scanner(System.in);
    String numCheck = scan.nextLine().replaceAll(" ", "");
    
    while (isNumeric(numCheck)) { // in case user does not enter a number
      System.out.println("That is not a number!"
        + "\nPlease enter a valid number.\n");
      numCheck = scan.nextLine().replaceAll(" ", "");
    }// end while loop
    
    scan.close();
    num = Double.parseDouble(numCheck);
    double squareRoot = 2.0; // square root of the number
    double prevIndex = 0;// previous squareRoot value to be stored
    double iterate = 1.0; // iteration value of the squareRoot number
    double squared = 0; // squareRoot times itself 
    
    while (iterate > MIN) {
      squared = squareRoot * squareRoot;
      if (squared > num) {
        squareRoot = prevIndex;
        iterate /= 10;
      }
      prevIndex = squareRoot;
      squareRoot += iterate;
    }// end while
    
    System.out.println("The square root is - " + squareRoot);
  }// end method
  
  /**
   * Checks to see if the passed through string is a number
   * 
   * @param str
   *            scanned user input
   * @return boolean
   */
  public static boolean isNumeric(String str) {
    try {
      Integer.parseInt(str);
      return false;
    } catch (NumberFormatException e) {
      return true;
    }
  }
}

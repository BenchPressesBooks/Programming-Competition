import java.util.*;

public class math{

	/*
	 *	Numeric Functions
	 */
	 
 	// Factorial
	public int factorial (int n){
		if(n <= 1){
			return 1;
		} else {
			return n * factorial(n-1);
		}

	// Summation of a given number
	public int summation (int n){
		int rsum = 0;
		for(int i = 0; i <= n; i++){
			rsum += i;
		}
		return rsum;
	}
	
	// Random number generator
	public int random(){
		Random rnd = new Random();
		return rnd.nextInt();
	}	
	
	// Random number generator with a minimum and maximum bound.
	public int random(int min, int max){
		Random rnd = new Random();
		return min+(int)(rnd.nextInt()*((max-min) + 1));
	}

	/*
	 *	Conditional Functions
	 */
	
	// Even and odd.
	public String evenOrOdd(int n){
		int c = n%2;
		
		if(c = 1){
			return "odd";
		} else {
			return "even";
		}
	

	/*
	 *	Boolean Functions
	 */

	// Checks if a given number is a perfect square.
	public final static boolean isPerfectSquare(double n) {		
		if (n < 0){
			return false;
		}
  		long tst = (long)(Math.sqrt(n));
  		return tst*tst == n;
	}
	
	// Checks if the given number is a prime number.
	public static boolean isPrime(int n) {
		int c;
		for (c = 2; c < n; c++) {
			if (n % c == 0) {
			return false;
			}  
		}
		return true;
	}
}

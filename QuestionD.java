import java.util.*;
import static java.lang.System.out;

public class QuestionD{

	private static QuestionD qd = new QuestionD();
	private static Scanner r = new Scanner(System.in);

	public int solutionCounter = 0;
	public int cases = 1;
	private int min;
	private int max;

	public static void main(String[] args) {
		
		r.useDelimiter("\\s+");
		
		while(r.hasNextLine()) {
		
			String input = r.nextLine();
			String[] elements = input.split(" ");
			
			qd.QuestionD(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
			
			if(qd.min == 0 && qd.max == 0){
				break;
			} else {
				if(qd.cases != 1)
					print("\n");

				qd.numElementsAdded(qd.min);
				
				print("Case " + qd.cases + ": " + qd.solutionCounter);
				qd.solutionCounter = 0;
				qd.cases++;
			}
		}
	}
	
	// Constructor for input
	public void QuestionD(int min, int max){
		qd.min = min;
		qd.max = max;
	}
	
	// Helper function to get the number of elements to be added to the correct amount
	public void numElementsAdded(int lowerBound) {
		int rackSize = 1; // sets initial rack size to be just one ball
		int numElementsAdded = 2; // initial number of elements to be added
				
		while((numElementsAdded + rackSize) < lowerBound) {
			rackSize += numElementsAdded;
			numElementsAdded++;
		}
		
		poolSquare(qd.min, qd.max, numElementsAdded);
	}
	
	// Function that computes all of the solutions
	public int poolSquare(int lowerBound, int upperBound, int numElementsAdded) {
		
		for(int numElementsRack = lowerBound + 1; numElementsRack < upperBound; numElementsAdded++) {
			
			if(isPerfectSquare(numElementsRack)) {
				qd.solutionCounter++;
				numElementsRack += numElementsAdded;
			}
			else {
				numElementsRack += numElementsAdded;
			}
		}
		
		return qd.solutionCounter;
	}
	
	// Checks if a given number is a perfect square.
	public final static boolean isPerfectSquare(double n) {		
		if (n < 0){
			return false;
		}
  		long tst = (long)(Math.sqrt(n));
  		return tst*tst == n;
	}
	
	public static void print(Object o){
		out.print(o);
	}
	
	public static void println(Object o){
		out.println(o);
	}	
}

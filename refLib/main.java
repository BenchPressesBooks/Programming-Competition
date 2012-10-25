import java.util.*;


public class test{

	public static int ZERO = 0;
	public static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args) {
		test ts = new test();
		
		println("Summation of " + args[0] + " is " + ts.sum(Integer.parseInt(args[0])));
		
		print("The random number of the day is: " + (rnd.nextInt(9)+1) + "\n\n");
		
		outsideTest ot = new outsideTest();
		
		while(true){
			print("What number do you want to check for a perfect square? ");
			if(ot.isPerfectSquare(reader.nextLong()) == true){
				println("IT IS!");
			} else {
				println("Nope, not a chance.");		
			}
		}
	}
	
	public int numElementsRack = 3; // number of elements in the rack (not including cue)
	public int solutionCounter = ZERO; // number of viable solutions
	
	// Helper function to get the number of elements to be added to the correct amount
	public int numElementsAdded(int lowerBound]) {
		int rackSize = 1; // sets initial rack size to be just one ball
		int numElementsAdded = 2; // initial number of elements to be added
		while((numElementsAdded + rackSize) < lowerBound) {
			numElementsAdded++;
			rackSize += numElementsAdded;
		}
		return numElementsAdded;
	}
	
	// Function that computes all of the solutions
	public int poolSquare(int lowerBound, int upperBound, int numElementsAdded) {
		int lowerBound = args[0];
		int upperBound = args[1];
		
		for(int numElementsRack = lowerBound; (numElementsRack + 1) < upperBound; numElementsAdded++) {
			if((numElementsRack + 1).isSquareNumber()) {
				solutionCounter++;
				numElementsRack += numElementsAdded;
			}
			else {
				numElementsRack += numElementsAdded;
			}
		}
		
		return solutionCounter;
	}

	public double sum (int input){
		
		int rsum = ZERO;
		for(int i = ZERO; i <= input; i++){
			rsum += i;
			
		}
		return (double)rsum;
	}
	
	

}

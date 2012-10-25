import java.util.*;
//Change
public class QuestionD{

	public static int start = 2;
	public int numElementsRack = 3; // number of elements in the rack (not including cue)
	public int solutionCounter = ZERO; // number of viable solutions
	public int min;
	public int max;

	public static void main(String[] args) {
		while(args[0] != 0 && args[1] ! = 0) {
			min = args[0];
			max = args[1];

		for(; start < max; start++){
			
		}
	}
	
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

	public int sum (int input){
		int rsum = 0;
		for(int i = 0; i <= input; i++){
			rsum += i;
		}
		return rsum;
	}
}

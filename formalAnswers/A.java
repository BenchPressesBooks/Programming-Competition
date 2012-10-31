
import java.util.*;
import java.io.*;

public class A {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		for(int caseIndex = 0;; caseIndex++) {
			int bits = input.nextInt();
			if(bits == 0)
				break;
			String s = input.next();
			String t = input.next();
			int[] S = new int[bits];
			int[] T = new int[bits];

			long[] tax = new long[bits];
			input.nextLine();

			// Read in taxes.
			for(int i = 0; i < bits; i++) {
				tax[i] = input.nextInt();
			}
			input.nextLine();

			int b10 = 0; // Number of bits starting at 1, ending at 0.
			int b01 = 0; // 			    0, ending at 1.
			int b11 = 0; // 			    1, ending at 1.

			// Convert s and t to an array of 0's & 1's.
			for(int i = bits-1; i >= 0; i--) {
				S[i] = s.charAt(i) -'0';
				T[i] = t.charAt(i) - '0';
				if(S[i] == 1 && T[i] == 0) b10++;
				if(S[i] == 0 && T[i] == 1) b01++;
				if(S[i] == 1 && T[i] == 1) b11++;
			}

			long[] A10 = new long[b10]; // Taxes on bits going from 1 to 0.
			long[] A01 = new long[b01]; //			       0 to 1.
			long[] A11 = new long[b11]; //			       1 to 1.

			for(int i = 0; i < bits; i++) {
				if(S[i] == 1 && T[i] == 0) {
					b10--;
					A10[b10] = tax[i];
				}
				if(S[i] == 0 && T[i] == 1) {
					b01--;
					A01[b01] = tax[i];
				}
				if(S[i] == 1 && T[i] == 1) {
					b11--;
					A11[b11] = tax[i];
				}
			}

			// Bubble sort by tax value (non-increasing)
			sort(A10);
			sort(A01);
			sort(A11);

			// Keep track of cheapest solution found yet.
			long bestTotalCost = 0;

			// Initialize to trivial upper bound.
			for(int i = 0; i < bits; i++) {
				bestTotalCost += tax[i]*bits;
			}

			// Try all possible prefixes of A11 (length of i).
			for(int i = 0; i <= A11.length; i++) {
				long totalCost = 0;	// Cost for proposed trip.
				long currCost = 0;	// Cost of next hop.
				for(int j = 0; j < A10.length; j++) {
					currCost += A10[j];
				}
				for(int j = 0; j < A11.length; j++) {
					currCost += A11[j];
				}
				// Current cost includes all taxes for the starting node.

				// Track progress for each type of bit.
				int pos10 = 0; 
				int pos11 = 0;
				int pos01 = 0;

				// Turn off all bits in A10 and the first i of A11,
				// merge-sort style, picking the most expensive to 
				// turn off first.
				for(int j = 0; j < A10.length + i; j++) {
					if(pos11 == i) {
						currCost -= A10[pos10];
						pos10++;
					}
					else if(pos10 == A10.length) {
						currCost -= A11[pos11];
						pos11++;
					}
					else if(A10[pos10] > A11[pos11]) {
						currCost -= A10[pos10];
						pos10++;
					}
					else {
						currCost -= A11[pos11];
						pos11++;
					}
					totalCost += currCost;	
				}

				// Turn on all bits in A01 and the first i of A11,
				// merge-sort style, picking the cheapest to turn
				// on first.
				pos01 = A01.length-1;
				pos11 = i-1;
				for(int j = 0; j < A01.length + i; j++) {
					if(pos11 < 0) {
						currCost += A01[pos01];
						pos01--;
					}
					else if(pos01 < 0) {
						currCost += A11[pos11];
						pos11--;
					}
					else if(A01[pos01] > A11[pos11]) {
						currCost += A11[pos11];
						pos11--;
					}
					else {
						currCost += A01[pos01];
						pos01--;
					}
					totalCost += currCost;
				}
				if(bestTotalCost > totalCost) {
					bestTotalCost = totalCost;
				}
			}
			System.out.println("Case "+(caseIndex+1) + ": "+bestTotalCost);
		}
	}

	public static void sort(long[] A) {

		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A.length-1; j++) {
				if(A[j] < A[j+1]) {
					long temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
			}
		}
	}
}

import java.util.*;
import static java.lang.System.out;

public class test{

	public static int ZERO = 0;
	public static Scanner reader = new Scanner(System.in);
	public static Random rnd = new Random();
	
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

	public double sum (int input){
		
		int rsum = ZERO;
		for(int i = ZERO; i <= input; i++){
			rsum += i;
			
		}
		return (double)rsum;
	}
	
	
	public static void print(Object o){
		out.print(o);
	}
	
	public static void println(Object o){
		out.println(o);
	}
}

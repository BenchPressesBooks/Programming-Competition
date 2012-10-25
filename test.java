import java.util.*;

public class test{

    public static void main(String[] args) {
        
        test test = new test();

        System.out.println("Summation of " + args[0] + " is " + test.sum(Integer.parseInt(args[0])));
    }

	public int sum (int input){
	    int rsum = 0;
	    	for(int i = 0; i <= input; i++){
                rsum += i;
            }
        return rsum;
	}

}

import java.util.*;
import static java.lang.System.out;

public class outsideTest{

	public final static boolean isPerfectSquare(long n)
	{		
		if (n < 0)
			return false;

  		long tst = (long)(Math.sqrt(n));
  		//Optional method:		long tst = (long)(Math.sqrt(n) + 0.5);
  		
  		return tst*tst == n;
	}
}

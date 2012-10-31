import java.util.*;
import static java.lang.Math.*;

public class D {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		for(int zz=1;;zz++){
			long A = in.nextLong();
			long B = in.nextLong();
			if(A == 0 && B == 0)
				break;
			HashSet<Long> sq = new HashSet<Long>();
			for(long i = 1; i*i <= 2*B; i++)
				sq.add(i*i);
			long sum = 0;
			long ans = 0;
			for(long i = 0; sum <= 2*B; i++){
				sum += i;
				if(sq.contains(sum+1) && A < sum+1 && sum+1 < B){
					ans++;
				}
			}
			System.out.format("Case %d: %d\n", zz, ans);
		}
	}
}

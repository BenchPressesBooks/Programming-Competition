import java.util.*;
import static java.lang.Math.*;
import java.io.*;

public class C {
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		int icase=0;
		for(int zz=1;;zz++){
			icase++;
			B = in.nextInt();
			C = in.nextInt();
			if(B == 0 && C == 0)
				break;
			O = new int[B][C];
			for(int i = 0; i < B;i++){
				for(int j = 0; j < C;j++){
					O[i][in.nextInt()] = j;
				}
			}
			ArrayList<Integer> P = new ArrayList<Integer>();
			for(int i = 0; i < C;i++)
				P.add(i);
			while(P.size() >= 2){
				int a = P.get(0);
				int b = P.get(1);
				int cmp = compare(a, b);
				if(cmp > 0){
					P.remove(1);
				}else if(cmp < 0){
					P.remove(0);
				}
			}
			int cand = P.get(0);
			boolean valid = true;
			for(int i = 0; i < C; i++){
				if(cand == i)
					continue;
				if(compare(cand, i) < 0){
					valid = false;
					break;
				}
			}
			if(valid){
				System.out.println("Case " + icase + ": " + cand);
			}else{
				System.out.println("Case " + icase + ": No Condorcet winner");
			}
		}
	}
	static int B, C;
	static int[][] O;
	private static int compare(int a, int b) {
		int cnt = 0;
		for(int i = 0; i < B;i++){
			if(O[i][a] < O[i][b])
				cnt++;
			else
				cnt--;
		}
		if(cnt == 0){
			cnt = -1;
		}
		return (int) signum(cnt);
	}
}

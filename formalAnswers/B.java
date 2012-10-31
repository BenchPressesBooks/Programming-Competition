import java.util.*;
import static java.lang.Math.*;

public class B {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		for(int zz = 1;;zz++){
			int S = in.nextInt();
			int C = in.nextInt();
			int P = in.nextInt();
			int L = in.nextInt();
			if(S == 0 && C == 0 && P == 0 && L == 0)
				break;

			int sat = 0;
			int cat = 0;
			boolean[][] V = new boolean[S][C];
			int steps = 0;
			while(true){
				if(V[sat][cat])
					break;
				V[sat][cat] = true;
				if(sat == P && cat == L)
					break;
				sat -= 1;
				if(sat < 0)
					sat += S;
				cat -= 1;
				if(cat < 0)
					cat += C;
				steps++;
			}
			if(V[P][L])
				print(zz, steps/S, steps%S, S);
			else
				System.out.format("Case %d: Never\n", zz);
		}
	}
	private static void print(int zz, int r, int m, int s) {
		System.out.format("Case %d:", zz);
//		if(r != 0)
			System.out.format(" %d", r);
//		if(m != 0)
			System.out.format(" %d/%d", m, s);
		System.out.println();
	}
}

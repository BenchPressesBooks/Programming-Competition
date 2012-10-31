import java.util.*;
import static java.lang.Math.*;

public class F {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		for(int zz=1; ;zz++){
			N = in.nextInt();
			if(N == 0)
				break;
			D = new long[N][N];
			C = new long[N][N];
			for(int i = 0; i < N;i++){
				for(int j = 0; j < N; j++){
					D[i][j] = in.nextInt();
					if(D[i][j] == 0){
						D[i][j] = Integer.MAX_VALUE;
					}else{
						C[i][j] = D[i][j];
					}
				}
				D[i][i] = 0;
			}
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N;j++)
					for(int k = 0; k < N;k++)
						D[j][k] = min(D[j][k], D[j][i] + D[i][k]);
			M = in.nextInt();
			int[] P = new int[M];
			for(int i = 0; i < M;i++)
				P[i] = in.nextInt();
			int at = 0;
			int ans = 0;
			while(true){
				int st = P[at];
				while(at < M-1 && D[st][P[at]] + C[P[at]][P[at+1]] == D[st][P[at+1]])
					at++;
				if(at != M-1){
					ans++;
					at++;
				}
				if(at == M-1)
					break;
			}
			System.out.format("Case %d: %d\n", zz, ans);
		}
	}
	static int N, M;
	static long[][] D, C;
}

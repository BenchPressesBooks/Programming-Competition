import java.awt.geom.Line2D;
import java.util.*;
import static java.lang.Math.*;

public class I {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		for(int zz=1;;zz++){
			double x1 = in.nextDouble();
			double y1 = in.nextDouble();
			double x2 = in.nextDouble();
			double y2 = in.nextDouble();
			if(x1 == 0 && y1 == 0 && x2 == 0 && y2 == 0)
				break;
			
			double wx1 = in.nextDouble();
			double wy1 = in.nextDouble();
			double wx2 = in.nextDouble();
			double wy2 = in.nextDouble();
			
			if(wy1 == wy2){
				double t = x1;
				x1 = y1;
				y1 = t;
				
				t = x2;
				x2 = y2;
				y2 = t;
				
				t = wx1;
				wx1 = wy1;
				wy1 = t;
				
				t = wx2;
				wx2 = wy2;
				wy2 = t;
			}
			double intery = y1-(y1-y2)/(x1-x2)*(x1-wx1);
			double ans;
			boolean inter = (min(wy1, wy2) - eps <= intery && intery <= max(wy1, wy2)+eps);
			inter &= signum(x1-wx1) == -signum(x2-wx2);
			if(inter){
				ans = min(hypot(x1-wx1,y1-wy1)+hypot(x2-wx1,y2-wy1), hypot(x1-wx2,y1-wy2)+hypot(x2-wx2,y2-wy2));
			}else{
				ans = hypot(x1-x2, y1-y2);
			}
			System.out.format("Case %d: %.03f\n", zz, ans/2);
		}
	}
	static double eps = 1e-9;
}

package d15;

import java.util.*;
import java.math.*;

public class Lines {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Coords[] points = new Coords[N];
		
		for (int i=0; i<N; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			points[i] = new Coords(x, y);
		}
		
        Set<BigDecimal> set = new HashSet<BigDecimal>(); 
		int vert = 0;
        
		for (int i=0; i<N; i++){
			for (int j=i+1; j<N; j++){
				if (points[i].x==points[j].x){//undefined slope
					vert = 1;
					continue;
				}
				BigDecimal num = new BigDecimal(points[i].y-points[j].y);
				BigDecimal denom = new BigDecimal(points[i].x-points[j].x);
				BigDecimal slope = num.divide(denom, 2, RoundingMode.HALF_UP);
				set.add(slope);
			}
		}
		System.out.println(vert+set.size());
		sc.close();
	}
	
	static class Coords{
		int x, y;
		int flip = 0;
		Coords(int x1, int y1){
			x = x1;
			y = y1;
		}
	}

}

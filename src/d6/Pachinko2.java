package d6;

import java.util.*;

public class Pachinko2 {
	static int[][] mat;
	static boolean[][] found;
	static int[][] val;
	static int R;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		mat = new int[R][R];
		found = new boolean[R][R];
		val = new int[R][R];
		for (int i=0; i<R; i++){
			for (int j=0; j<=i; j++){
				mat[i][j] = sc.nextInt();
			}
		}
//		System.out.println(f(0,0));
		System.out.println(f2());
		sc.close();
		}
	static int f(int y, int x)
	{
	  if (y == R){
		  return 0;
	  }
	  if (!found[y][x])
	  {
	    val[y][x] = mat[y][x] + Math.max(f(y+1,x), f(y+1,x+1));
	    found[y][x] = true;
	  }
	  return val[y][x];
	}
	
	static int f2()	{
	  for (int i = R-1; i >= 0; i--){
		  for (int j = 0; j <= i; j++){
			  if (j==0){
				  val[i][j] = mat[i][j] + val[i-1][j];
			  }else if(j==i){
				  val[i][j] = mat[i][j] + val[i-1][j-1];
			  }else{
				  val[i][j] = mat[i][j] + Math.max(val[i-1][j], val[i-1][j-1]);
			  }
		  }
	  }
	  return val[0][0];
	}
}

package d9;

import java.util.*;

public class Landscape {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int Z = sc.nextInt();
		
		int al = 0, bl = 0;
		int[] a = new int[1001];
		int[] b = new int[1001];
		
		for (int i=0; i<N; i++){
			int s = sc.nextInt();
			int e = sc.nextInt();
			for (int j=0; j<s; j++){
				al++;
				a[al] = i;
			}
			for (int j=0; j<e; j++){
				bl++;
				b[bl] = i;
			}
		}
		
		int[][] dp = new int[al+1][bl+1];		
		dp[0][0] = 0;
		
		for (int i=0; i<=al; i++){
			for (int j=0; j<=bl; j++){
				if (i==0){
					dp[0][j] = j*X;
					continue;
				}
				if (j==0){
					dp[i][0] = i*Y;
					continue;
				}
				dp[i][j] = Math.min(dp[i][j-1]+X, Math.min(dp[i-1][j]+Y, dp[i-1][j-1]+Z*(Math.abs(a[i]-b[j]))));
			}
		}
		System.out.println(dp[al][bl]);
		sc.close();
	}

}

package d8;

import java.util.*;

public class Knapsack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		int[] size = new int[N+1];
		int[] value = new int[N+1];
		for (int i=1; i<=N; i++){
			int s = sc.nextInt();
			int v = sc.nextInt();
			size[i] = s;
			value[i] = v;
		}
		
		int[][] dp = new int[C+1][N+1];
		dp[size[1]][1] = value[1];
		
		for (int j=2; j<=N; j++) {
			for (int i=1; i<=C; i++) {
				dp[i][j] = dp[i][j-1];//same as before
				if (i-size[j]>=0){
					dp[i][j] = Math.max(dp[i][j], dp[i-size[j]][j-1] + value[j]);//new
				}
				dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
			}
		}
		System.out.println(dp[C][N]);
		sc.close();
		
		
	}

}

package d7;

import java.util.*;

public class Subset {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp(N);
		sc.close();
	}
	
	public static void dp(int N){
		if (N*(N+1)/2 % 2 == 1) {//odd
			System.out.println(0);
			return;
		}
		long[][] dp = new long[40][800];
		dp[0][0] = 1;
		for (int i=1; i<=N; i++) {
			for (int j=0; j<=i*(i+1)/2; j++) {
				dp[i][j] = dp[i-1][j];//old
				if (j-i > 0){//new
					dp[i][j]+= dp[i-1][j-i];
				}
				if (i==j){
					dp[i][j]++;
				}
			}
		}
		System.out.println(dp[N][N*(N+1)/4]/2);
		
	}

}

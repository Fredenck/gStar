package d10;

import java.util.*;

public class Egroup {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] pos = new int[N+1];
		for (int i=0; i<N; i++){
			pos[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N+1][4];
		for (int i=0; i<=N; i++) {
			for (int j = 0; j<4; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i=0; i<4; i++) {
			dp[0][i] = 0;
		}
		for (int i=1; i<=N; i++){
			for (int j=1; j<=3; j++){
				int t = 1;
				if (pos[i-1] == j){
					t = 0;
				}
				for (int k = 1; k <= j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + t);
				}
			}
		}
		int incr = Integer.MAX_VALUE;
		for (int i=1; i<4; i++) {
			incr = Math.min(incr, dp[N][i]);
		}
		
		for (int i=0; i<N; i++){
			pos[i] = 4-pos[i];
		}

		for (int i=0; i<=N; i++) {
			for (int j = 0; j<=3; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i=0; i<=3; i++) {
			dp[0][i] = 0;
		}
		
		for (int i=1; i<=N; i++){
			for (int j=1; j<=3; j++){
				int t = (pos[i - 1] == j) ? 0 : 1;
				for (int k = 1; k <= j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + t);
				}
			}
		}
		int decr = Integer.MAX_VALUE;
		for (int i=1; i<4; i++) {
			decr = Math.min(decr, dp[N][i]);
		}
		
		System.out.println(Math.min(incr,  decr));
		sc.close();
	}

}

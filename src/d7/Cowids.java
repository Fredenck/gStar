package d7;

import java.util.*;

public class Cowids {
	static int[][] dp;
	static boolean leadingZ = true;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		dp = new int[11][5001];
		
		if (K==1){
			System.out.print("1");
			for(int i=0; i<N; i++){
				System.out.print("0");
			}
			System.out.println();
		}else{
			dp[0][1] = 1;
			for (int i=1; i<5001; i++){
				for (int j=0; j<11; j++){
					if (j==0){
						dp[j][i] = 1;
					}else{
						dp[j][i] = dp[j-1][i-1]+dp[j][i-1];//append 1 and 0
					}
					if (dp[j][i] > 10000000){
						dp[j][i] = 10000000; 
					}
				}
			}
			
			convert(N, K, 5000);
			System.out.println();
		}
		sc.close();
		
	}

	private static void convert(int n, int k, int i) {
		if (i==1 && k==0){
			return;
		}
		if (k==0 ||  dp[k][i-1]>=n){
			if (!leadingZ){
				System.out.print("0");
			}
			convert(n, k, i-1);
		}else{
			leadingZ = false;
			System.out.print("1");
			convert(n-dp[k][i-1], k-1, i-1);
		}
		
	}
}

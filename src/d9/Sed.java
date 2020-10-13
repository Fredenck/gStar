package d9;

import java.util.*;

public class Sed {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		int min = Integer.MAX_VALUE;
		
		for (int i=0; i<=c1.length; i++){
			for (int j=0; j<=c2.length; j++){
				if(i==0 || j==0){
					dp[i][j] = Math.max(i, j);
					continue;
				}
				if (c1[i-1]==c2[j-1]){
					dp[i][j] = Math.min(dp[i][j-1]+1, Math.min(dp[i-1][j-1],dp[i-1][j]+1));
				}else{
					dp[i][j] = Math.min(dp[i][j-1]+1, Math.min(dp[i-1][j-1]+1,dp[i-1][j]+1));
				}
				if (dp[i][j]<min && dp[i][j]!=0){
					min = dp[i][j];
				}
			}
		}
		System.out.println(dp[c1.length][c2.length]);
		sc.close();
	}

}

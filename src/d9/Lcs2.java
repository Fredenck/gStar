package d9;

import java.util.*;

public class Lcs2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		int max = -1;
		
		for (int i=0; i<=c1.length; i++){
			for (int j=0; j<=c2.length; j++){
				if(i==0 || j==0){
					dp[i][j] = 0;
					continue;
				}
				if (c1[i-1]==c2[j-1]){
					dp[i][j] = dp[i-1][j-1]+1;
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
				if (dp[i][j]>max){
					max = dp[i][j];
				}
			}
		}
		System.out.println(max);
		sc.close();
	}

}

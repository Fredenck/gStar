package d14;

import java.util.*;

public class Profits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] profit = new int[N+1];
		for (int i=0; i<N; i++){
			profit[i] = sc.nextInt();
		}

		int[] sum = new int[N+1];
	    for (int i = 1; i <= N; i++){
	        sum[i] = sum[i-1] + profit[i-1];
	    }
	    
	    int[] max = new int[N+1];
	    max[N] = sum[N];

	    for (int i = N - 1; i >= 0; i--){
	        max[i] = Math.max(max[i+1], sum[i]);
	    }
	    
	    int ans = Integer.MIN_VALUE;
	    for (int i=0; i<N; i++){
	    	ans = Math.max (ans, max[i+1] - sum[i]);
	    }
	    System.out.println(ans);
	    sc.close();
	}

}

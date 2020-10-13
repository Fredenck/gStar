package d8;

import java.util.*;

public class Change {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int N = sc.nextInt();
		
		long[] coins = new long[N+1];
		long[][] ways = new long[N+1][C+1];
		
		for (int i=1; i<=N; i++){
			coins[i] = sc.nextInt();
		}
		Arrays.sort(coins);
		for (int i=0; i<=C; i++){
			ways[0][i] = Integer.MAX_VALUE;
		}
		ways[0][0] = 0;
		
	    for(int i=1; i<=N; i++) {
	        for(int j=1; j<=C; j++) {
	            if(j<coins[i]){
	            	ways[i][j] = ways[i-1][j];
	            }
	            else{
	            	ways[i][j] = Math.min(ways[i-1][j], ways[i][(int) (j-coins[i])]+1);
	            }
	        }
	    }
		System.out.println(ways[N][C]);
		sc.close();
//	    long max = -1;
//		for (long i:ways[N]){
//			if (i>max){
//				max = i;
//			}
//		}
//		System.out.println(max);

	}

}

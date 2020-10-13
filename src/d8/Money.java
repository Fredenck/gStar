package d8;

import java.util.*;

public class Money {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int N = sc.nextInt();
		long[] coins = new long[V+1];
		long[][] ways = new long[V+1][N+1];
		
		for (int i=1; i<=V; i++){
			coins[i] = sc.nextInt();
		}
		
		
	    for(int i=1; i<=V; i++) {
	        for(int j=0; j<=N; j++) {
	            if(j==0){
	            	ways[i][j]=1;
	            }
	            else if(j<coins[i]){
	            	ways[i][j] = ways[i-1][j];
	            }
	            else{
	            	ways[i][j] = ways[i-1][j] + ways[i][(int) (j-coins[i])];
	            }
	        }
	    }
		
		System.out.println(ways[V][N]);
		sc.close();
	}
}

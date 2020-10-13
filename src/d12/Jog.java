package d12;

import java.util.*;

public class Jog {
	static int T, N;
	static int[] end;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = sc.nextInt();
		
		end = new int[N];
		for (int i=0; i<N; i++){
			int p = sc.nextInt();
			int v = sc.nextInt();
			end[i] = p+v*T;
		}
		
		int ans = 1;
//	    for(int i = N-1; i>0; i--)
//	    {
//	        if(end[i-1] >= end[i]){
//	            end[i-1] = end[i];
//	        	continue;
//	        }
//	        ans++;
//	    }
		for (int i=0; i<N-1; i++){
			if (slowest(end[i], i)){
				ans++;
			}
		}
	    System.out.println(ans);
	    sc.close();
	}

	private static boolean slowest(int p, int idx) {
		for (int i=idx+1; i<N; i++){
			if (p>=end[i]){
				return false;
			}
		}
		return true;
	}
	
	

}

package d10;

import java.util.*;
public class Coaster {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();
		int B = sc.nextInt();
		
		ArrayList<ArrayList<Part>> arl = new ArrayList<ArrayList<Part>>();
		for (int i=0; i<1000; i++){
			arl.add(new ArrayList<Part>());
		}
		
		for (int i=0; i<N; i++){
			int x = sc.nextInt();
			int w = sc.nextInt();
			int f = sc.nextInt();
			int c = sc.nextInt();
			Part p = new Part(x,w,f,c);
			arl.get(x+w).add(p);
		}
		
		int[][] dp = new int[L+1][B+1];
		for (int i=0; i<L+1; i++){
			Arrays.fill(dp[i], -1);
		}
		
		dp[0][0] = 0;
		for (int i = 1; i <= L; i++) {
			if (arl.get(i).size() == 0){
				continue;
			}
			for (int k = 0; k < (int)arl.get(i).size(); k++) {
				for (int j = 0; j <= B; j++) {
					Part cur = arl.get(i).get(k);
					if (cur.cost>j){
						continue;
					}
					int prevDp = dp[i-cur.len][j-cur.cost];
					if (prevDp==-1){
						continue;
					}
					dp[i][j] = Math.max(dp[i][j],  prevDp+cur.fun);
				}
			}
		}
		
		int ans = -1;
		for (int i = 0; i <= B; i++) {
			ans = Math.max(ans, dp[L][i]);
		}
		System.out.println(ans);
		sc.close();
	}
	
	static class Part{
		int pos; int len; int fun; int cost;
		Part(int p, int l, int f, int c){
			pos = p+l;//endpoint
			len = l;
			fun = f;
			cost = c;
		}
	}

}

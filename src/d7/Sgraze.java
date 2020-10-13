package d7;

import java.util.*;

public class Sgraze {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Pair[] p = new Pair[N];
		for (int i=0; i<N; i++) {
			p[i] = new Pair(sc.nextInt(), sc.nextInt());
		}
		int[] dp = new int[N+1];
		
		Arrays.sort(p, new Comparator<Pair>() {
		   	@Override  
			public int compare(Pair p1, Pair p2) {
		   		if (p1.y==p2.y){
		   			return p1.x-p2.x;
		   		}
			    return p1.y-p2.y;
			}
		});
		
		for (int i = 1; i <= N; i++) {
			int low = -1;
			int high = N-1;
			int mid = (low + high + 1)/2;
			while (low < high) {
				if (p[mid].y <= p[i-1].x){
					low = mid;
				}
				else{
					high = mid-1;
				}
				mid = (low + high + 1)/2;
			}
			mid = low + 1;
			dp[i] = Math.max(dp[mid]+1, dp[i-1]);//with vs without
		}
		System.out.println(dp[N]);
		sc.close();
	}

	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		
	    @Override
	    public boolean equals(Object o) {

	        if (o == this) return true;
	        if (!(o instanceof Pair)) {
	            return false;
	        }
	        Pair p = (Pair) o;
	        return x == p.x &&
	                Objects.equals(x, p.x) &&
	                Objects.equals(y, p.y);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(x, y);
	    }
	}
}

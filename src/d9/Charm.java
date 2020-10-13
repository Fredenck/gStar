package d9;

import java.util.*;

public class Charm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
//		int M = sc.nextInt();
		
		Pair[] p = new Pair[N];
		
		for(int i=0; i<N; i++){
			int w = sc.nextInt();
			int d = sc.nextInt();
			p[i] = new Pair(w,d);
		}
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

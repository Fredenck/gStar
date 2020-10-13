package d3;

import java.io.*;
import java.util.*;

public class Tallest {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextInt();
		int H = sc.nextInt();
		int R = sc.nextInt();
		int[] begin = new int[N];
		int[] end = new int[N];
		Set<Pair> set = new HashSet<Pair>();
		
		for (int i=0; i<R; i++){
			int A = sc.nextInt()-1;
			int B = sc.nextInt()-1;
			
			if (A>B){
				int x = A;
				A = B;
				B = x;
			}
			
			if (set.contains(new Pair(A,B))){
				continue;
			}
			set.add(new Pair(A,B));
			
			begin[A]++;
			end[B]++;
		}
		
		

		
		
		int arches = 0;
		int[] mHeight = new int[N];
		for (int i=0; i<N; i++){
			arches -= end[i];
			mHeight[i] = H-arches;
			arches += begin[i];
		}
//		System.out.println(Arrays.toString(mHeight));
		for (int h:mHeight){
			System.out.println(h);
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

package d4;

import java.util.*;

public class Comehome {
	static int[][] mat;
	
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();
		mat = new int[52][52];
		
		for (int i=0; i<P; i++){
			String p1 = sc.next();
			String p2 = sc.next();
			int idx1 = convert(p1);
			int idx2 = convert(p2);
			int cost = sc.nextInt();
			if (mat[idx1][idx2] != 0 && mat[idx1][idx2]>cost){
				mat[idx1][idx2] = cost;
				mat[idx2][idx1] = cost;
			}else if (mat[idx1][idx2] != 0 && mat[idx1][idx2]<cost){
				;
			}else{
				mat[idx1][idx2] = cost;
				mat[idx2][idx1] = cost;
				
			}

	
			
		}
		
		Floyd(52);
		int min = Integer.MAX_VALUE;
		char minc = 'a';
		for (int i=0; i<25; i++){
			if (mat[i][25]<min && mat[i][25]!=0){
				min = mat[i][25];
				minc = (char) (i+'A');
			}
		}
		System.out.println(minc+" "+min);
		sc.close();
	}

	private static int convert(String str) {
		char c = str.charAt(0);
		if ('A'<=c && c<='Z'){
			return c-'A';
		}else{
			return 26+c-'a';
		}
		
	}
	
	public static void Floyd(int N){
		for (int k=0; k<N; k++){
			for (int i=0; i<N; i++){
				if (mat[i][k]>0){//i to k path
					for (int j=0; j<N; j++){
						if (mat[k][j]>0){//k to j path
							if (mat[i][j]==0 || mat[i][j]>mat[i][k]+mat[k][j]){
								mat[i][j] = mat[i][k] + mat[k][j];
							}
						}
					}
				}
			}
		}
	}
	
	static class Pair{
		int x, y;
		Pair(int x, int y, int c){
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

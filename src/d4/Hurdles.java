package d4;

import java.util.*;
public class Hurdles {
	static int[][] mat;
	
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int T = sc.nextInt();
		mat = new int[N][N];
		
		for (int i=0; i<M; i++){
			int S = sc.nextInt()-1;
			int E = sc.nextInt()-1;
			int H = sc.nextInt();
			mat[S][E] = H;
		}
		
		Floyd(N);
		for (int i=0; i<T; i++){
			int A = sc.nextInt()-1;
			int B = sc.nextInt()-1;
			if (mat[A][B]==0){
				System.out.println(-1);
			}else{
				System.out.println(mat[A][B]);				
			}
		}
		sc.close();
	}
	
	public static void Floyd(int N){
		for (int k=0; k<N; k++){
			for (int i=0; i<N; i++){
				if (mat[i][k]>0){//i to k path
					for (int j=0; j<N; j++){
						if (i==k || k==j || i==j){
							continue;
						}
						if (mat[k][j]>0){//k to j path
							if (mat[i][j]==0 || mat[i][j]>Math.max(mat[i][k], mat[k][j])){
								mat[i][j] = Math.max(mat[i][k], mat[k][j]);
							}
						}
					}
				}
			}
		}
	}
	
}

package d13;

import java.util.*;

public class Ttime {
	static int N, M, Q;
	static int[][] cows;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		Q = sc.nextInt();
		
		cows = new int[N][N];
		
		for (int i=0; i<M; i++){
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			cows[a][b] = 1;
			cows[b][a] = 1;
			
		}
		
		Floyd(cows, N);
		
		for (int i=0; i<Q; i++){
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			if (cows[a][b]!=0){
				System.out.println("Y");
			}else{
				System.out.println("N");
			}
		}
		sc.close();
	}
	
	public static void Floyd(int[][] mat, int N){
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

}

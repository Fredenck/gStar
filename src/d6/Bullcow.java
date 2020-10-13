package d6;

import java.util.*;

public class Bullcow {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] cowBull = new int[N][2];
		cowBull[0][0] = 1;
		cowBull[0][1] = 1;
		for (int i = 1; i < N; i++) {
			//+cow
			cowBull[i][0] = (cowBull[i-1][0] + cowBull[i-1][1]) % 5000011;
			if (i > K){//enough cows for a bull
				cowBull[i][1] = (cowBull[i-K-1][0] + cowBull[i-K-1][1]) % 5000011;
			}
			else{
				cowBull[i][1] = 1;
			}
		}
		System.out.println((cowBull[N-1][0] + cowBull[N-1][1]) % 5000011);
		sc.close();
	}
}

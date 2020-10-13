package d13;

import java.util.*;

public class Teststr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] test = new int[K];
		for (int i=0; i<K; i++){
			test[i] = N-sc.nextInt();
		}
		Arrays.sort(test,0,K);
		
		int best = test[0];
		for (int i=0; i<K-1; i++){
			best = Math.max(best, (test[i+1]-test[i])/2);
		}
		best = Math.max(best, (N-test[K-1])/2);
		System.out.println(best);
		sc.close();
	}

}

package d14;

import java.util.*;

public class Smount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] mountains = new int[N+1];
		for (int i=0; i<N; i++){
			mountains[i] = sc.nextInt();
		}
		
		int left = 0;
		int right = 0;
		int maxW = 0;
		boolean[] mark = new boolean[N+1];		
	    for (int i=0; i<N; i++) {
	        if (mountains[i]>mountains[i+1] && !mark[i]) {
	            mark[i] = true;
	            
	            left = i-1;
	            while (left>=0 && mountains[left]<=mountains[left+1]){
	            	mark[left] = true;
	            	left--;
	            }
//	            // find the leftmost position
//	            for (left = i-1; left > =0 && mountains[left] <= mountains[left+1]; left--)
//	                mark[left] = true;
	            right = i+1;
	            while (right<N && mountains[right]<=mountains[right-1]){
	            	mark[right] = true;
	            	right++;
	            }
//	            // find the rightmost postion
//	            for (right = i+1; right<N && mountains[right]<=mountains[right-1]; right++)
//	                mark[right] = true;
	            // update maximum width
	            if (maxW<right-left-1){
	                maxW = right-left-1;
	            }
	        }
	    }
	    sc.close();
	    System.out.println(maxW);
	}

}

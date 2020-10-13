package d3;

import java.util.*;

public class Cowdance {
	static int N, Tmax;
	static int[] times;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Tmax = sc.nextInt();
		times = new int[N];
		
		for (int i=0; i<N; i++){
			times[i] = sc.nextInt();
		}
		
		System.out.println(binary());
		sc.close();
	}
	
	public static int binary(){
		int min = 0;
		int max = N;
		while(min != max) {
			int mid = (min+max)/2;
			if(arrange(mid)) {
				max = mid;
			}
			else {
				min = mid+1;
			}
		}
		return min;
	}
	
	public static boolean arrange(int stageSize) {
		int switchT = 0;//time to finish 
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i = 0; i < N; i++) {
			if(q.size() == stageSize) {
				switchT = q.poll();
			}
			if(switchT + times[i] > Tmax) {
				return false;
			}
			q.add(switchT + times[i]);
		}
		return true;
	}
}

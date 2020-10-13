package d2;

import java.util.*;

public class Catchcow {
	static int[] visited = new int[100001];
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		visited[N] = -1;
		int time = 0;
		
		while (!q.isEmpty()){
			int checksReq = q.size();
			for (int i=0; i<checksReq; i++){
				int cur = q.poll();
				
				if (cur==K){
					System.out.println(time);
					return;
				}
				//forwards
				if (cur+1 <= 100000 && visited[cur+1]==0) {
					q.add(cur+1);
					visited[cur+1] = -1;
				}
				//back
				if (cur-1 >= 0 && visited[cur-1]==0) {
					q.add(cur-1);
					visited[cur-1] = -1;
				}
				//double
				if (2*cur <= 100000 && visited[2*cur]==0){
					q.add(2*cur);
					visited[2*cur] = -1;
				}
			}
			time++;
		}
	}
}

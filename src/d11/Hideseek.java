package d11;

import java.util.*;

public class Hideseek {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] dist = new int[N];
		int[] cows = new int[N];
		
		ArrayList<ArrayList<Integer>> arl = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<N; i++){
			arl.add(new ArrayList<Integer>());
		}
		
		for (int i=0; i<M; i++){
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			arl.get(a).add(b);
			arl.get(b).add(a);
		}
		
		int max = 0;;
		dist[0] = 1;
        LinkedList<Integer> q = new LinkedList<Integer>(); 
		q.push(0);
		while (!q.isEmpty()){
			int cur = q.poll();
			
			cows[dist[cur]]++;
			if (dist[cur]>dist[max] || (dist[cur]==dist[max] && cur<max)){
				max = cur;
			}
			
			for (int i=0; i<arl.get(cur).size(); i++){
				int next = arl.get(cur).get(i);
				if (dist[next]!=0){
					continue;
				}
				dist[next] = dist[cur]+1;
				q.add(next);
			}
		}
		sc.close();
		
		System.out.print(max+1+" ");
		System.out.print(dist[max]-1+" ");
		System.out.println(cows[dist[max]]);
	}

}

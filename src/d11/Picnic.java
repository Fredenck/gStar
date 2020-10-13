package d11;

import java.util.*;

public class Picnic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] cows = new int[N];
		
		ArrayList<ArrayList<Integer>> arl = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<N; i++){
			arl.add(new ArrayList<Integer>());
		}
		
		for (int i=0; i<K; i++){
			int pasture = sc.nextInt()-1;
			cows[i] = pasture;
		}
		
		for (int i=0; i<M; i++){
			int A = sc.nextInt()-1;
			int B = sc.nextInt()-1;
			arl.get(A).add(B);
		}
		
        LinkedList<Integer> q = new LinkedList<Integer>(); 
        int ans = 0;
        boolean[] notReach = new boolean[N];
        
		for (int i=0; i<K; i++){
			int[] curC = new int[N];
			Arrays.fill(curC, -1);
			curC[cows[i]] = 0;
			q.add(cows[i]);
			
			while(!q.isEmpty()){
				int cur = q.poll();
				for (int j=0; j<arl.get(cur).size(); j++){
					int next = arl.get(cur).get(j);
					if (curC[next]!=-1){
						continue;
					}
					curC[next] = curC[cur]+1;
					q.add(next);
				}
			}
			for (int j=0; j<N; j++){
				if (curC[j]==-1){
					notReach[j] = true;
//					ans--;
				}
			}
		}
		for (int i=0; i<N; i++){
			if(!notReach[i]){
				ans++;
			}
		}
		System.out.println(ans);
		sc.close();
	}

}

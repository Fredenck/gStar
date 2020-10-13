package d4;

import java.util.*;


public class Daisy {
	static ArrayList<ArrayList<Integer>> adjL;
	static int N, M;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		adjL = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<N; i++){
			adjL.add(new ArrayList<Integer>());
		}
		
		for (int i=0; i<M; i++){			
			int c1 = sc.nextInt()-1;
			int c2 = sc.nextInt()-1;
			adjL.get(c1).add(c2);
			adjL.get(c2).add(c1);
		}
		
		int[] connected = new int[N];//if cow [i] is connected to cow 1
		dfs(connected, 0);
//		System.out.println(Arrays.toString(connected));
		int good = 0;
		for (int i=0; i<N; i++){
			if (connected[i]==1){
				good++;
				continue;
			}
			System.out.println(i+1);
		}
		if (good==N){
			System.out.println();
		}
		sc.close();
	}
	
	public static void dfs (int[] connected, int idx){
		connected[idx] = 1;
		for (int i=0; i<adjL.get(idx).size(); i++){
			int next = adjL.get(idx).get(i);
			if (connected[next] == 1){
				continue;
			}
			dfs (connected, next);
		}
		//visited[r][c] = 0;
		return;
	}	

}

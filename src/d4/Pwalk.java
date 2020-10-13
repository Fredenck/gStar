package d4;

import java.util.*;
public class Pwalk {
	static int N, Q;
	static ArrayList<ArrayList<Pp>> adjL;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Q = sc.nextInt();
		
		adjL = new ArrayList<ArrayList<Pp>>();
		for (int i=0; i<N; i++){
			adjL.add(new ArrayList<Pp>());
		}
		
		for (int i=0; i<N-1; i++){
			int A = sc.nextInt()-1;
			int B = sc.nextInt()-1;
			int L = sc.nextInt();
			adjL.get(A).add(new Pp(B, L));
			adjL.get(B).add(new Pp(A, L));
		}
		for (int i=0; i<Q; i++){//queries
			int A = sc.nextInt()-1;
			int B = sc.nextInt()-1;
			int[] visited = new int[N];
			dfs(A, B, 0, visited);
			
		}
		sc.close();
	}
	
	public static void dfs (int cur, int end, int cost, int[] visited){
		if (cur==end){
			System.out.println(cost);
		}
		visited[cur] = 1;
		for (int i=0; i<adjL.get(cur).size(); i++){
			Pp next = adjL.get(cur).get(i);
			if (visited[next.toPasture] == 1){
				continue;
			}
			cost += next.cost;
			dfs (next.toPasture, end, cost, visited);
			cost -= next.cost;
		}
		//visited[r][c] = 0;
		return;
	}
	
	public static int minimum(ArrayList<Integer> min){
		int smallest = Integer.MAX_VALUE;
		for (int i:min){
			if (i<smallest){
				smallest = i;
			}
		}
		return smallest;
	}
	
	static class Pp{
		int toPasture;
		int cost;
		Pp(int tp, int c){
			toPasture = tp;
			cost = c;
		}
	}
}

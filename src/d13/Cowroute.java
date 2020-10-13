package d13;

import java.util.*;

public class Cowroute {
	static P[][] adj;
	static int A, B, N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt()-1;
		B = sc.nextInt()-1;
		N = sc.nextInt();
		
		adj = new P[1010][1010];
		for (int i=0; i<1010; i++){
			Arrays.fill(adj[i], new P(Integer.MAX_VALUE, 0));
		}

//		int max = 0;
		for (int i=0; i<N; i++){
			int cost = sc.nextInt();
			int cityNum = sc.nextInt();
			int[] cities = new int[cityNum];
			for (int j=0; j<cityNum; j++){
				cities[j] = sc.nextInt()-1;
//				if (cities[j]+1>max){
//					max = cities[j]+1;
//				}
			}
			for (int j=0; j<cityNum; j++){
				for (int k=0; k<cityNum; k++) {
					if (j == k){
						continue;
					}
					adj[cities[j]][cities[k]].cost = Math.min(cost, adj[cities[j]][cities[k]].cost);
					adj[cities[k]][cities[j]].cost = Math.min(cost, adj[cities[j]][cities[k]].cost);
				}
			}
		}
		P[] d = dijkstra(A, 1010);
		System.out.println(d[B].cost+" "+(d[B].times-1));
		sc.close();
	}
	
	public static P[] dijkstra(int source, int V) {

        boolean[] spt = new boolean[V];
        P [] distance = new P[V];

        for (int i = 0; i <V ; i++) {
            distance[i] = new P(Integer.MAX_VALUE,0);
        }

        distance[source].cost = 0;
        for (int i = 0; i <V ; i++) {

            int closestV = minV(spt, distance, V);
            if (closestV==-1){
            	return distance;
            }
            spt[closestV] = true;

            //vertices of closest v
            for (int pos = 0; pos <V ; pos++) {
                if(adj[closestV][pos].cost>0){
                	
                    if(spt[pos]==false && adj[closestV][pos].cost!=Integer.MAX_VALUE){
                        int newD =  adj[closestV][pos].cost + distance[closestV].cost;
                        if(newD<distance[pos].cost)
                            distance[pos].cost = newD;
                        	distance[pos].times++;
                    }
                }
            }
        }
		return distance;
	}
	public static int minV(boolean[] spt, P[] distance, int V) {
        int minD = Integer.MAX_VALUE;
        int v = -1;
        for (int i = 0; i <V ; i++) {
            if(spt[i]==false && minD>distance[i].cost){
            	minD = distance[i].cost;
                v = i;
            }
        }
        return v;
	}
	static class P{
		int cost, times;
		public P(int c, int t){
			cost = c;
			times = t;
		}
	}
}

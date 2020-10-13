package d13;

import java.util.*;

public class Bestspot {
	static int[][] farm;
	static int[] fav;
	static int P, F, C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		P = sc.nextInt();
		F = sc.nextInt();
		C = sc.nextInt();
		
		fav = new int[F];
		for (int i=0; i<F; i++){
			fav[i] = sc.nextInt()-1;
		}
		
		farm = new int[P][P];
		for (int i=0; i<C; i++){
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			int t = sc.nextInt();
			farm[a][b] = t;
			farm[b][a] = t;
		}
		
		int min = Integer.MAX_VALUE;
		int minIdx = 0;
		for (int i=1; i<P; i++){
			int cur = 0;
			int[] d = dijkstra(i, P);
			for (int j=0; j<F; j++){
				cur += d[fav[j]];
			}
			if (cur<min){
				min = cur;
				minIdx = i;
			}
		}
		System.out.println(minIdx+1);
		sc.close();
	}
	
	public static int[] dijkstra(int source, int V) {

        boolean[] spt = new boolean[V];
        int [] distance = new int[V];

        for (int i = 0; i <V ; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[source] = 0;
        for (int i = 0; i <V ; i++) {

            int closestV = minV(spt, distance, V);
            if (closestV==-1){
            	for (int a:distance){
            		if (a!=Integer.MAX_VALUE){
                		System.out.println(a);            			
            		}else{
            			System.out.println(-1);
            		}
            	}
            	return distance;
            }
            spt[closestV] = true;

            //vertices of closest v
            for (int pos = 0; pos <V ; pos++) {
                if(farm[closestV][pos]>0){
                	
                    if(spt[pos]==false && farm[closestV][pos]!=Integer.MAX_VALUE){
                        int newD =  farm[closestV][pos] + distance[closestV];
                        if(newD<distance[pos])
                            distance[pos] = newD;
                    }
                }
            }
        }
		return distance;
	}
	public static int minV(boolean[] spt, int[] distance, int V) {
        int minD = Integer.MAX_VALUE;
        int v = -1;
        for (int i = 0; i <V ; i++) {
            if(spt[i]==false && minD>distance[i]){
            	minD = distance[i];
                v = i;
            }
        }
        return v;
	}

}

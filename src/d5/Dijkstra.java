package d5;

import java.util.*;

public class Dijkstra {
	static int[][] adjM;
	static int V; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		int S = sc.nextInt()-1;
		 adjM = new int[V][V];
		for (int i=0; i<E; i++){
			int A = sc.nextInt()-1;
			int B = sc.nextInt()-1;
			int C = sc.nextInt();
			adjM[A][B] = C;
			adjM[B][A] = C;
		}
		
		dijkstra(S);
		sc.close();
	}
	public static void dijkstra(int source) {

        boolean[] spt = new boolean[V];
        int [] distance = new int[V];

        for (int i = 0; i <V ; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[source] = 0;
        for (int i = 0; i <V ; i++) {

            int closestV = minV(spt, distance);
            if (closestV==-1){
            	for (int a:distance){
            		if (a!=Integer.MAX_VALUE){
                		System.out.println(a);            			
            		}else{
            			System.out.println(-1);
            		}
            	}
            	return;
            }
            spt[closestV] = true;

            //vertices of closest v
            for (int pos = 0; pos <V ; pos++) {
                if(adjM[closestV][pos]>0){
                	
                    if(spt[pos]==false && adjM[closestV][pos]!=Integer.MAX_VALUE){
                        int newD =  adjM[closestV][pos] + distance[closestV];
                        if(newD<distance[pos])
                            distance[pos] = newD;
                    }
                }
            }
        }
		for (int i:distance){
			System.out.println(i);
		}
		return;
	}
	public static int minV(boolean[] spt, int[] distance) {
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

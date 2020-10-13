package d5;

import java.util.*;

public class Cgiving2 {
	static int[][] adjL;
	static int V;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int B = sc.nextInt();
		
		V = N;
		adjL = new int[N][N];
		
		for (int i=0; i<M; i++){
			int p1 = sc.nextInt();
			int p2 = sc.nextInt();
			int l = sc.nextInt();
			adjL[p1][p2] = l;
			adjL[p2][p1] = l;
		}
		
		for (int i=0; i<B; i++){
//			int b = sc.nextInt();
//			int c = sc.nextInt();
		}
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
                if(adjL[closestV][pos]>0){
                	
                    if(spt[pos]==false && adjL[closestV][pos]!=Integer.MAX_VALUE){
                        int newD =  adjL[closestV][pos] + distance[closestV];
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

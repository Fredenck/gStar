package d15;

import java.util.*;

public class Roadblock {
	static int N, R;
	static int[][] adj;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		adj = new int[N][N];
		int[] as = new int[R];
		int[] bs = new int[R];
		
		for (int i=0; i<R; i++){
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			int c = sc.nextInt();
			adj[a][b] = c;
			adj[b][a] = c;
			as[i] = a;
			bs[i] = b;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
//		int[] d = dijkstra(0);
//		list.add(d[N-1]);
		int max = dij(0,N-1);
		list.add(max);
		
		for (int i=0; i<R; i++){
			adj[as[i]][bs[i]] *= 2;
			adj[bs[i]][as[i]] *= 2;
//			d = dijkstra(0);
			max = dij(0,N-1);
			adj[as[i]][bs[i]] /= 2;
			adj[bs[i]][as[i]] /= 2;	
			
//			list.add(d[N-1]);
			list.add(max);
		}
		
		
		
		System.out.println();
		sc.close();
	}
	public static int[] dijkstra(int source) {

        boolean[] spt = new boolean[N];
        int [] distance = new int[N];

        for (int i = 0; i <N ; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[source] = 0;
        for (int i = 0; i <N-1; i++) {

            int closestV = minV(spt, distance);
            spt[closestV] = true;

            //vertices of closest N
            for (int pos = 0; pos <N ; pos++) {
                if (!spt[pos] && adj[closestV][pos] != 0 &&  
                        distance[closestV] != Integer.MAX_VALUE && distance[closestV] + adj[closestV][pos] < distance[pos]) 
                         distance[pos] = distance[closestV] + adj[closestV][pos]; 
            }
        }
		return distance;
	}
	public static int minV(boolean[] spt, int[] distance) {
        int minD = Integer.MAX_VALUE;
        int v = -1;
        for (int i = 0; i <N ; i++) {
            if(spt[i]==false && minD>=distance[i]){
            	minD = distance[i];
                v = i;
            }
        }
        return v;
	}
	
	public static int dij(int start, int end){
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		int[] prev= new int[N];
		Arrays.fill(prev, -1);
		boolean[] visited= new boolean[N];
		
	    dist [start] = 0;

	    while (true){
	        int close = -1;

	        for (int i = 0; i < N; i++)
	            if (!visited [i] && (close == -1 || dist [i] < dist [close]))
	                close = i;

	        if (close == -1)
	            break;

	        visited [close] = true;

	        for (int i = 0; i < N; i++)
	        {
	            int ndist = dist [close] + adj [close][i];

	            if (ndist < dist [i])
	            {
	                dist [i] = ndist;
	                prev [i] = close;
	            }
	        }
	    }
	    return dist[end];
	}
}

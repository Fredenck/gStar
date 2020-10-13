package d5;

import java.util.*;

public class Roads {
	static ArrayList<Pair> farms;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		farms = new ArrayList<Pair>(); 
		for (int i=0; i<N; i++){
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			farms.add(new Pair(x,y));
		}
		long[][] dist = new long[N][N];
		for (int i=0; i<N; i++){
			for (int j=i; j<N; j++){
				int xc = farms.get(i).x-farms.get(j).x;
				int yc = farms.get(i).y-farms.get(j).y;
				long v = (long) xc*xc + (long) yc*yc;
				dist[i][j] = v;
				dist[j][i] = v;
			}
		}
		
		for (int i=0; i<M; i++){
			int f1 = sc.nextInt()-1;
			int f2 = sc.nextInt()-1;
			dist[f1][f2] = -1;
			dist[f2][f1] = -1;
		}
		Prim(dist, N);
		sc.close();
	}
	
	public static void Prim(long[][] dist, int V) {
		boolean[] selected = new boolean[V];
	
		Arrays.fill(selected, false);;
		selected[0] = true;
	
//	    int edges = 0;
	    double minC = 0;
	
		
		for (int i=0; i<V; i++) {		
			long min = Integer.MAX_VALUE;
			int a = -1, b = -1;
			
			if (selected[i]){
				for (int j=0; j<V; j++){
					if (!selected[j] && dist[i][j]!=0){
						if (min>dist[i][j]){
							if (dist[i][j]==-1){//previous road
								min = 0;
							}else{
				                min = dist[i][j];									
							}
			                a = i;
			                b = j;
						}
					}
				}
		        if (a != -1 && b != -1){
//		        	System.out.println(a+" "+b+" "+rmin);
//		        	edges++;
		        	double minD = Math.sqrt(min);
		            minC += minD;
		            selected[b] = selected[a] = true;
		    		for (int aa=0; aa<V; aa++){
		    			int xc = farms.get(aa).x-farms.get(b).x;
		    			int yc = farms.get(aa).y-farms.get(b).y;
		    			long v = (long) xc*xc + (long) yc*yc;
		    			dist[aa][b] = v;
		   				dist[b][aa] = v;
		    		}
		        } 
				
			}
//			while (edges<V-1){
	//			for (int i = 0; i < V; i++) {
	//				if (selected[i] == true) {
	//					for (int j = 0; j < V; j++) {
	//						// not in selected (tree) and there is an edge
	//						if (!selected[j] && dist[i][j] != 0) {
	//							if (min > dist[i][j]) {
	//								if (dist[i][j]==-1){//previous road
	//									min = 0;
	//								}else{
	//					                min = dist[i][j];									
	//								}
	//				                a = i;
	//				                b = j;
	//				            }
	//						}
	//					}
	//				}
	//			}
	//	        if (a != -1 && b != -1){
	////	        	System.out.println(a+" "+b+" "+rmin);
	//	        	edges++;
	//	        	double minD = Math.sqrt(min);
	//	            minC += minD;
	//	            selected[b] = selected[a] = true; 
	//	        } 
//			}

		}
		System.out.println(String.format("%.2f", minC));
	}
	static class Pair{
		int x, y;
		Pair(int x1, int y1){
			x=x1;
			y=y1;
		}
	}

}

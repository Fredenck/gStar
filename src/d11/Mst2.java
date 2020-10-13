package d11;

import java.util.*;

public class Mst2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		ArrayList<ArrayList<T>> arl = new ArrayList<ArrayList<T>>();
		for (int i=0; i<V; i++){
			arl.add(new ArrayList<T>());
		}
		
		for (int i=0; i<E; i++){
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			int c = sc.nextInt();
			arl.get(a).add(new T(b,c));
		}
		
		Floyd(arl);
		System.out.println();
		sc.close();
	}
	
	public static void Floyd(ArrayList<ArrayList<T>> shortest){
		int n = shortest.size();
		for (int k = 0; k < n; k++) {
			int n2 = shortest.get(k).size();
			for (int i = 0; i < n2; i++) { 
				for (int j = 0; j < n2; j++) { 
					T orig = shortest.get(i).get(j);
					T newOne = shortest.get(i).get(k);
					if (shortest.get(i).get(k).cost + shortest.get(k).get(j).cost<shortest.get(i).get(j).cost){
						shortest.get(i).set(orig.cost, newOne);
					}
				}
			} 
		} 
	}
	static class T{
		int to;
		int cost;
		public T(int t, int c){
			to = t;
			cost = c;
		}
	}
}

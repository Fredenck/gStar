package d12;

import java.util.*;

public class Soda {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Graze[] cows = new Graze[2*N]; 
		for (int i=0; i<2*N; i++){
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			cows[i] = new Graze(a,true);
			i++;
			cows[i] = new Graze(b,false);
		}
		Arrays.sort(cows, new Comparator<Graze>() {
		   	@Override  
			public int compare(Graze o1, Graze o2) {
		   		if (o1.crit==o2.crit){
		   			if (o1.se){
		   				return -1;
		   			}
		   		}
			    return o1.crit-o2.crit;
			}
		});
		
		int cur = 0;
		int ans = 0;
		for (int i=0; i<cows.length; i++){
			if (cows[i].se){
				cur++;
				if (cur>ans){
					ans = cur;
				}
			}else{
				cur--;
			}
		}
		
		System.out.println(ans);
		sc.close();
	}
	static class Graze{
		int crit;
		boolean se;
		public Graze(int pt, boolean startOrEnd){
			crit = pt;
			se = startOrEnd;
		}
		
	
	}

}

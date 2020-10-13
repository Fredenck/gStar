package d14;

import java.util.*;

public class Tanning {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int L = sc.nextInt();
		
		MM[] cows = new MM[C];
		for (int i=0; i<C; i++){
			int cmin = sc.nextInt();
			int cmax = sc.nextInt();
			cows[i] = new MM(cmin, cmax);
		}
		
		Arrays.sort(cows, new Comparator<MM>() {
		   	@Override  
			public int compare(MM o1, MM o2) {
			    return o1.min-o2.min;
			}
		});
		
		LL[] lotion = new LL[L];
		for (int i=0; i<L; i++){
			int str = sc.nextInt();
			int t = sc.nextInt();
			lotion[i] = new LL(str, t);
		}
		
		Arrays.sort(lotion, new Comparator<LL>() {
		   	@Override  
			public int compare(LL o1, LL o2) {
			    return o1.str-o2.str;
			}
		});
		
		int ans = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int li=0; li<L; li++){
			ans = li;
			int ci = li;
			while (ci<C && cows[ci].min<=lotion[li].str){
				pq.add(-cows[ci].max);
				ci++;
			}
			while (!pq.isEmpty() && -pq.peek()<lotion[li].str){//bad
				pq.poll();
			}
			while (!pq.isEmpty() && lotion[li].times!=0){//good
				lotion[li].times--;
				ans++;
				pq.poll();
			}
		}
		System.out.println(ans-1);
		sc.close();
	}
	static class MM{
		int min, max;
		public MM(int mi, int ma){
			min = mi;
			max = ma;
		}
	}
	static class LL{
		int str; int times;
		public LL(int s, int t){
			str = s;
			times = t;
		}
	}

}

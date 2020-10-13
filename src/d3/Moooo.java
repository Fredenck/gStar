package d3;

import java.util.*;

public class Moooo {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Cow[] pcows = new Cow[N];
//		int[] time = new int[N];
		for (int i=0; i<N; i++){
			int h = sc.nextInt();
			int v = sc.nextInt();
			pcows[i] = new Cow(h, v, i);
		}
		
		Arrays.sort(pcows, new Comparator<Cow>(){
		   	@Override  
			public int compare(Cow o1, Cow o2) {
			    return (o1.h-o2.h);
			}
		});
		
		List<Cow> list = Arrays.asList(pcows); 
		Stack<Cow> cows = new Stack<Cow>();
        cows.addAll(list); //3 Add all items from the List to the stack.

		Cow cur = cows.pop();
		int v = 0;
		while(cows.peek().h<cur.h){
			cur = cows.pop();
			v += cur.v;
			
			if (cows.size()==0){
				break;
			}
		}
		System.out.println(v);
		sc.close();
	}
	
	static class Cow{
		int h, v, idx;
		Cow(int he, int vo, int id){
			h = he;
			v = vo;
			idx = id;
		}
	}
	
}

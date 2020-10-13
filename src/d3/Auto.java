package d3;

import java.util.*;

public class Auto {
	static int W, N;
	static Dict[] dictionary;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		W = sc.nextInt();
		N = sc.nextInt();
		
		dictionary = new Dict[W];
		for (int i=0; i<W; i++){
			String word = sc.next();
			dictionary[i] = new Dict(i, word);
		}
		
		Arrays.sort(dictionary, new Comparator<Dict>(){
		   	@Override  
			public int compare(Dict o1, Dict o2) {
			    return (o1.word.compareTo(o2.word));
			}
		});
		
		for (int i=0; i<N; i++){
			int kth = sc.nextInt()-1;
			String goal = sc.next();
			int min = binary(goal);
			if (min+kth<W && dictionary[min+kth].word.contains(goal)){
				System.out.println(dictionary[min+kth].idx+1);
			}else{
				System.out.println(-1);
			}
			
		}
		sc.close();
	}
	
	public static int binary(String goal){
		int min = 0;
		int max = W;
		while(min != max) {
			int mid = (min+max)/2;
			if(dictionary[mid].word.compareTo(goal)>=0) {
				max = mid;
			}
			else {
				min = mid+1;
			}
		}
		return min;
	}
	
	static class Dict{
		int idx;
		String word;
		Dict(int i, String s){
			idx = i;
			word = s;
		}

	}

}

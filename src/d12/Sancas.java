package d12;

import java.util.*;

public class Sancas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();
		
        PriorityQueue<Integer> cur = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        PriorityQueue<Integer> next = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

		for (int i=0; i<N; i++){
			cur.add(sc.nextInt());
			next.add(sc.nextInt());
		}
		
		
	    int ans = 0;
	    for(int i=0; i<N; i++)
	    {
	        int c = cur.poll();
	        int test = next.poll();

	        if(c<test){
	            ans += X*(test-c);
	        }
	        if(c>test){
	            ans += Y*(c-test);
	        }
	    }
	    System.out.println(ans);
	    sc.close();
	}

}

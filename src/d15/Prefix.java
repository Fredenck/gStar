package d15;

import java.util.*;

public class Prefix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        List<String> primitives = new ArrayList<>();
                
        String line = sc.nextLine();
        String[] tokens = line.split(" ");
        for (String s:tokens){
            if (solve(s, primitives)<s.length()) {
                primitives.add(s);
            }        	
        }
        
        sc.nextLine();
        
        String s = sc.nextLine();
        System.out.println(solve(s, primitives));
        sc.close();
    }

    public static int solve(String S, List<String> primitives) {
        int max = 0;
        boolean[] visited = new boolean[200010];
        visited[0]=true;
        
        for (int i=0; i<S.length(); i++){ 
            if (visited[i]){
                for (String p : primitives){
                	int nlen = i+p.length();
                	if (nlen<=S.length() && S.substring(i, nlen).equals(p)) {
                		max = Math.max(max, nlen);
                		visited[i+p.length()]=true;
                	}
                }
            }
    	}
        return max;
	}

}

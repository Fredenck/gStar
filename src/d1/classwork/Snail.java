package d1.classwork;
import java.util.*;

public class Snail {
	static int[][] visited;
	static int[][] mat;
	static int tot = 0;
	static int cur = 0;
	static int N;
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int B = sc.nextInt();
		mat = new int[N][N];
		visited = new int[N][N];
		
		for (int i=0; i<B; i++){
			String block = sc.next();
			int xCoord = convert(block.charAt(0));
			int yCoord = Character.getNumericValue(block.charAt(1))-1;
			mat[yCoord][xCoord] = 1;
		}
		
		dfs(0, 0, 1, 0);
		dfs(0, 0, 0, 1);
		System.out.println(tot);
		sc.close();
	}
	
	public static void dfs(int r, int c, int nr, int nc){
//		System.out.println(c+" "+r+" "+cur);
		if (visited[r][c]==1){
			if (cur>tot){
				tot = cur;
			}
			return;
		}
		visited[r][c] = 1;
		cur++;
		
		if (!bound(r+nr, c+nc) || mat[r+nr][c+nc]==1){
			if (cur>tot){
				tot = cur;
			}//turn
			if (nr==0){
				nr = 1;
			}else{
				nr = 0;
			}
			if (nc==0){
				nc = 1;
			}else{
				nc = 0;
			}
			//left and right
			if (bound(r+nr, c+nc) && mat[r+nr][c+nc]==0){
				dfs(r+nr,c+nc,nr,nc);
			}
			if (bound(r-nr, c-nc) && mat[r-nr][c-nc]==0){
				dfs(r-nr,c-nc,-nr,-nc);
			}
		}else{//same dir
			dfs(r+nr, c+nc, nr, nc);
		}
		
		visited[r][c] = 0;
		cur--;
	}
	private static boolean bound(int a, int b) {
		if (a>=0 && b>=0 && a<N && b<N){
			return true;
		}
		return false;
	}

	private static int convert(char c) {
		if ('A'<=c && c<='Z'){
			return c-'A';
		}else{
			return 26+c-'a';
		}
		
	}
}

package d2;

import java.util.*;

public class Gravity {
	static int N, M;
	static String[] mat;
	static Coords c, d;
	static int[][] mark = new int[502][502];
	static Queue<Coords> q;
	
	public static void main(String[] args){
		q = new LinkedList<Coords>();
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		mat = new String[N];
		for (int i=0; i<N; i++){
			mat[i] = sc.next();
		}
		
		for (int i=0; i<N; i++){
			for (int j=0; j<M; j++){
				if (mat[i].charAt(j)=='C'){
					c = fall(new Coords(i,j),1);
				}
				else if (mat[i].charAt(j)=='D'){
					d = new Coords(i,j);
				}
			}
		}
		
		if (!dfs(c,1)){
			for (; !q.isEmpty(); ){
				Coords e = q.poll();
				Coords p = action(e,0,DIR(e));
				if (dfs(p,mark[e.y][e.x]+1)) break;
			}
		}
		
		System.out.println(mark[d.y][d.x]-1);
		sc.close();
	}
	private static boolean dfs(Coords p, int flip) {
		if (p.y==-1 || mark[p.y][p.x]!=0){
			return false;
		}
		mark[p.y][p.x]=flip;
		if (p.y==d.y && p.x==d.x){
			return true;
		}
		q.add(p);
		int dir=DIR(p);
		return dfs(action(p,-1,dir),flip) || dfs(action(p,1,dir),flip);
	}
	private static Coords action(Coords p, int k, int dir) {
		if (k!=0){
			p.x+=k;
			if (p.x<0 || p.x>=M || mat[p.y].charAt(p.x)=='#'){
				return new Coords(-1,-1);
			}
		}else{
			dir = -dir;
		}
		return fall(p, dir);
	}
	private static int DIR(Coords e) {
		if (mark[e.y][e.x]%2!=0){
			return 1;
		}else{
			return -1;
		}
	}
	static class Coords{
		int x, y;
		int flip = 0;
		Coords(int x1, int y1){
			x = x1;
			y = y1;
		}
	}
	public static Coords fall(Coords p,int dir){
		for (; ; p.y+=dir){
			if (mat[p.y].charAt(p.x)=='D') break;
			if (p.y+dir<0 || p.y+dir>=N) return new Coords(-1,-1);
			if (mat[p.y+dir].charAt(p.x)=='#') break;
		}
	return p;
	}
}

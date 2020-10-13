package d1.classwork;
import java.util.*;

public class Meteor {
	static int[][] visited = new int[301][301];
	static int[][] map = new int[302][302];//earliest time a meteor strikes
	static boolean reachable = false;
	
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i=0; i<302; i++){
			Arrays.fill(map[i], Integer.MAX_VALUE);
		}
		//earliest times meteor strikes
		for (int i=0; i<N; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			int t = sc.nextInt();
			
			map[x][y] = Math.min(map[x+1][y], t);
			if (bounded(x+1,y)){
				map[x+1][y] = Math.min(map[x+1][y], t);
			}
			if (bounded(x-1,y)){
				map[x-1][y] = Math.min(map[x-1][y], t);
			}
			if (bounded(x,y+1)){
				map[x][y+1] = Math.min(map[x][y+1], t);
			}
			if (bounded(x,y-1)){
				map[x][y-1] = Math.min(map[x][y-1], t);
			}
		}
		bfs();
		if (!reachable){
			System.out.println(-1);
		}
		sc.close();
	}
	
	//BFS
	static void bfs(){
		int x=0, y=0;
		Queue<Pair> q = new LinkedList<Pair>();
		Pair p = new Pair(x,y);
		q.add(p);
		visited[0][0] = -1;
		
		while (!q.isEmpty()){
			int checksReq = q.size();
			for (int i=0; i<checksReq; i++){
				p = q.poll();
				if (p.t==38){
					System.out.println();;
				}
				if (map[p.x][p.y]==Integer.MAX_VALUE){
					System.out.println(p.t);
					reachable = true;
					return;
				}
				//forwards
				if (bounded(p.x+1,p.y) && visited[p.x+1][p.y]==0 && (p.t+1<map[p.x+1][p.y])) {
					Pair n = new Pair(p.x+1,p.y);
					n.t = p.t+1;
					q.add(n);
				}
				//back
				if (bounded(p.x-1,p.y) && visited[p.x-1][p.y]==0 && (p.t+1<map[p.x-1][p.y])) {
					Pair n = new Pair(p.x-1,p.y);
					n.t = p.t+1;
					q.add(n);
				}
				//up
				if (bounded(p.x,p.y+1) && visited[p.x][p.y+1]==0 && (p.t+1<map[p.x][p.y+1])) {
					Pair n = new Pair(p.x,p.y+1);
					n.t = p.t+1;
					q.add(n);
				}
				//down
				if (bounded(p.x,p.y-1) && visited[p.x][p.y-1]==0 && (p.t+1<map[p.x][p.y-1])) {
					Pair n = new Pair(p.x-1,p.y-1);
					n.t = p.t+1;
					q.add(n);
				}
				visited[p.x][p.y] = -1;
			}
		}
	}
	
	private static boolean bounded(int x, int y) {
		if (0<=x && x<=300 && 0<=y && y<=300){
			return true;
		}
		return false;
	}

	static class Pair{
		int x, y, t;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}

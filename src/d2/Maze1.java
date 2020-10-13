package d2;

import java.util.*;


public class Maze1 {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();
		int H = sc.nextInt();
		sc.nextLine();
		
		char[][] maze = new char[2*H+1][2*W+1];
		Queue<Coords> q = new LinkedList<Coords>();
		for (int h=0; h<2*H+1; h++){
			String line = sc.nextLine();
			for (int w=0; w<2*W+1; w++){
				if (line.charAt(w)==' '){
					maze[h][w] = '.';
					if (h==0 || h==2*H || w==0 || w==2*W){
						Coords exit = new Coords(h, w);
						exit.dist = 1;
						q.add(exit);
						maze[h][w] = 'X';
					}
				}else{
					maze[h][w] = 'W';
				}
			}				
		}
		
		
		while (!q.isEmpty()){
//			int t = 0;
			Coords cur = q.poll();
			
			if (done(maze)){
				System.out.println((cur.dist+1)/2);
				break;
			}
			
			for (int i=0; i<4; i++){
				Coords next = new Coords(cur.x+dx[i], cur.y+dy[i]);
				next.dist = cur.dist+1;
				
				if (next.x<0 || next.y<0 || next.x>(2*H) || next.y>(2*W)){
					continue;
				}
				
				if (maze[next.x][next.y]=='X' || maze[next.x][next.y]=='W'){
					continue;
				}
				
				q.add(next);
				
				maze[next.x][next.y] = 'W';
//				t++;
			}
			
//			if (t==0){//dead end
//				System.out.println(cur.dist);
//				break;
//			}
			sc.close();
		}
	}
	
	private static boolean done(char[][] maze) {
		for (int i=0; i<maze.length; i++){
			for (int j=0; j<maze[0].length; j++){
				if (maze[i][j]=='.'){
					return false;
				}
			}
		}
		return true;
	}

	static class Coords{
		int x;
		int y;
		int dist;
		Coords(int x, int y){
			this.x = x;
			this.y =y;
		}
	}
}

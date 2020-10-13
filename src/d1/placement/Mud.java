package d1.placement;

import java.io.*;
import java.util.*;

public class Mud {
	static int ans = Integer.MAX_VALUE;
	static int[] dx = {1, 0,-1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int Bx, By;
	static int[][] mat;
	static fj cur;
	static fj next;
	
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.
		Scanner sc = new Scanner(System.in);
		Bx = sc.nextInt()+500;
		By = sc.nextInt()+500;
		int numberOfPuddles = sc.nextInt();
		
		mat = new int[1001][1001];
		for (int i=0; i<numberOfPuddles; i++){
			int px = sc.nextInt()+500;
			int py = sc.nextInt()+500;
			mat[px][py] = -1;
		}
		
		cur = new fj();
		cur.x = 500;
		cur.y = 500;
		cur.steps = 0;
		bfs();
		sc.close();
	}
	
	public static int bfs(){
		mat[cur.x][cur.y] = -1;
		Queue<fj> q = new LinkedList<fj>();
		next = new fj();
		q.add(cur);
		
		while (!q.isEmpty()){
			cur = q.poll();
			
			if (cur.x==Bx && cur.y==By){
				System.out.println(cur.steps);
				return 0;
			}
				
			for (int i=0; i<4; i++){
				next = new fj();
				next.x = cur.x+dx[i];
				next.y = cur.y+dy[i];
				next.steps = cur.steps+1;
				
				if (next.x<0 || next.y<0 || next.x>1000 || next.y>1000){
					continue;
				}
				
				if (mat[next.x][next.y]==-1){
					continue;
				}
				
				q.add(next);
				
				mat[next.x][next.y] = -1;
			}
		}
		
		return 0;
	}
	public static class fj{
		int x, y, steps;
	}
}

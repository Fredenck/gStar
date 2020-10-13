package d2;

import java.util.*;

public class Tractor {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args){
		LinkedList<Coords> ll = new LinkedList<Coords>();
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Fx = sc.nextInt()-1;
		int Fy = sc.nextInt()-1;
		int[][] field = new int[1000][1000];
		
		ll.add(new Coords(Fx, Fy));
		field[Fx][Fy] = -1;//-1 is visited, 8 is haybale
		
		for (int i=0; i<N; i++){
			int hx = sc.nextInt()-1;//indexing
			int hy = sc.nextInt()-1;
			field[hx][hy] = 8;
		}
		
		while (!ll.isEmpty()){
			Coords cur = ll.poll();
			
			if (cur.x==N-1 && cur.y==0){
				System.out.println(cur.rem);
				break;
			}
			
			for (int i=0; i<4; i++){
				Coords next = new Coords(cur.x+dx[i], cur.y+dy[i]);
				next.rem = cur.rem;
				
				if (next.x<0 || next.y<0 || next.x>1000 || next.y>1000){
					continue;
				}
				
				if (field[next.x][next.y]==-1){
					continue;
				}
				
				if (field[next.x][next.y]==8){//costs ONE to remove a haybale
					ll.addLast(next);
					next.rem = cur.rem+1;
				}else{//does NOT cost anything to move around
					ll.addFirst(next);
				}
				
				field[next.x][next.y] = -1;
			}
		}	
		sc.close();
	}
	static class Coords{
		int x, y;
		int rem = 0;
		Coords(int x1, int y1){
			x = x1;
			y = y1;
		}
	}
}

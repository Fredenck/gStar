package d6;

import java.util.*;
public class Pie1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		
		int[][] grid = new int[R+2][C+1];
		grid[0][0] = 1;
		for (int r=1; r<R; r++) {
			for (int c=1; c<C; c++) {
				grid[r][c] = sc.nextInt();
				if (r > c){
					grid[r][c] = 0;
				}
			}
		}
		
		for (int c = 1; c <= C; c++) {
			for (int r = 1; r <= R; r++) {
				grid[r][c] += Math.max(Math.max(grid[r-1][c-1], grid[r][c-1]), grid[r+1][c-1]);
			}
		}
		System.out.println(grid[R][C]);
		sc.close();
	}

}

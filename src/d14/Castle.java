package d14;

import java.util.*;

public class Castle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int width = sc.nextInt();
		int height = sc.nextInt();
		boolean[][] castle = new boolean[width*height][width*height];
		
		for (int i=0; i<height; i++){
			for (int j=0; j<width; j++){
				int in = sc.nextInt();
				int idx = i*width+j;
				
				if (in>=8){
					in -= 8;
				}else if (i<height-1){//down
					castle[idx][idx+width] = true;
				}
				
				if (in>=4){
					in -= 4;
				}else if (j<width-1){
					castle[idx][idx+1] = true;
				}
				
				if (in>=2){
					in -= 2;
				}else if (i>0){
					castle[idx][idx-width] = true;
				}
				
				if (in>=1){
					in -= 1;
				}else if (j>0){
					castle[idx][idx-1] = true;
				}
			}
		}
		sc.close();
	}
}
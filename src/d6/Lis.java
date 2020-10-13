package d6;

import java.util.*;

public class Lis {
	static int[] seq;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		seq = new int[N];
		for (int i=0; i<N; i++){
			seq[i] = sc.nextInt();
		}
		System.out.println(lis());
		sc.close();
	}
    public static int lis(){ 
        int lis[] = new int[N]; 
  
        for (int i = 0; i < N; i++){
            lis[i] = 1; 
        }
  
       	//bottom-up
        for (int i = 1; i < N; i++) {//to be tacked
            for (int j = 0; j < i; j++){ //num1
                if (seq[i] > seq[j] && lis[i] < lis[j] + 1){ //add on
                    lis[i] = lis[j] + 1; 
                }
            }
        }

        int max = 0; 
        for (int i:lis){
            if (max < i){
                max = i; 
            }
        }
        return max; 
    } 

}

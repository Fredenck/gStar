package d1.classwork;

import java.util.Scanner;

public class Bds {
	static int N;
	static int fsum;
	static int[] possible;
	
	public static void main (String[] args){

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		fsum = sc.nextInt();
		possible = new int[N];
		
		int num = 1;
		for (int i=0; i<N; i++){
			possible[i] = num;
			num++;
		}
//		System.out.println(Arrays.toString(possible));
		
		int csum;
		int times = 0;
		
		while (true){
			if (times==fact(N)){
				break;
			}
			
			csum = 0;
			for (int i=0; i<N; i++){
				csum += possible[i]*choose(N-1, i);
			}
			
			if (csum==fsum){
				for (int i=0; i<N; i++){
					System.out.print(possible[i]+" ");
				}
				System.out.println();
				break;
			}
			nextPerm(possible);
			times++;
		}
		//System.out.println(Arrays.toString(possible));
		sc.close();
	}
	
    private static int choose(int n, int i) {
		return fact(n)/fact(i)/fact(n-i);
	}

	private static int fact(int n) {
    	int prod = 1;
		for (int i=1; i<=n; i++){
			prod*=i;
		}
		return prod;
	}

	public static void nextPerm(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

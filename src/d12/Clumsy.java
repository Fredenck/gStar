package d12;

import java.util.*;

public class Clumsy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int open = 0;
		int ans = 0;
	    for(int i = 0; i < str.length(); i++){
	        if(str.charAt(i) == '('){
	            open++;
	        }else{
	        	open--;
	        }
	        if(open<0){
	            ans++;
	            open+=2;
	        }
	    }
	    ans += open/2;
	    System.out.println(ans);
	    sc.close();
	}

}

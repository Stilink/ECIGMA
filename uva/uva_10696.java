import java.io.*;
import java.util.*;


public class uva_10696 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while(n!=0) {
			System.out.println("f91("+n+") = "+f91(n));
			n = Integer.parseInt(br.readLine());
			
		}

	}
	
	private static int f91(int n) {
		if(n<=100) {
			return f91(f91(n+11));
		}else {
			return n-10;
		}
	}

}

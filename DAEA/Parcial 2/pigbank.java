import java.io.*;
import java.util.*;

public class pigbank {
	private static int pigw;
	private static int[] pesos;
	private static int[] valores;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		for(int cas = 0; cas < cases; cas++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int in = Integer.parseInt(stk.nextToken());
			int f = Integer.parseInt(stk.nextToken());
			pigw  = f-in;
			int coins = Integer.parseInt(br.readLine());
			valores = new int[coins];
			pesos = new int[coins];
			for(int coin = 0; coin < coins; coin++) {
				stk = new StringTokenizer(br.readLine());
				valores[coin] = Integer.parseInt(stk.nextToken());
				pesos[coin] = Integer.parseInt(stk.nextToken());
				
			}
			int[] ans = new int[pigw+1];
			Arrays.fill(ans, Integer.MAX_VALUE);	
			ans[0]=0;
			for(int i = 0; i<coins; i++) {
				for(int j = 1; j<=pigw; j++) {
					if(pesos[i]<=j && ans[j-pesos[i]]!=Integer.MAX_VALUE) {
						ans[j]=Math.min(ans[j], ans[j-pesos[i]]+valores[i]);
					}
				}
			}
			if(ans[pigw]==Integer.MAX_VALUE) {
				System.out.println("This is impossible.");
			}else {
				System.out.println("The minimum amount of money in the piggy-bank is "+ans[pigw]+".");
			}
		}
		

	}

}

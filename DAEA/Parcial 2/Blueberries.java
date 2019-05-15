import java.io.*;
import java.util.*;

public class Blueberries {
	private static int[] values;
	private static int maxi;
	private static int[][] dp;
	private static int solve(int i, int c) {
		
		if(i>=values.length) {
			if(c>maxi) {
				return -1;
			}else {
				return c;
			}
		}
		if(dp[i][c]!=-1) return dp[i][c];
		if(c>maxi) {
			return -1;
		}else if(c==maxi) {
			return c;
		}else {
			int p1 = solve(i+1,c);
			int p2 = solve(i+2, c+values[i]);
			int p = Math.max(p1, p2);
			dp[i][c]=p;
			return dp[i][c];
		}
		
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		StringTokenizer stk;
		for(int cas = 1; cas <= cases; cas++) {
			stk = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(stk.nextToken());
			maxi = Integer.parseInt(stk.nextToken());
			dp = new int[n+1][maxi+1];
			for(int[] i : dp) Arrays.fill(i, -1);
			values = new int[n];
			stk = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) values[i]=Integer.parseInt(stk.nextToken());
			System.out.println(solve(0,0));
		}

	}

}

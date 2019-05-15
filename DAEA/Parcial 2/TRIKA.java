import java.io.*;
import java.util.*;

public class TRIKA {
	private static int[][] matriz;
	private static int x, y, n, m, mypower;
	private static int[][] ans;
	
	private static int solve(int i, int j) {
		if(i>=n || j>=m) return Integer.MAX_VALUE;
		if(i==(n-1) && j==(m-1)) return ans[i][j]=matriz[i][j];
		if(ans[i][j]!=Integer.MAX_VALUE) return ans[i][j];
		return ans[i][j]= matriz[i][j] + Math.min(solve(i+1, j), solve(i, j+1));
		
		
	}
	public static void main(String[] args) throws Exception{
		/*BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());*/
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		//stk = new StringTokenizer(br.readLine());
		x = sc.nextInt();
		y = sc.nextInt();
		matriz = new int[n][m];
		ans = new int[n][m];
		for(int[] i : ans) Arrays.fill(i, Integer.MAX_VALUE);
		for(int i = 0; i < n; i++) {
			//stk = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				matriz[i][j] = sc.nextInt();
			}
		}
		mypower = matriz[x-1][y-1];
		matriz[x-1][y-1]= 0;
		
		mypower -= solve(x-1, y-1);
		if(mypower<0) {
			System.out.println("N");
		}else {
			System.out.println("Y "+mypower);
		}
		//for(int[] i : ans) System.out.println(Arrays.toString(i));
	}

}

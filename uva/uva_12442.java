import java.io.*;
import java.util.*;

public class uva_12442 {
	private static int[] clan;
	private static boolean[] vi;
	private static int dfs(int s) {
		vi[s]=true;
		int nodosAlcanzados = 1;
		if(!vi[clan[s]]) {
			nodosAlcanzados+=dfs(clan[s]);
		}
		vi[s]=false;
		return nodosAlcanzados;
	}
	
	
	public static void main(String[] args) throws Exception{
		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		for(int c = 1; c<=cases; c++) {
			int n = Integer.parseInt(br.readLine());
			clan = new int[n];
			vi = new boolean[n];
			StringTokenizer stk;
			for(int i = 0; i <n; i++) {
				stk = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(stk.nextToken());
				int v = Integer.parseInt(stk.nextToken());
				clan[u-1]=v-1;
				vi[u-1]=false;
			}
			int maximo = Integer.MIN_VALUE;
			int nodo = Integer.MAX_VALUE;
			for(int i=0; i<n;i++ ) {
				int res = dfs(i);
				if(res>maximo) {
					maximo=res;
					nodo=i;
				}else if(res==maximo) {
					nodo=Math.min(i, nodo);
				}
			}
			out.println("Case "+c+": "+(nodo+1));
			
			
		}
		out.close();
		out.flush();
		

	}

}

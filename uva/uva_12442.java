import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class uva_12442 {
	private static int[] clan = new int[50050];
	private static boolean[] vi = new boolean[50050];
	private static int[] resp = new int[50050];
	private static int dfs(int s) {
		vi[s]=true;
		int nodosAlcanzados = 1;
		if(!vi[clan[s]]) {
			nodosAlcanzados+=dfs(clan[s]);
		}
		vi[s]=false;
		return resp[s]=nodosAlcanzados;
		}
	
	
	public static void main(String[] args) throws Exception{
		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		for(int c = 1; c<=cases; c++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer stk;
			for(int i = 0; i <n; i++) {
				stk = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(stk.nextToken());
				int v = Integer.parseInt(stk.nextToken());
				clan[u-1]=v-1;
				vi[u-1]=false;
				resp[u-1]=Integer.MAX_VALUE;
			}
			int maximo = Integer.MIN_VALUE;
			int nodo = Integer.MAX_VALUE;
			for(int i=0; i<n;i++ ) {
				if(resp[i]==Integer.MAX_VALUE) {
					int res = dfs(i);
					if(res>maximo) {
						maximo=res;
						nodo=i;
					}else if(res==maximo) {
						nodo=Math.min(i, nodo);
					}
				}
				
			}
			out.println("Case "+c+": "+(nodo+1));
			
			
		}
		out.close();
		out.flush();
		

	}

}

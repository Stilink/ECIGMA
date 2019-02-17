import java.io.*;
import java.util.*;

public class uva_12442 {
	private static Map<Integer,ArrayList<Integer>> clan;
	private static int dfs(int s, boolean[] vi) {
		vi[s-1]=true;
		int nodosAlcanzados = 1;
		for(int v : clan.get(s)) {
			if(!vi[v-1]) {
				nodosAlcanzados=Math.max(nodosAlcanzados, dfs(v, vi))+1;
				vi[v-1]=false;
			}
		}
		return nodosAlcanzados;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		for(int c = 1; c<=cases; c++) {
			int n = Integer.parseInt(br.readLine());
			clan = new HashMap<Integer,ArrayList<Integer>>();
			StringTokenizer stk;
			for(int i = 0; i <n; i++) {
				stk = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(stk.nextToken());
				int v = Integer.parseInt(stk.nextToken());
				clan.put(u,clan.getOrDefault(u,new ArrayList<Integer>()));
				clan.get(u).add(v);
			}
			int maximo = Integer.MIN_VALUE;
			int nodo = Integer.MAX_VALUE;
			for(int s : clan.keySet()) {
				int res = dfs(s,new boolean[n]);
				if(res>maximo) {
					maximo=res;
					nodo=s;
				}else if(res==maximo) {
					nodo=Math.min(s, nodo);
				}
			}
			System.out.println("Case "+c+": "+nodo);
			
			
		}
		

	}

}

import java.io.*;
import java.util.*;

public class uva_1112 {
	public static int dijkstra(Map<Integer,ArrayList<Pair>> graph,int t,int e,int n) {
		boolean[] vi=new boolean[n];
		int[] dist=new int[n];
		for(int i=0;i<n;i++) dist[i]=10000;
		Queue<Pair> dq=new PriorityQueue<Pair>();
		vi[e]=true;
		dist[e]=0;
		dq.add(new Pair(e,0));
		while(!dq.isEmpty()) {
			Pair u=dq.remove();
			vi[u.v]=true;
			for(int i=0;i<graph.get(u.v).size();i++) {
				Pair v=graph.get(u.v).get(i);
				if(!vi[v.v]) {
					if(dist[u.v]+v.w<dist[v.v]) {
						dist[v.v]=dist[u.v]+v.w;
						dq.add(new Pair(v.v,dist[v.v]));
					}
				}
			}
		}
		int sum=0;
		for(int i=0;i<n;i++)if(dist[i]<=t)sum++;
		return sum;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		for(int i=0;i<cases;i++) {
			br.readLine();

			
			int n=Integer.parseInt(br.readLine());
			int exit=Integer.parseInt(br.readLine())-1;
			int time=Integer.parseInt(br.readLine());
			int connections=Integer.parseInt(br.readLine());
			Map<Integer,ArrayList<Pair>> graph=new HashMap<Integer,ArrayList<Pair>>();
			for(int nodo=0;nodo<n;nodo++) {
				graph.put(nodo,new ArrayList<Pair>());
			}
			for(int j=0;j<connections;j++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int u=Integer.parseInt(st.nextToken());
				int v=Integer.parseInt(st.nextToken());
				int w=Integer.parseInt(st.nextToken());
				graph.get(v-1).add(new Pair(u-1,w));
			}
			System.out.println(dijkstra(graph,time,exit,n));
			if(i<cases-1)System.out.println();
		}
	}
	public static class Pair implements Comparable<Pair>{
		int v,w;
		public Pair(int v, int w) {
			this.v=v;
			this.w=w;
		}
		@Override
		public int compareTo(Pair u) {
			return w-u.w;
		}
		@Override
		public String toString() {
			return "nodo "+v+" peso "+w;
		}
	}
		
}

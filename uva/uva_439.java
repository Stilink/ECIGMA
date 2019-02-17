import java.io.*;
import java.util.*;

public class uva_439 {

	public static void main(String[] args)throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String k;
		while((k=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(k);
			String ini=st.nextToken(),fin=st.nextToken();
			int xI=ini.charAt(0)-97;
			int yI=ini.charAt(1)-49;
			int xF=fin.charAt(0)-97;
			int yF=fin.charAt(1)-49;
			boolean[][] vi=new boolean[8][8];
			int[][] dist=new int[8][8]; 
			int[][] coor={{-1, -2}, {1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, -1}, {2, 1}};
			Deque<Pair> dq=new LinkedList<Pair>();
			dq.add(new Pair(xI,yI));
			vi[xI][yI]=true;
			dist[xI][yI]=0;
			while(!dq.isEmpty()) {
				Pair top=dq.removeFirst();
				if(top.x==xF && top.y==yF) {					
					System.out.println("To get from "+ini+" to "+fin+" takes "+dist[xF][yF]+" knight moves.");
					break;
				}
				for(int i=0;i<8;i++) {
					if(top.x+coor[i][1]>=0 &&top.x+coor[i][1]<=7 && top.y+coor[i][0]>=0 &&top.y+coor[i][0]<=7) {
						if(!vi[top.x+coor[i][1]][top.y+coor[i][0]]) {
							vi[top.x+coor[i][1]][top.y+coor[i][0]]=true;
							dq.add(new Pair(top.x+coor[i][1],top.y+coor[i][0]));
							dist[top.x+coor[i][1]][top.y+coor[i][0]]=dist[top.x][top.y]+1;
						}
					}
				}
			}
			
		}
	}
	public static class Pair{
		int x,y;
		public Pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}

}

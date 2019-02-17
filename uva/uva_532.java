import java.io.*;
import java.util.*;
public class uva_532 {
	public static int[] coorX= {-1,0,1,0};
	public static int[] coorY= {0,-1,0,1};
	public static int bfs(char[][][] maze,boolean vi[][][],Triple ini,Triple fin,int [][][]dist) {
		Deque<Triple> dq=new LinkedList<Triple>();
		dq.addLast(ini);
		vi[ini.z][ini.x][ini.y]=true;
		dist[ini.z][ini.x][ini.y]=0;
		while(!dq.isEmpty()) {
			Triple top=dq.removeFirst();
			if (top.equals(fin))return dist[top.z][top.x][top.y];
			int k=dist[top.z][top.x][top.y]+1;
			if(top.z>0) {
				if(maze[top.z-1][top.x][top.y]!='#' && !vi[top.z-1][top.x][top.y]) {
					dq.addLast(new Triple(top.x,top.y,top.z-1));
					vi[top.z-1][top.x][top.y]=true;
					dist[top.z-1][top.x][top.y]=k;
				}
			}
			if(top.z<maze.length-1) {
				if(maze[top.z+1][top.x][top.y]!='#' && !vi[top.z+1][top.x][top.y]) {
					dq.addLast(new Triple(top.x,top.y,top.z+1));
					vi[top.z+1][top.x][top.y]=true;
					dist[top.z+1][top.x][top.y]=k;
				}
			}
			for(int i=0;i<4;i++) {
				if(top.x+coorX[i]>=0 &&top.x+coorX[i]<=maze[0].length-1 &&  top.y+coorY[i]>=0 &&top.y+coorY[i]<=maze[0][0].length-1) {
					if(!vi[top.z][top.x+coorX[i]][top.y+coorY[i]] && maze[top.z][top.x+coorX[i]][top.y+coorY[i]]!='#') {
						dq.addLast(new Triple(top.x+coorX[i],top.y+coorY[i],top.z));
						vi[top.z][top.x+coorX[i]][top.y+coorY[i]]=true;
						dist[top.z][top.x+coorX[i]][top.y+coorY[i]]=k;
					}
				}
			}
		}
		return -1;
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer line=new StringTokenizer(br.readLine());
			int z=Integer.parseInt(line.nextToken()),x=Integer.parseInt(line.nextToken()),y=Integer.parseInt(line.nextToken());
			if(z==0 && x==0 && y==0)break;
			char[][][] maze=new char[z][x][y];
			Triple ini=new Triple(0,0,0),fin=new Triple(0,0,0);
			for(int i=0;i<z;i++) {
				for(int j=0;j<x;j++) {
					maze[i][j]=br.readLine().toCharArray();
					for(int k=0;k<y;k++) {
						if(maze[i][j][k]=='S')ini=new Triple(j,k,i); 
						if(maze[i][j][k]=='E') fin=new Triple(j,k,i);
					}
				}
				br.readLine();
			}
			boolean[][][] vi=new boolean[z][x][y];
			int[][][] dist=new int[z][x][y];
			int qt=bfs(maze,vi,ini,fin,dist);
			if (qt==-1)System.out.println("Trapped!");
			else System.out.println("Escaped in "+qt+" minute(s).");
		}

	}
	public static class Triple{
		int x,y,z;
		public Triple(int x,int y,int z) {
			this.x=x;
			this.y=y;
			this.z=z;
		}
		public boolean equals(Triple o) {
			return o.x==x && o.y==y && o.z==z;
		}
	}

}

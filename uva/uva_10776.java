import java.io.*;
import java.util.*;


public class uva_10776 {
	private static StringBuilder ans;
	private static int[] v;
	
	private static void fun(char[] cadena,int n, int  ind,StringBuilder temp) {
		if(temp.length()==n) {
			ans.append(temp.toString()+"\n");
		}else {
			for(int i = ind; i < cadena.length; i++) {
				
				if(v[i]!=1) {
					v[i]=1;
					temp.append(cadena[i]);
					fun(cadena, n, i, temp);
					temp.deleteCharAt(temp.lastIndexOf(""+cadena[i]));
					v[i]=0;
					while(i<cadena.length-1 && cadena[i]==cadena[i+1])i++;
					
				}
				/*if(i<cadena.length-1 && cadena[i]==cadena[i+1]) {
					i++;
				}*/
			}
			
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		StringTokenizer stk;
		while((linea = br.readLine())!=null) {
			ans= new StringBuilder();
			stk = new StringTokenizer(linea);
			String cadena = stk.nextToken();
			v = new int[cadena.length()];
			char[] c = cadena.toCharArray();
			Arrays.sort(c);
			int n = Integer.parseInt(stk.nextToken());
			fun(c, n, 0, new StringBuilder());
			System.out.print(ans);
		}
		

	}

}

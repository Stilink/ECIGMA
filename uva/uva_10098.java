import java.io.*;
import java.util.*;


public class uva_10098 {
	private static StringBuilder ans;
	private static int[] v;
	
	private static void fun(char[] cadena,StringBuilder temp) {
		if(temp.length()==cadena.length) {
			ans.append(temp.toString()+"\n");
		}else {
			for(int i = 0; i < cadena.length; i++) {
				
				if(v[i]!=1) {
					v[i]=1;
					temp.append(cadena[i]);
					fun(cadena, temp);
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
		int cases = Integer.parseInt(br.readLine());
		for(int i = 0; i < cases; i++) {
			ans= new StringBuilder();
			String cadena = br.readLine();
			v = new int[cadena.length()];
			char[] c = cadena.toCharArray();
			Arrays.sort(c);
			fun(c,new StringBuilder());
			System.out.println(ans);
			
		}
		

	}

}
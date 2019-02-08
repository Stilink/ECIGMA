import java.io.*;
import java.util.*;


public class uva_195 {
	private static StringBuilder ans;
	private static int[] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		for(int cas = 0; cas < cases; cas++) {
			String cadena = br.readLine();
			ArrayList<Character> ca = new ArrayList<Character>();
			for(int i = 0; i < cadena.length(); i++) {
				ca.add(cadena.charAt(i));
			}
			Collections.sort(ca, new Comparator<Character>() {
				@Override
				public int compare(Character one, Character two) {
					if(Character.toLowerCase(one)==Character.toLowerCase(two)) {
						return one-two;
					}else return Character.toLowerCase(one)-Character.toLowerCase(two);
					
				
				}
				
			});
			ans = new StringBuilder();
			v = new int[ca.size()];
			fun(ca, new StringBuilder());
			System.out.print(ans.toString());
		}
	}
	private static void fun(ArrayList<Character> cadena,StringBuilder temp) {
		if(temp.length()==cadena.size()) {
			ans.append(temp.toString()+"\n");
		}else {
			for(int i = 0; i < cadena.size(); i++) {
				
				if(v[i]!=1) {
					v[i]=1;
					temp.append(cadena.get(i));
					fun(cadena, temp);
					temp.deleteCharAt(temp.lastIndexOf(""+cadena.get(i)));
					v[i]=0;
					while(i<cadena.size()-1 && cadena.get(i)==cadena.get(i+1))i++;
					
				}
				/*if(i<cadena.length-1 && cadena[i]==cadena[i+1]) {
					i++;
				}*/
			}
			
		}
	}
}
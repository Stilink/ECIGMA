import java.util.*;
import java.io.*;
 
class New_Distinct_Substrings {
 
	static int[] RA, tempRA, SA,tempSA, c,phi,LCP,PLCP;
	static int n;
	static char[] T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		for(int c = 0; c<cases; c++) {
		T = (br.readLine()+"$").toCharArray();
		n = T.length;
		RA = new int[n]; tempRA = new int[n];
		SA = new int[n]; tempSA = new int[n];
		LCP = new int[n]; PLCP = new int[n];
		buildSA();
		LCP();
		/*System.out.println(Arrays.toString(LCP));
		System.out.println(Arrays.toString(SA));*/
		/*for(int i = 0; i < n; i++){
			System.out.print(SA[i]+" ");
			System.out.print(LCP[i]+" ");
			System.out.println(String.valueOf(T).substring(SA[i]));
		}*/
		System.out.println(countDistinctSubstring(T)-T.length);}
	}
 
	static void radixSort(int k){
		int sum,maxi = Math.max(n, 300);
		c = new int[100010];
		for(int i = 0; i < n; i++){
			c[i+k<n ? RA[i+k] : 0]++;
		}
		for(int i = sum = 0; i < maxi; i++){
			int t = c[i];
			c[i] = sum;
			sum+=t;
		}
		for(int i = 0; i < n; i++)
			tempSA[c[SA[i]+k < n ?  RA[SA[i]+k]: 0]++] = SA[i];
		for(int i=0; i < n; i++)
			SA[i] = tempSA[i];
	}
 
	static void buildSA(){
		int r;
		for(int i = 0; i < n; i++) RA[i] = T[i];
		for(int  i = 0; i < n; i++) SA[i] = i;
		for(int k = 1; k < n; k<<=1){
			radixSort(k);
			radixSort(0);
			tempRA[SA[0]] = r= 0;
			for(int i = 1; i < n; i++)
				tempRA[SA[i]] = (RA[SA[i]] == RA[SA[i-1]] && RA[SA[i]+k] == RA[SA[i-1]+k]) ? r : ++r;
			for(int i = 0; i <n; i++)
				RA[i] = tempRA[i];
			if (RA[SA[n-1]] == n-1) break;
		}
	}
 
	static void LCP(){
		int L;
		phi = new int[n];
		phi[SA[0]] = -1;
		for(int i = 1; i < n; i++)
			phi[SA[i]] = SA[i-1];
 
		for(int i = L=0; i <n;i++){
			if (phi[i] == -1) {PLCP[i] = 0; continue;}
			while(T[i+L] == T[phi[i] + L]) L++;
			PLCP[i] = L;
			L = Math.max(L-1,0);
		}
		for(int i = 0; i < n; i++)
			LCP[i] = PLCP[SA[i]];
	}
	
	static int countDistinctSubstring(char[] txt) {
		int n = txt.length;
		
		
		int result = n-SA[0];
		for(int i = 1; i < n; i++) {
			result += (n-SA[i])-LCP[i];
		}
		return result;
	}
 
 
}

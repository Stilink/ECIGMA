import java.util.*;
import java.io.*;
 
class uva_760 {
 
	static int[] RA, tempRA, SA,tempSA, c,phi,LCP,PLCP;
	static int n;
	static char[] T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String linea1 = br.readLine();
			String linea2 = br.readLine();
			if(linea1.length()==0 || linea2.length()==0) break;
			T = (linea1+"#"+linea2+"$").toCharArray();
			n = T.length;
			RA = new int[n]; tempRA = new int[n];
			SA = new int[n]; tempSA = new int[n];
			LCP = new int[n]; PLCP = new int[n];
			buildSA();
			LCP();
			int maxi = Integer.MIN_VALUE;
			ArrayList<Integer> inds = new ArrayList<Integer>();
			for(int i = 0; i<n; i++) {
				if(LCP[i]>maxi) {
					maxi=LCP[i];
					inds.clear();
					inds.add(i);
				}else if(LCP[i]==maxi) {
					inds.add(i);
				}
			}
			if(inds.size()==0) {
				System.out.println("No common sequence.");
				System.out.println();
				br.readLine();
				continue;
			}
			for(int i : inds) {
				if(0<=i-1 && i-1<n) {
					String subs = String.valueOf(T).substring(SA[i-1],SA[i-1]+LCP[i]);
					if(subs.length()>linea2.length()+2) {
						if(linea2.contains(subs)) {
							System.out.println(subs);
						}
					}else{
						if(linea1.contains(subs)) {
							System.out.println(subs);
						}
					}
					
				}
			}
			System.out.println();
			br.readLine();
		}
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
 
 
}
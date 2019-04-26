import java.util.*;
import java.io.*;
 
class uva_760 {
 
	static int[] RA, tempRA, SA,tempSA, c,phi,LCP,PLCP;
	static int n;
	static char[] T;
	static Set<String> ansSet = new HashSet<String>();
	static ArrayList<String> ansPrint = new ArrayList<String>();
	public static void main(String[] args) throws Exception {
		
		File FILE = new File("input.txt");
		BufferedReader br = FILE.exists() ? new BufferedReader(new FileReader(FILE)) :  new BufferedReader(new InputStreamReader(System.in));
		
		boolean first = true;
		while(true) {
			if( !first )
				System.out.println();
			first = false;
			String linea1 = br.readLine();
			if(linea1==null) break;
			String linea2 = br.readLine();
			if(linea2==null) break;
			T = (linea1+"#"+linea2+"$").toCharArray();
			n = T.length;
			RA = new int[n]; tempRA = new int[n];
			SA = new int[n]; tempSA = new int[n];
			LCP = new int[n]; PLCP = new int[n];
			buildSA();
			LCP();
			ansSet.clear();
			ansPrint.clear();
			int maxi = LCP[0];
			ArrayList<Integer> inds = new ArrayList<Integer>();
			for(int i = 0; i<n; i++) {
				if(i==0) continue;
				if(LCP[i]>maxi && linea1.contains(String.valueOf(T).substring(SA[i-1],SA[i-1]+LCP[i])) && linea2.contains(String.valueOf(T).substring(SA[i-1],SA[i-1]+LCP[i]))) {

					maxi=LCP[i];

					ansSet.clear();
					ansPrint.clear();

					ansSet.add(String.valueOf(T).substring(SA[i-1],SA[i-1]+LCP[i]));
					ansPrint.add(String.valueOf(T).substring(SA[i-1],SA[i-1]+LCP[i]));
				}else if(LCP[i]==maxi) {


					if(!ansSet.contains(String.valueOf(T).substring(SA[i-1],SA[i-1]+LCP[i]))) {
						ansPrint.add(String.valueOf(T).substring(SA[i-1],SA[i-1]+LCP[i]));
						ansSet.add(String.valueOf(T).substring(SA[i-1],SA[i-1]+LCP[i]));
					}
					
				}
			}
			/*System.out.println(ansSet.size()+" Set: "+ansSet.toString());
			System.out.println(ansPrint.toString());*/
			if(ansSet.size()==1 && ansSet.contains("")) {
				

				System.out.println("No common sequence.");
				String blank = br.readLine();
				if(blank==null) break;
				continue;
			}
			
			for (String i : ansPrint) {
				if(linea1.contains(i) && linea2.contains(i)) {
					System.out.println(i);
				}
				
			}

			String blank = br.readLine();
			if(blank==null) break;
		}
		br.close();
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

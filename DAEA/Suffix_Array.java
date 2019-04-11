import java.util.*;
import java.io.*;

public class Suffix_Array {
	static int[] RA, tempRA, SA,tempSA, c;
	static int n;
	static char[] T;
	public static void main(String[] args) throws IOException {
		T = ("banana"+"$").toCharArray();
		n = T.length;
		RA = new int[n]; tempRA = new int[n];
		SA = new int[n]; tempSA = new int[n];
		buildSA();
		for(int i = 0; i < n; i++){
			System.out.print(SA[i]+" ");
			System.out.println(String.valueOf(T).substring(SA[i]));
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
}


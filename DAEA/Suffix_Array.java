import java.util.*;
import java.io.*;

public class Suffix_Array {
	private static int[] suffixArr; 
	private static int[] lcp; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		for(int cas=0; cas<cases; cas++) {
			Set<Character> comprobar = new HashSet<Character>();
			char[] txt = br.readLine()/*.toLowerCase()*/.toCharArray();
			for(char i : txt) comprobar.add(i);
			
			int n = txt.length;
			buildSuffixArray(txt, n);
			kasai(txt);
			int ans= solve();
			System.out.println((comprobar.size()==1)?ans-1:ans);
		}
		/*for(int i = 0; i < n; i++) {
			System.out.println("mississippi".substring(suffixArr[i])+" Indice:"+suffixArr[i]);
		}*/

	}
	
	private static void buildSuffixArray(char[] txt, int n) {
		ArrayList<suffix> suffixes = new ArrayList<suffix>();	
		for(int i = 0; i<n; i++) {
			suffixes.add(new suffix());
			suffixes.get(i).index = i;
			suffixes.get(i).rank[0] = txt[i]-'a';
			suffixes.get(i).rank[1] = ((i+1) < n) ? (txt[i+1]-'a'):-1;
		}
		Collections.sort(suffixes, new cmp());
		int[] ind = new int[n];
		for(int k = 4; k<2*n; k*=2) {
			int rank = 0;
			int prev_rank = suffixes.get(0).rank[0];
			suffixes.get(0).rank[0]=rank;
			ind[suffixes.get(0).index] = 0;
			
			for(int i = 1; i<n; i++) {
				if(suffixes.get(i).rank[0]== prev_rank && 
						suffixes.get(i).rank[1]==suffixes.get(i).rank[1]) {
					prev_rank = suffixes.get(i).rank[0];
					suffixes.get(i).rank[0]= rank;
				}
				else {
					prev_rank = suffixes.get(i).rank[0];
					suffixes.get(i).rank[0]= ++rank;
				}
				ind[suffixes.get(i).index]=i;
			}
			for(int i = 0; i<n; i++) {
				int nextindex = suffixes.get(i).index + k/2;
				suffixes.get(i).rank[1] = (nextindex < n)? 
						suffixes.get(ind[nextindex]).rank[0]:-1;
				
			}
			
			Collections.sort(suffixes, new cmp());
		}
		suffixArr = new int[n];
		for( int i = 0; i<n; i++) {
			suffixArr[i] = suffixes.get(i).index;
			
		}
	//System.out.println(Arrays.toString(suffixArr));	
	}
	
	private static void kasai(char[] txt) {
		int n = suffixArr.length;
		lcp = new int[n];
		int[] invSuff = new int[n];
		
		for(int i=0; i<n; i++) invSuff[suffixArr[i]]=i;
		int k = 0;
		for(int i = 0; i<n; i++) {
			if(invSuff[i]==n-1) {
				k=0;
				continue;
			}
			int j=suffixArr[invSuff[i]+1];
			
			while(i+k<n && j+k<n && txt[i+k]==txt[j+k]) k++;
			
			lcp[invSuff[i]] = k;
			if(k>0) k--;
		}
		//System.out.println(Arrays.toString(lcp));
	}
	
	
	private static int solve() {
		int result = suffixArr.length- suffixArr[0];
		for(int i = 1; i<lcp.length; i++) {
			result += (suffixArr.length-suffixArr[i])-lcp[i-1];
		}
		return result;
	}
	
	private static class suffix{
		int index;
		int[] rank = new int[2];
		
		@Override
		public String toString(){
			return "Index: "+index + " Rank: ("+rank[0]+", "+rank[1]+")";
		}

	}
	private static class cmp implements Comparator<suffix>{
		@Override
		public int compare(suffix a,suffix b) {
			return (a.rank[0] == b.rank[0])? (a.rank[1] < b.rank[1] ?-1: 0): 
	            (a.rank[0] < b.rank[0] ?-1: 0);
		}
	}
}

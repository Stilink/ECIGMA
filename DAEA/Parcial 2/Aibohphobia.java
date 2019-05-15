import java.io.*;
import java.util.*;

public class Aibohphobia {
	private static char[] word;
	private static int[][] ans;
	
	
	private static int re(int i, int j) {
		if(ans[i][j]!=-1) return ans[i][j];
		if(i>j) {
			return 0;
		}else if(i==j) {
			return 0;
		}else if(i==j-1) {
			if(word[i]==word[j]) return 0;
			else return 1;
		}else {
			if(word[i]==word[j]) {
				ans[i][j]= re(i+1,j-1);
				return ans[i][j];
			}else {
				ans[i][j]= 1+Math.min(re(i+1,j), re(i,j-1));
				return ans[i][j];
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		for(int cas = 0; cas < cases; cas++) {
			word = br.readLine().toCharArray();
			ans = new int[word.length][word.length];
			for(int i = 0; i < word.length; i++) Arrays.fill(ans[i], -1);
			System.out.println(re(0, word.length-1));
		}

	}

}

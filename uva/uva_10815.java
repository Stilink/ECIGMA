import java.io.*;
import java.util.*;

public class uva_10815 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		Set<String> words = new HashSet<String>();
		while((linea=br.readLine())!=null) {
			linea = linea.toLowerCase();
			StringBuilder word = new StringBuilder();
			for(int i = 0; i<linea.length();i++) {
				char c = linea.charAt(i);
				if(!('a'<=c && c<='z')) {
					if(word.length()>0) {
						words.add(word.toString());
						word = new StringBuilder();
					}
					}else {
					word.append(c);
				}
			}
			if(word.length()>0) {
				words.add(word.toString());
			}
			
		}
		ArrayList<String> wds = new ArrayList<String>();
		wds.addAll(words);
		Collections.sort(wds);
		for(int i=0; i < wds.size();i++ ) {
			System.out.println(wds.get(i));
		}

	}

}

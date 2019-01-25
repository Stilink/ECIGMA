import java.util.*;
public class DerivativeSequence {

	/*public static void main(String[] args) {
		DerivativeSequence ds = new DerivativeSequence();
		int[] vector = {5,6,3,9,-1};
		System.out.println(Arrays.toString(ds.derSeq(vector , 1)));
		
		int[] vector1 = {5,6,3,9,-1};
		System.out.println(Arrays.toString(ds.derSeq(vector1 , 2)));
		
		int[] vector11 = {5,6,3,9,-1};
		System.out.println(Arrays.toString(ds.derSeq(vector11 , 4)));
		
		int[] vector111 = {-100,100};
		System.out.println(Arrays.toString(ds.derSeq(vector111 , 0)));
		
		
	}*/
	public int[] derSeq(int[] a,int n) {
		if(n == 0) {
			return a;
		}
		int[] temp = new int[a.length-1];
		for(int i = 0; i<temp.length;i++) {
			temp[i]= a[i+1]-a[i];
		}
		return derSeq(temp, n-1);
	}

}

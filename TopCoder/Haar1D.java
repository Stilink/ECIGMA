import java.util.*;

public class Haar1D {

	/*public static void main(String[] args) {
		Haar1D h1d = new Haar1D();
		int[] p = {1, 2, 3, 4, 4, 3, 2, 1};
		System.out.println(Arrays.toString(h1d.transform(p
, 3)));
		
	}*/
	
	public int[] transform(int[] data, int L) {
		return transformDelta(data, L, data.length);
	}
	private int[] transformDelta(int[] data, int L, int size) {
		if(L <= 0) {
			return data;
		}else {
			int[] temp = data.clone();
			/* Sumas*/
			int it=0;
			for(int i =0; i < size; i+=2) {
				temp[it]=data[i]+data[i+1];
				it++;
			}
			//Restas
			for(int i =0; i < size; i+=2) {
				temp[it]=data[i]-data[i+1];
				it++;
			}
			return transformDelta(temp, L-1, size/2);
		}
	}

}

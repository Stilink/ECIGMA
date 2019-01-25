import java.util.*;
public class Truckloads {
	private int result = 0;

	/*public static void main(String[] args) {
		Truckloads tl = new Truckloads();
		System.out.println(tl.numTrucks(14, 3));
		
		System.out.println(tl.numTrucks(1024,5));
		
		System.out.println(tl.numTrucks(15, 1));

	}*/
	
	
	
	public int numTrucks(int numCrates, int loadSize) {
		result= 0;
		trucks(numCrates, loadSize);
		return result;
	}
	
	
	private void trucks(int numCrates, int loadSize) {
		if(loadSize>= numCrates) {
			result+=1;
			return;
		}
		if(numCrates%2!=0) {
			trucks((int)(numCrates/2), loadSize);
			trucks((int)(numCrates/2)+1, loadSize);
			return;
		}else {
			trucks((int)(numCrates/2), loadSize);
			trucks((int)(numCrates/2), loadSize);
			return;
		}
		
	}

}

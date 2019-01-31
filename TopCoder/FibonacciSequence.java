
public class FibonacciSequence {
	
	int[] fb = new int[18];
	public FibonacciSequence() {
		fb[0]=1;
		fb[1]=1;
		for(int i = 2; i < 18; i++) {
			fb[i]=fb[i-2]+fb[i-1];
		}
	}

	/*public static void main(String[] args) {
		FibonacciSequence fb = new FibonacciSequence();
		System.out.println(fb.numFibs(2, 5));

	}*/
	
	public int numFibs(int a, int b) {
		int cnt = 0;
		for(int i = 0; i < 18; i++) {
			if(a<=fb[i] && fb[i]<=b) {
				cnt++;
			}
			
		}
		return cnt;		
	}

}

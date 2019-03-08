import java.util.Arrays;


public class MainExperimentalAnalisys {
	private static final int CORRECTNESS_EXP_COUNT = 30000;
	private static final int INCREMENT = 1000;
	private static final int MAX_SIZE = 20000;
	private static final int MIN_SIZE = 1000;
	private static final int EXPERIMENTS_BY_SIZE = 7;
	//private static int w;
	public static void main(String[] args) {
		experimentalCorrectness();
		System.out.println("");
		experimentalComplexity();
		verifyExperimentalComplexity();
		int size = 131000212;
		System.out.println(" Time for "+size);
		long times[] = runExperiment(size);
		System.out.println(size+"\t"+times[times.length/2]);
		System.out.println(experimentalEspectedTime(size));

	}
	private static void verifyExperimentalComplexity() {
		for (int size = MIN_SIZE; size <= MAX_SIZE; size += INCREMENT)
			System.out.println(size+"\t"+experimentalEspectedTime(size));		
	}
	private static void experimentalComplexity() {

		for (int size = MIN_SIZE; size <= MAX_SIZE; size += INCREMENT)
		{
			long times[] = runExperiment(size);
			System.out.println(size+"\t"+times[times.length/2]);			
		}
	}
	private static long[] runExperiment(int size) {
		long times[] = new long[EXPERIMENTS_BY_SIZE];
		for (int i = 0; i < times.length; i++) {

			int from = Utilities.getRandomNumber(0, 10000);
			int to = from + Utilities.getRandomNumber(0, 10000);
			int a[] = Utilities.getRandomArray(size, from, to);
			long initTime = System.currentTimeMillis();
			radixsort(a,a.length);
			times[i] = System.currentTimeMillis()-initTime;
		}
		Arrays.sort(times);
		return times;
	}
	private static void experimentalCorrectness() {
		int errorCount = 0;
		for (int exp = 0; exp < CORRECTNESS_EXP_COUNT; exp++) {
			
			int size = Utilities.getRandomNumber(1, 100);
			int from = Utilities.getRandomNumber(0, 10000);
			int to = from + Utilities.getRandomNumber(0, 10000);

			int a[] = Utilities.getRandomArray(size, from, to);
			//System.out.println(Arrays.toString(a));
			int b[] = new int[a.length];
			System.arraycopy(a, 0, b, 0, a.length);

			//System.out.println(Arrays.toString(b));
			radixsort(a, a.length);
			Arrays.sort(b);
			//System.out.println(Arrays.toString(a));

			//System.out.println(Arrays.toString(b));
			if( !Arrays.equals(a, b) )
				errorCount++;
		}
		System.out.println("Errors: "+errorCount);		
	}
	static int getMax(int arr[], int n) 
    { 
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx; 
    } 
  
    // A function to do counting sort of arr[] according to 
    // the digit represented by exp. (eg. 300 is represented by 100)
    static void countSort(int arr[], int n, int exp) 
    { 
        int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) 
            count[ (arr[i]/exp)%10 ]++; 
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
        // Build the output array 
        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
            count[ (arr[i]/exp)%10 ]--; 
        }
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++) 
            arr[i] = output[i]; 
    } 
  
    // The main function to that sorts arr[] of size n using 
    // Radix Sort 
    static void radixsort(int arr[], int n) 
    { 
        // Find the maximum number to know number of digits 
        int m = getMax(arr, n); 
        int exp;
  
        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (exp = 1; m/exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
        //w = m/(exp/10);
    } 
	public static long experimentalEspectedTime( int n)
	{
		return (long)( /*(3.81635908e-9)*n*n + (3.075871497e-7)*n - 8.771929825e-4 -*/ ((5.882352941176471e-05)*n  -0.17647058823529416));
	}
}

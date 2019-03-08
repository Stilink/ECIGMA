import java.util.Arrays;
import java.util.TreeMap;


public class Utilities {
	public static void main(String[] args) {
		TreeMap<Integer,Integer> m = new TreeMap<Integer,Integer>();
		for (int i = 0; i < 2000000; i++) {
			int r = getRandomNumber(1, 9);
			if( m.containsKey(r))
				m.put( r, m.get(r)+1 );
			else
				m.put(r , 1);
		}
		for( int x : m.keySet() )
			System.out.println(x +" -> "+m.get(x));
		for (int i = 1; i < 10; i++) {
			System.out.println(Arrays.toString(getRandomArray(i, 1, 9)));
		}
	}
	public static int getRandomNumber( int from , int to )
	{
		return from + (int)(Math.random()*(to - from + 1));
	}
	public static int[] getRandomArray( int size , int from , int to )
	{
		int a[] = new int[size];
		for (int i = 0; i < a.length; i++) 
			a[i] = getRandomNumber(from, to);
		
		return a;
	}
}

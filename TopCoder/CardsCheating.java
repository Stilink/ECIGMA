import java.util.*;

public class CardsCheating {
	private Set<String> carlos;
	/*public static void main(String[] args) {
		CardsCheating cc = new CardsCheating();
		int[] cards = {1,1,2,0,2,0,1,0,2,2,1,0};
		int[] shuffle = {5,0,9,7,1,8,3,10,4,11,6,2};
		System.out.println(cc.numberOfShuffles(cards, shuffle));

		

	}*/
	
	private boolean confirme(int[] cards) {
		int controlador = 0;
		for(int i = 0; i<cards.length; i++) {
			if(controlador>=3) controlador=0;
			if(cards[i]!=controlador) {
				return false;
			}
			controlador++;
		}
		return true;
	}
	
	public int numberOfShuffles(int[] cards, int[] shuffle) {
		carlos = new HashSet<String>();
		int[] temp = new int[cards.length];
		int ans = 0;
		while((!confirme(cards)) && (!(carlos.contains(Arrays.toString(cards))))) {
			carlos.add(Arrays.toString(cards));
			//System.out.println("Este es carlos, se como carlos: "+carlos.toString()+" Arreglo crack de la jave: "+Arrays.toString(cards)+ " Valor booleano del contains "+carlos.contains(cards.toString()));
			for(int i = 0; i < cards.length; i++) {
				temp[shuffle[i]]= cards[i];
			}
			ans++;
			//System.out.println(Arrays.toString(temp));			
			cards = temp.clone();			
			temp = new int[cards.length];
		}
		if(confirme(cards)){
			return ans;
			
		}else return -1;
		
	}

}

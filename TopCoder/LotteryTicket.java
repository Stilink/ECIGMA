import java.io.*;
import java.util.*;

public class LotteryTicket {
	/*public static void main(String[] args) {
		LotteryTicket lottery = new LotteryTicket();
		System.out.println(lottery.buy(10,
				1,
				5,
				10,
				50));
		System.out.println(lottery.buy(1000,
				999,
				998,
				997,
				996));
		
		System.out.println(lottery.buy(2,
				1,
				5,
				10,
				50));
		
		System.out.println(lottery.buy(20,
				5,
				5,
				5,
				5));
		

	}*/
	public String buy(int price, int b1, int b2, int b3, int b4) {
		ArrayList<Integer> bs = new ArrayList<Integer>();
		bs.add(b1);
		bs.add(b2);
		bs.add(b3);
		bs.add(b4);
		if(canPay(price, bs, 0)) {
			return "POSSIBLE";
		}else {
			return "IMPOSSIBLE";
		}
	}
	private Boolean canPay(int price,ArrayList<Integer> bs, int i) {
		if(i>=4) {
			return false;
		}else if(price<0) {
			return false;
		}
		if(price-bs.get(i)==0) {
			return true;
		}else if(price-bs.get(i)>0) {
			if(canPay(price-bs.get(i),bs,i+1)) return true;
			else return canPay(price, bs, i+1);
		}else {
			return canPay(price,bs,i+1);
		}
	}

}

import java.util.*;
public class _4 {
	private ArrayList<Integer> positivos = new ArrayList<Integer>();
	private ArrayList<Integer> negativos = new ArrayList<Integer>();
	private ArrayList<Integer> pares = new ArrayList<Integer>();
	private ArrayList<Integer> impares = new ArrayList<Integer>();
	private ArrayList<Integer> positivosRetirados = new ArrayList<Integer>();
	private ArrayList<Integer> negativosRetirados = new ArrayList<Integer>();
	
	
	public static void main(String[] args) {
		_4 prueba = new _4();
		/*prueba.insertOne(1);
		prueba.insertOne(2);
		prueba.insertOne(-4);
		prueba.insertOne(-1);
		prueba.removeOne();
		prueba.removeOne();
		prueba.removeOne();
		prueba.removeOne();
		prueba.print();*/
		for(int i = 0; i<1000000; i++) {
			int n = (int) (Math.random()*100)+1;
			prueba.insertOne(n);
		}
		for(int i = 0; i<1000000; i++) {
			int n = (int) (Math.random()*(-100))-1;
			prueba.insertOne(n);
		}
		//prueba.print();
		for(int i = 0; i<100000; i++) {
			prueba.removeOne();
		}
		int positivos = prueba.positivosRetirados.size();
		int negativos = prueba.negativosRetirados.size();
		int suma = positivos + negativos;
		float p = (float)(positivos)/(float)(suma);
		float n = (float)(negativos)/(float)(suma);
		System.out.println("Cantidad de positivos: "+positivos+" Cantidad de negativos: "+negativos+" Razón positivos sobre el total: "+p+" Razón negativos sobre el total: "+n);
		
	}
	
	
	
	public void insertOne(int num ) {
		if(num%2==0) {
			if(num<=0) {
				negativos.add(num);
			}else {
				positivos.add(num);
			}
			pares.add(num);
		}else {
			if(num<=0) {
				negativos.add(num);
			}else {
				positivos.add(num);
			}
			impares.add(num);
		}
		//System.out.println(positivos.toString()+" "+negativos.toString()+" "+pares.toString()+" "+impares.toString());
	}
	
	public void removeOne() {
		int n = (int) (Math.random() * 100)+1;
		if(n>66) {
			if(negativos.size()<1) return;
			int num = negativos.remove(negativos.size()-1);
			negativosRetirados.add(num);
			if(num%2==0) {
				pares.remove(pares.lastIndexOf(num));
			}else {
				impares.remove(impares.lastIndexOf(num));
			}
			
		}else {
			if(positivos.size()<1) return;
			int num = positivos.remove(positivos.size()-1);
			positivosRetirados.add(num);
			if(num%2==0) {
				pares.remove(pares.lastIndexOf(num));
			}else {
				impares.remove(impares.lastIndexOf(num));
			}
		}
		//System.out.println(positivos.toString()+" "+negativos.toString()+" "+pares.toString()+" "+impares.toString());
		
	}
	public void print() {
		ArrayList<Integer> paresTemp = (ArrayList<Integer>) this.pares.clone();
		ArrayList<Integer> imparesTemp = (ArrayList<Integer>) this.impares.clone();
		Collections.sort(paresTemp);
		Collections.sort(imparesTemp);
		System.out.println("Pares: ");
		for(int i = paresTemp.size()-1; i>=0; i--) {
			System.out.print(paresTemp.get(i)+ " ");
		}
		System.out.println();
		System.out.println("Impares: ");
		for(int i = imparesTemp.size()-1; i>=0; i--) {
			System.out.print(imparesTemp.get(i)+" ");
		}
		System.out.println();
		
	}

}

package eventualidades;

import java.util.ArrayList;
import java.util.Random;

public class FalasPensamentos {
/* 
 * pensamentos intrusivos, falas aleatorias, estorias com a personagem
 */
	Random aleatorio= new Random();
	private ArrayList<String> falasAleatoria = new ArrayList<>();
	
	public ArrayList<String>  getFalas(){
		return falasAleatoria;
		
	}
	public void adcionarFalas(String fala) {
		falasAleatoria.add(fala);
		
	}
	public void adcionarFalas(String fala1, String fala2, String fala3) {
		falasAleatoria.add(fala1);
		falasAleatoria.add(fala2);
		falasAleatoria.add(fala3);
	}
	public void falar() {
		int tamanho= falasAleatoria.size();
		System.out.println(falasAleatoria.get(aleatorio.nextInt(tamanho)));
		
		
		
	}
	
}

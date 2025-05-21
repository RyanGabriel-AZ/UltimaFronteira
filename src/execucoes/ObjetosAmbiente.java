package execucoes;

import ambientacao.Deserto;
import ambientacao.Floresta;
import ambientacao.LagoRio;
import controladores.ControladorAmbiente;

public class ObjetosAmbiente {
	private ControladorAmbiente ambient;
	
 
	
	public ControladorAmbiente getAmbiente() {
		return ambient;
	}
	
	 public ObjetosAmbiente() {
	       

	        Deserto deserto = new Deserto("Deserto", "Um ambiente com muita areia", 0.9, 0.8, "Sol", 0.9, 0.7 , 0.7, 0.8);
	        Floresta floresta = new Floresta("Floresta", "Possui muitas árvores", 0.5, 0.6, "Chuva", 0.7, 0.5, 0.6);
	        LagoRio lago = new LagoRio("Lago", "Parece que há muita lama", 0.6, 0.8, "Sol", 0.7, 0.4, 0.6);

	        ambient.adicionarAmbientes(deserto);
	        ambient.adicionarAmbientes(floresta);
	        ambient.adicionarAmbientes(lago);
	    }

	
	
}


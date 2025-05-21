package execucoes;

import ambientacao.Deserto;
import ambientacao.Floresta;
import ambientacao.LagoRio;
import controladores.ControladorAmbiente;
import personalidades.Normal;

public class JogoExecutar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Normal jogador = new Normal("Evellin",70,100,100,70,100,0);
ControladorAmbiente controleAmbiente = new ControladorAmbiente();
Deserto deserto=   new Deserto("desert", "um ambiente com muita areia", 0.9, 0.8, "sol", 0.9, 0.7 , 0.7, 0.8);
Floresta floresta= new Floresta("floresta","possui muittas árvores", 0.5, 0.6, "chuva",0.7, 0.5, 0.6);
LagoRio lago= new LagoRio("lago", "Parece que há muita lama", 0.6,0.8 , "sol",0.7, 0.4, 0.6);
controleAmbiente.adicionarAmbientes(deserto);
controleAmbiente.adicionarAmbientes(lago);
controleAmbiente.adicionarAmbientes(floresta);
controleAmbiente.controlarAmbiente(jogador);
System.out.println(jogador.getLocalizacao().getNome());


	}

}

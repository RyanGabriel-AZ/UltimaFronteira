package controladores;

import java.util.Random;

import eventualidades.EventoCriaturasDoceis;
import eventualidades.EventosComAmbientes;
import eventualidades.EventosComCraituras;
import eventualidades.Exploracao;
import eventualidades.FalasPensamentos;
import eventualidades.FinaisPersonagem;
import eventualidades.IntroducaoJogo;
import personalidades.Personagem;

public class ControladorEvento {
Random aleatorio= new Random();
EventoCriaturasDoceis manipular= new EventoCriaturasDoceis(null, null);//Criar as criaturas dóceis;
EventosComAmbientes eventosComAmbientes= new EventosComAmbientes();
EventosComCraituras eventosComCraituras= new EventosComCraituras();
Exploracao exploracao= new Exploracao();
FalasPensamentos falasPensamentos= new FalasPensamentos();
FinaisPersonagem finaisPersonagem= new FinaisPersonagem();
IntroducaoJogo introducaoJogo= new IntroducaoJogo();





//Implementaçoes iniciais e finais
	public void adicionarCriaturasDoceis(EventoCriaturasDoceis criatura) {
		manipular.adicionarCriaturasDoceis(criatura);
				
	}
	
	public void todosFinais(Personagem jogador, int numeroMaxCiclos, int numeroCiclos ) {
		finaisPersonagem.finalDosFinais(jogador, numeroMaxCiclos, numeroCiclos);
	}
	
	
	
	
	
	
	
	//Eventos aleatórios


public void criaturasDoceis(Personagem jogador) {
	manipular.aparecerCriaturasDoceis(jogador);
}






	
	
	
}

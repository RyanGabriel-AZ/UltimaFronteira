package controladores;

import java.util.Random;

import eventualidades.DesgastePersonagem;
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
SistemaCombate combate= new SistemaCombate();
DesgastePersonagem desgastado= new DesgastePersonagem("");
// Relaçoes  de falas personagens
public void introducaoJogoTexto() {
	introducaoJogo.menuStart();
	introducaoJogo.interacaoFalaUsuario();	
	introducaoJogo.comoJogoFunciona();
	introducaoJogo.interacaoFalaUsuario();
	introducaoJogo.historiaInicial();
	introducaoJogo.interacaoFalaUsuario();
}
public void falas() {
	falasPensamentos.falar();
}
	public void adcionarFalas(String fala) {
		falasPensamentos.adcionarFalas(fala);
	}

public void adicionarFalas(String fala1, String fala2, String fala3) {
	falasPensamentos.adcionarFalas(fala1, fala2, fala3);
}


//Implementaçoes iniciais e finais
	public void adicionarCriaturasDoceis(EventoCriaturasDoceis criatura) {
		
		manipular.adicionarCriaturasDoceis(criatura);
				
	}
	
	//Condiçoes de vitoria derrota
	public void todosFinais(Personagem jogador, int numeroMaxCiclos, int numeroCiclos ) {
		System.out.println("\n======Final=======");
		finaisPersonagem.finalDosFinais(jogador, numeroMaxCiclos, numeroCiclos);
	}
	public boolean derrota(Personagem jogador) {
		if(jogador.getVida()>0&& jogador.getEnergia()>0 && jogador.getSanidade()>0&& jogador.getFome()>0&& jogador.getSede()>0) {
			return false;
		}
	return true;
	}
	public boolean vitoria(int numeroMaxCiclos, int numeroCiclos) {
		if(numeroCiclos<numeroMaxCiclos) {
			return false;
		}
	return true;	
	}
	
	
	public int eventosAleatoriosJogo(Personagem jogador, ControladorCriaturas controlador, Inventario inventario) {
		
		if(aleatorio.nextInt(100)<85) {
			falas();
			System.out.println("\n=======Letal Kombat======\ndireitos autorais, né?");
			combate.combate( jogador, controlador, inventario);	
			return 0;
		}
		else if(aleatorio.nextInt(100)<95) {
			System.out.println("\n======Criaturas Dóceis=======\nElas são tão fofinhas!");
			manipular.aparecerCriaturasDoceis(jogador);
			return 0;
		}
		falas();
		return 0;
	}
	
	
	/// botar no final do loop
	public void aplicarEfeitorPorTurno(Personagem jogador) {
		desgastado.StatsPersonagemSemDesgaste(jogador);
		desgastado.aplicarStatusTurno(jogador);
		desgastado.StatsPersonagemSemDesgaste(jogador);
		
		
	}
	//Eventos aleatórios


public void criaturasDoceis(Personagem jogador) {
	manipular.aparecerCriaturasDoceis(jogador);
}

public void podeExplorar(Inventario inventario) {
	
	exploracao.explorar(inventario);
	
}




	
	
	
}

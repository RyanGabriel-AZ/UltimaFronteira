package eventualidades;

import personalidades.Personagem;

public class FinaisPersonagem {
/*
 * diferentes finais, para diferentes situações
 */
	public void finalVida(Personagem jogador) {
		if(jogador.getVida()<=0) {
			System.out.println("Você morreu!\n Gatos tem 7 vidas.\n parece que você não era tão gata, quanto pensava. :(");
		}
	}
	public void finalEnergia(Personagem jogador) {
		if(jogador.getEnergia()<=0) {
			System.out.println("Você desmaiou!\n A vida de pebleu não é para qualquer um\n BABY (-_-) zzz");
		}
		
	}
	public void finalFome(Personagem jogador) {
		if(jogador.getFome()<=0) {
			System.out.println("Você desmaiou!\nSaco vazio não para em pé!");
		}
	}
	public void finalSanidade(Personagem jogador) {
		if(jogador.getSanidade()<=0) {
			System.out.println("Você enlouqueceu!\\n A vida de pebleu não é para qualquer um\\n BABY ('_') ");
		}
	}
	public void finalSede(Personagem jogador) {
		if(jogador.getSede()<=0) {
			System.out.println("você morreu de sede, literamente. (Õ.Õ)");
			
		}
	}
	public void finalDosFinais(Personagem jogador) {
		finalEnergia(jogador);
		finalFome(jogador);
		finalSanidade(jogador);
		finalSanidade(jogador);
		finalVida(jogador);
			}
}

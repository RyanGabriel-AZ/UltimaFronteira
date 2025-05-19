package criaturas;

import java.util.Random;

import ambientacao.Ambiente;
import personalidades.Personagem;

public class CriaturasDoceis extends Criatura {

	public CriaturasDoceis(String nome, float vida, int individuosPorGrupo, String descricao, Ambiente habitat) {
		super(nome, vida, individuosPorGrupo, descricao, habitat);
		// TODO Auto-generated constructor stub
	}
	Random roleta= new Random();
	

 /*
  * ela não vai atacar, não sei como implementar no sistema de ataque
  */

	@Override
	public void interagir(Personagem jogador) {
		
		System.out.println("Parece que você achou " +getNome()+ "\n"+ "Ele quer te dar amor e alegria");
		getHabitat().espoliosAmbiente();
		jogador.setVida(roleta.nextInt(50) );
		jogador.setSanidade(roleta.nextInt(50) );
		
		
	}
	
	/*
	
	 * elas fazem parte de um evento.
	 * As criaturas dóceis podem "dar" itens, dar vida sanidade.
	 * 
	 * public 
	 */
}
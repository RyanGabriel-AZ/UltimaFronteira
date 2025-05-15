package eventualidades;

import java.util.ArrayList;


import personalidades.Personagem;

public class DesgastePersonagem {
/*
 * Aqui vamos colocar o sistema de desgaste: perda de vida, energia, sanidade, etc.
 * tambem deve ser feito a tabela turno por  aqui 
 */
	ArrayList<Personagem> status = new ArrayList<>();
Personagem antes= new Personagem(0,0,0,0,0);
Personagem depois= new Personagem(0,0,0,0,0);
/*
 * É o seguinte. vamos colocar os dados iniciais em antes, igualando objetos. e quando acabar o turno em depois. 
 * vamos fazer 4 funçoes principais. uma para atualizar os objetos. uma para pegar valores dos objetos. uma para mostrar a diferença, e
 * e uma que mpstre o antes e depois.
 * OBS: o Antes inicial é igual ao do jogador. ele atualiza depois para o depois. o depois sempre vai ser igual ao do jogador.
 * essas ações são execultadas no fim do turno.
 * 
 * ex: no inicio do turno tinha 10 de vida. no final tinha 15. a mudança foi de 5 de vida.
 * estamos usando array, porque é mais facil guardar dados com ele.
 */

	public void estadosAntes(Personagem jogador) {
		
	}
}

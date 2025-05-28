package controladores;

import java.util.ArrayList;
import java.util.Scanner;

import eventualidades.DesgastePersonagem;
import personalidades.Personagem;

public class ControlePersonagem {
	Inventario inventario = new Inventario();
	DesgastePersonagem desgastePersonagem = new DesgastePersonagem();
	Scanner ler= new Scanner(System.in);
	private ArrayList<Personagem> personagens= new ArrayList<>();
	
	public ArrayList<Personagem>   getPersonagemLista(){
		return personagens;
	}
	public void adcionarClassesPersonagem(Personagem classe) {
		personagens.add(classe);
	}
	public Personagem carregarClasseJogo(String classe) {
		for (Personagem personagem : personagens) {
			if (personagem.getClasse().equalsIgnoreCase(classe)) {
				personagem.statsPersonagem();
				
				return personagem;
			}
			
		}return null;
	}
	public Personagem entradaClasse() {
	Personagem jogador= null;
		do {
		String	classe= ler.nextLine();
		
		jogador = carregarClasseJogo(classe);
		
		
		}while(jogador==null);
		return jogador;
		
		
	}
	//Uma das classes principais do jogo. Aqui definimos nosso personagem do jogo.
	public Personagem escolherclasse() {
		Personagem funcao;
		System.out.println("Quando eu era criança, o que eu sonhava em ser? ");
		for (Personagem personagem : personagens) {
			personagem.descricaoClasse();
		}
		System.out.println("Digite o nome da classe em que eu sonhava ser: ");
		
		funcao= entradaClasse(); // será a classe do nosso personagem.
		return funcao;
		
		
		
	}
	
	
}

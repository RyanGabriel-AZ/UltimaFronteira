package controladores;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import criaturas.Criatura;
import criaturas.CriaturasHostis;
import eventualidades.DesgastePersonagem;
import itens.Arma;
import itens.Item;
import personalidades.Personagem;



public class SistemaCombate {
	Random aleatorio = new Random();
	Scanner leitor = new Scanner(System.in);
	Arma arma;
	DesgastePersonagem desgaste = new DesgastePersonagem(" Desgaste Personagem");
Arma galho= new Arma("galho", 1, 100, 1, 10, 10, 0.1, "Raro", "Arma");
	private ArrayList<Arma> armaAtual = new ArrayList<>();

	public void adcionarArmaLuta(Arma arma) {
		armaAtual.add(arma);
	}

	public void limparArmas(ArrayList<Arma> armaAtual) {
		armaAtual.clear();
	}

	public ArrayList<Arma> getArmas() {
		return armaAtual;
	}

	public Arma suaArmaAtual() {
		Arma novaArma = null;
		for (Arma arma : armaAtual) {
			novaArma = arma;
		}
		return novaArma;
	}

	public void novaArma(Arma arma) {
		limparArmas(armaAtual);
		adcionarArmaLuta(arma);

	}

	public Arma selecionaArma(Inventario bolsa, String tipoAlcance) {
		for (Item item : bolsa.acessarInventario()) {
			if ( item.getTipo().equalsIgnoreCase(tipoAlcance)) {
				if(item instanceof Arma ) {
				Arma arma = (Arma) item;
				return arma; //
				}
			}
		}
System.out.println("Você colocou um alcance inexistente");
		return null;
	}

	public Arma escolherArma(Inventario bolsa) {
		Arma arma;
		if(bolsa.verificarSeHaArmasFerramentas("Arma")) {
		do {
			System.out.println(
					"\nParece que você entrou em um combate! \nDigite o tipo de arma, sendo: 'Curto', 'Medio', 'Longo', isso vai definir sua arma atual: ");
			String tipoAlcance = leitor.nextLine();
			arma = selecionaArma(bolsa, tipoAlcance);
			

		} while (arma == null);
		return arma;}
		System.out.println(" Parece que você está sem armas\n Você deve criar uma arma logo!, vou pegar esse galho para você");
		return galho;
	}

	// pode acessar inventario e usar itens, ou fugir, ou lutar;
	public void fugir(Personagem jogador, Criatura criatura) {
		if (aleatorio.nextDouble(1) < jogador.getFugirChance()) {
			System.out.println("\nParabéns você conseguiu fugir! A batalha acabou!");
			criatura.setPodeLutar(false);
		} else {
			System.out.println("\nVocê não conseguiu fugir! A batalha continua! ");
		}

	}

	public void opcaoNaLuta(Inventario bolsa, Personagem jogador, Criatura criatura) {
		//
		int fechar = 0;

		do {
			
			
			
			
			System.out.println(
					"\nVocê tem 3 opcoes, mas pode escolher apenas 1:\n digite [I], para acessar o inventario e usar itens \n Digite [F] para tentar fugir \n digite [L] para lutar com a criatura\n[M] para mudar de arma e atacar ");
			String letra = leitor.nextLine();
			if (letra.equalsIgnoreCase("I")) {
				bolsa.inventarioFuncional(jogador);
				fechar = 1;
			} else if (letra.equalsIgnoreCase("F")) {
				fugir(jogador, criatura);
				fechar = 1;

			} else if (letra.equalsIgnoreCase("M")) {
				novaArma(escolherArma(bolsa));

				jogador.ataque(suaArmaAtual(), criatura);
				fechar = 1;
			} else if (letra.equalsIgnoreCase("L")) {
				jogador.ataque(suaArmaAtual(), criatura);
				fechar = 1;
			} else {
				fechar = 0;
			}

		} while (fechar == 0);

	}

	public void combate(Personagem jogador, ControladorCriaturas criatura, Inventario inventario) {

		DesgastePersonagem antes= new DesgastePersonagem("Antes");
		DesgastePersonagem atual= new DesgastePersonagem("Atual");
		DesgastePersonagem resultado= new DesgastePersonagem("resultado");

		criatura.adicionarCriaturasDoAmbiente(jogador.getLocalizacao());
		CriaturasHostis criaturaAtual = criatura.sortearCriatura();
		// Turno de lutas

		novaArma(escolherArma(inventario));
		while (criaturaAtual.getVida() > 0 && criaturaAtual.criaturaContinuarLuta()) {
			desgaste.adicionarEstados(antes, atual, resultado);
			desgaste.atualizarEstadoAntesDepois(jogador, antes);
			desgaste.resultadosAntesDepois(antes);
			criaturaAtual.aparecerCriatura();
			opcaoNaLuta(inventario, jogador, criaturaAtual);
			criaturaAtual.interagir(jogador);
			desgaste.atualizarEstadoAntesDepois(jogador, atual);
			desgaste.resultadosAntesDepois(antes);
			desgaste.resultadosAntesDepois(atual);
			
			desgaste.limparEstados();

		}
      System.out.println("\n Você venceu a batalha contra " + criaturaAtual.getNome());
	}

}

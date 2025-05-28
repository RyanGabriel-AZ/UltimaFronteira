package criaturas;

import ambientacao.Ambiente;
import personalidades.Personagem;

public class CriaturasHostis extends Criatura {
	private int forca;
	private String efeitoSecundario; // Veneno, Sangramento, Hemorragia
	private double probabilidadeDeEfeito; // de 0 a 1
	private String estado;

	public CriaturasHostis(String nome, double vida, int individuosPorGrupo, String descricao, Ambiente habitat, int forca,
			String efeitoSecundário, double probabilidadeDeEfeito, String estado) {
		super(nome, vida, individuosPorGrupo, descricao, habitat);
		this.forca = forca;
		this.efeitoSecundario = efeitoSecundário;
		this.probabilidadeDeEfeito = probabilidadeDeEfeito;
		this.estado = estado;
		setPodeLutar(true);
	}
	public boolean criaturaContinuarLuta() {
		if(getVida()>0 && getPodeLutar()==true) {
			return true;
		}
		else {
			return false;
		}
		
	}

	public double getProbabilidadeDeEfeito() {
		return probabilidadeDeEfeito;
	}

	public String getEstado() {
		return estado;
	}

	public void setForca(int forca) {
		this.forca = forca;

	}

	public int getForca() {
		return forca;
	}

	public String getEfeitoSecundario() {
		return efeitoSecundario.toLowerCase();
	}

//aplicar a probabilidade posteriormente
	public void EfeitosSecundarios(Personagem jogador) {
		switch (getEfeitoSecundario()) {
		case "Sangramento":
			System.out.println("Você está sangrando!");
			jogador.setVida(-10);
			break;
		case "Hemorragia":
			System.out.println("Você está tendo um hemorragia!");
			jogador.setVida(-20);
			jogador.setEnergia(-20);
			jogador.setSanidade(-20);
			jogador.setForca(-10);
			break;
		case "Veneno":
			System.out.println("Você está envenenado!");
			jogador.setVida(-10);
			jogador.setSanidade(-30);
			break;
		case "":
			break;

		}
	}

	public void aplicarEfeitosSecundarios(Personagem jogador) {
		double chance = getProbabilidadeDeEfeito();
		if (Math.random() < chance && jogador.getProtecaoEfeitosSecundarios()==0) {
			EfeitosSecundarios(jogador);
		}

	}

	public double ataque(Personagem jogador) {
		double ataque;
		double dano;
		ataque = getForca() * estadoCriatura()*(1+ 0.75*getIndividuosPorGrupo());
		dano =  - ataque;
		jogador.setVida(dano);
		return ataque;

	}

// faz parte do multiplicador de dano
	public double estadoCriatura() {
		double valorTeste;
		if (estado.equalsIgnoreCase("Letal")) {
			valorTeste = 1.25;
		} else if (estado.equalsIgnoreCase("Normal")) {
			valorTeste = 1;

		} else if (estado.equalsIgnoreCase("Fraco")) {
			valorTeste = 0.75;
		} else if (estado.equalsIgnoreCase("Muito fraco")) {
			valorTeste = 0.5;
		} else {
			valorTeste = 0;
		}
		return valorTeste;
	}
public void statusCriatura() {
	
	System.out.println("Vida :"+ (int)getVida());
	
}
	/* Melhorar classes abaixo */
	@Override
	public void interagir(Personagem jogador) {

		System.out.println(getNome() + " vai atacar!");
		statusCriatura();
		ataque(jogador);
		aplicarEfeitosSecundarios(jogador);
		statusCriatura();
	}

}


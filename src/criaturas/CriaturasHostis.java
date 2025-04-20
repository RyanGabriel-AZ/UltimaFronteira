package criaturas;

import personalidades.Personagem;

public class CriaturasHostis extends Criatura {
	private int forca;
	private String efeitoSecundario;
	private double probabilidadeDeEfeito;
	private String estado;

	public CriaturasHostis(String nome, float vida, int individuosPorGrupo, String descricao, String habitat, int forca,
			String efeitoSecundário, double probabilidadeDeEfeito, String estado) {
		super(nome, vida, individuosPorGrupo, descricao, habitat);
		this.forca = forca;
		this.efeitoSecundario = efeitoSecundário;
		this.probabilidadeDeEfeito = probabilidadeDeEfeito;
		this.estado = estado;
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
		case "sangramento":
			System.out.println("Você está sangrando!");
			jogador.setVida(-5);
			break;
		case "hemorragia":
			System.out.println("Você está tendo um hemorragia!");
			jogador.setVida(-10);
			jogador.setEnergia(-20);
			jogador.setSanidade(-20);
			jogador.setForca(-10);
			jogador.setPrecisao(-10);
			break;
		case "veneno":
			System.out.println("Você está envenenado!");
			jogador.setVida(-10);
			jogador.setSanidade(-30);
			break;

		}
	}

	public void aplicarEfeitosSecundarios(Personagem jogador) {
		double chance = getProbabilidadeDeEfeito();
		if (Math.random() < chance) {
			EfeitosSecundarios(jogador);
		}

	}

	public double ataque(Personagem jogador) {
		double ataque;
		double dano;
		ataque = getForca() * estadoCriatura();
		dano = jogador.getVida() - ataque;
		jogador.setVida(dano);
		return ataque;

	}

// faz parte do multiplicador de dano
	public double estadoCriatura() {
		double valorTeste;
		if (estado.equalsIgnoreCase("letal")) {
			valorTeste = 1.25;
		} else if (estado.equalsIgnoreCase("normal")) {
			valorTeste = 1;

		} else if (estado.equalsIgnoreCase("fraco")) {
			valorTeste = 0.75;
		} else if (estado.equalsIgnoreCase("muito fraco")) {
			valorTeste = 0.5;
		} else {
			valorTeste = 0;
		}
		return valorTeste;
	}

	/* Melhorar classes abaixo */
	public void interagir(Personagem jogador) {

		System.out.println(getNome() + " vai atacar!");
		ataque(jogador);
		aplicarEfeitosSecundarios(jogador);
	}

	@Override
	public void interagir() {
System.out.println("A vida é como um limão, bem azeda!");
	}

}

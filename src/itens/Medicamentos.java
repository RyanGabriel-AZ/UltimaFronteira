package itens;

import personalidades.Personagem;

/*
 * meu usar aqui vai ser o seguinte, o analgesico vai recuperar vida e sanidade
 * o  vai proteger contra efeitos secundários por 2 turnos o milagroso vai ter o efeito dos
 * dois juntos
 * 
 * 
 */

public class Medicamentos extends Item {
	private String efeito;
	private double potencia;

	public Medicamentos(String nome, double peso, double durabilidade, String efeito, double potencia , int quantidade, String tipo, String classe ) {
		super(nome, peso, durabilidade, quantidade, tipo, classe);
		this.setEfeito(efeito);
		this.setPotencia(potencia);
		// TODO Auto-generated constructor stub
	}

	public String getEfeito() {
		return efeito;

	}

	public void setEfeito(String efeito) {
		this.efeito = efeito;
	}

	public void aplicandoEfeitos(Personagem jogador) {

		switch (getEfeito()) {
		case "analgesico": {
			double vida = 100 * getPotencia();
			double sanidade = 50 * getPotencia();
			jogador.setSanidade(sanidade);
			jogador.setVida(vida);
		}
			break;
		case "curaTudo": {
jogador.setProtecaoEfeitosSecundarios(2);
		}
		break;
		case "milagroso": {
			double vida = 125 * getPotencia();
			double sanidade = 75 * getPotencia();
			jogador.setSanidade(sanidade);
			jogador.setVida(vida);
			jogador.setProtecaoEfeitosSecundarios(3);
		}
		}
	}

	@Override
	public void usar(Personagem jogador) {
		aplicandoEfeitos(jogador);
		setQuantidade(-1);
		System.out.println("Mato!  Eca!");

	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}
@Override
public String getEspecifico() {
	return getEfeito();
}
}

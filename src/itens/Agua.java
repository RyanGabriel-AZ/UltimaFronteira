package itens;

import personalidades.*;

public class Agua extends Item {
	

	private double pureza;//0 a 1
	private double volume;//0 a 100

	public Agua(String nome, double peso, double durabilidade, double pureza,  double volume, int quantidade, String tipo , String classe) {
		super(nome, peso, durabilidade, quantidade, tipo, classe);
		this.pureza= pureza;
		this.volume= volume;
	
	}
	public void matarSede(Personagem jogador) {
		double vida = ((getPureza() - 0.7) * jogador.getVida());
		jogador.setVida(vida);
		double sede = (getPureza()*getVolume() + 0.5*getVolume());
		jogador.setSede(sede);
		setQuantidade(-1);
	}

	public double getPureza() {
		return pureza;
	}

	public void setPureza(double pureza) {
		this.pureza = pureza;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	@Override
	public void usar(Personagem jogador) {
		matarSede(jogador);
		System.out.println("Que água molhada. :) ");
		
	}
@Override
public String getEspecifico() {
	return "Pureza "+String.valueOf(getPureza());
}
	/*
	 * pureza vai de 0 a 1, quanto maior a pureza ,mais sede e vida recupera abaixo
	 * de 0.7 retira vida, matar sede ((pureza-0.7)*getVida(jogador)) esse valor vai
	 * ser aplicado na vida do personagem depois, seja somando ou retirando.
	 */

}

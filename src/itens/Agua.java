package itens;
import personalidades.*;
public class Agua extends Item {
private double pureza;
private double volume;



public void matarSede(Personagem jogador) {
	double vida= ((getPureza()-0.7)*jogador.getVida());
	jogador.setVida(vida);
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

/*
 * pureza vai de 0 a 1, quanto maior a pureza ,mais sede e vida recupera
 * abaixo de 0.7 retira vida, matar sede ((pureza-0.7)*getVida(jogador))
 * esse valor vai ser aplicado na vida do personagem depois, seja somando ou retirando.
 */

}

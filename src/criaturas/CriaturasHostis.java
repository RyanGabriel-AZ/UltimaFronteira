package criaturas;

public class CriaturasHostis {
private int forca;
private String efeitoSecundario;
private double probabilidadeDeEfeito;
private String estado;

public doble getEstado() {
	return estado;
}

public void setForca(int forca) {
	this.forca= forca;
	
}
public int getForca() {
	return forca;
}
public double ataque(Personagem jogador) {
	double ataque;
	double dano;
	ataque= getForca()*getEstado;
	dano= jogador.getVida()-ataque;
    jogador.setVida(dano);
    return ataque;
	
}
}

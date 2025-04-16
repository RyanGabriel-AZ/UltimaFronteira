package criaturas;

public class CriaturasHostis {
private int forca;
private String efeitoSecundario;
private double probabilidadeDeEfeito;
private String estado;

public CriaturasHostis(String nome, float vida, int individuosPorGrupo, String descricao, String habitat,
		int forca, String efeitoSecundário, double probabilidadeDeEfeito, String estado) {
	super();
	this.forca= forca;
	this.efeitoSecundario= efeitoSecundário;
	this.probabilidadeDeEfeito= probabilidadeDeEfeito;
	this.estado= estado;
}

public String getEstado() {
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
	ataque= getForca()*estadoCriatura();
	dano= jogador.getVida()-ataque;
    jogador.setVida(dano);
    return ataque;
	
}
public  double estadoCriatura() {
	double valorTeste;
	if (estado.equalsIgnoreCase("letal")) {
		valorTeste= 1.25;
	}
	else if (estado.equalsIgnoreCase("normal")) {
		valorTeste= 1;
	
	}
	else if (estado.equalsIgnoreCase("fraco")) {
		valorTeste= 0.75;
	}
	else if(estado.equalsIgnoreCase("muito fraco")) {
		valorTeste= 0.5;
	}
	else {
		valorTeste=0;
	}
	return valorTeste;
}
}

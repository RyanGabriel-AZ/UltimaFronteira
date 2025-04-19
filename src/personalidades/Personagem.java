package personalidades;
import ambientacao.*;

public abstract class Personagem {

	private String nome;
	private double vida;
	private double energia;
	private double fome;
	private double sede;
	private Ambiente localizacao;
	private double sanidade;
	private int inventario;
	
	
	public void setLocalização(Ambiente localizacao) {
		this.localizacao= localizacao;
	}


	public double getVida() {
		return vida;
	}


	public void setVida(double vida) {
		
		this.vida = vida + getVida();
	}

	
}

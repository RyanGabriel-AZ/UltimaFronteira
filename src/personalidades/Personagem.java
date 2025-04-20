package personalidades;
import ambientacao.*;
import controladores.*;
public abstract class Personagem {

	private String nome;
	private double vida;
	private double energia;
	private double fome;
	private double sede;
	private Ambiente localizacao;
	private double sanidade;
	private Inventario armazenamento;
	private double forca;
	private double precisao;
	
	
	public void setLocalização(Ambiente localizacao) {
		this.localizacao= localizacao;
	}


	public double getVida() {
		return vida;
	}


	public void setVida(double vida) {
		
		this.vida = vida + getVida();
	}


	public double getEnergia() {
		return energia;
	}


	public void setEnergia(double energia) {
		this.energia = energia+ getEnergia();
	}


	public double getFome() {
		return fome;
	}


	public void setFome(double fome) {
		this.fome = fome + getFome();
	}


	public double getSede() {
		return sede;
	}


	public void setSede(double sede) {
		this.sede = sede +getSede();
	}


	public double getSanidade() {
		return sanidade;
	}


	public void setSanidade(double sanidade) {
		this.sanidade = sanidade +getSanidade();
	}


	public double getForca() {
		return forca;
	}


	public void setForca(double forca) {
		this.forca = forca + getForca();
	}


	public double getPrecisao() {
		return precisao;
	}


	public void setPrecisao(double preecisao) {
		this.precisao = preecisao + getPrecisao();
	}

	
}

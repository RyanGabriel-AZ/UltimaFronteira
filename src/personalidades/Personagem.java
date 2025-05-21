package personalidades;
import ambientacao.Ambiente;
import controladores.Inventario;
import criaturas.Criatura;
import itens.Arma;
public class Personagem {

	/*
	 * Fazer um contador de turnos para protecao, ela só pode ir ate 0, não pode ser mais que isso
	 */
	private String nome;
	private double vida;
	private double energia;
	private double fome;
	private double sede;
	private Ambiente localizacao;
	private double sanidade;
	private Inventario armazenamento;
	private double forca;
	private int protecaoEfeitosSecundarios;
	private double resistenciaAoAmbiente; // vai de 0 a 1, quanto menor, mais resistente
//esse construtor é só para os atributos que estou precisando em DesgastePersonagem
	public Personagem(String nome, double vida, double energia, double fome, double sede, double sanidade, int protecaoEfeitosSecundarios) {
		this.energia=energia;
		this.fome=fome;
		this.sanidade=sanidade;;
		this.vida=vida;
		this.sede=sede;
		this.setNome(nome);
		this.protecaoEfeitosSecundarios=protecaoEfeitosSecundarios;
	}
	public void diminuirProtecao() {
		if(getProtecaoEfeitosSecundarios()>0) {
			setProtecaoEfeitosSecundarios(-1);
		}
	}
	
	public void setLocalização(Ambiente localizacao) {
		this.localizacao=localizacao;
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



	public int getProtecaoEfeitosSecundarios() {
		return protecaoEfeitosSecundarios;
	}


	public void setProtecaoEfeitosSecundarios(int protecaoEfeitosSecundarios) {
		this.protecaoEfeitosSecundarios = protecaoEfeitosSecundarios + getProtecaoEfeitosSecundarios();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Ambiente getLocalizacao() {
		return localizacao;
	}
	public double getResistenciaAoAmbiente() {
		return resistenciaAoAmbiente;
	}
	public void setResistenciaAoAmbiente(int resistenciaAoAmbiente) {
		this.resistenciaAoAmbiente = resistenciaAoAmbiente;
	}
	
public void ataque(Arma arma, Criatura monstros) {
	double dano= arma.getPoder()*getForca();
    if(Math.random()<arma.getPrecisao()) {
    	monstros.setVida(dano);
    	arma.setDurabilidade(-10);
    }
}
	
}

package itens;

import personalidades.Personagem;

public abstract class Item {
	private String nome;
	private double peso;
	private double durabilidade;
	private int quantidade;
	private String tipo;
	private String classe;

	public abstract void usar(Personagem jogador);

	public Item(String nome, double peso, double durabilidade , int quantidade, String tipo, String classe ) {
		this.nome = nome;
		this.durabilidade = durabilidade;
		this.peso = peso;
		this.tipo= tipo;
		this.quantidade= quantidade;
		this.classe=classe;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso*getQuantidade();
	}

	public double getDurabilidade() {
		return durabilidade;
	}

	public void setDurabilidade(double durabilidade) {
		this.durabilidade = durabilidade + getDurabilidade();
		if(getDurabilidade()<= 0) {
			this.durabilidade=0;
		}
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade + getQuantidade();
		if(getQuantidade()<0) {
			this.quantidade=0;
		}
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
//para o inventario
	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
// para o inventario
	public String getEspecifico() {
		return "";
	}

}

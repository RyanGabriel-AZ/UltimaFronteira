package itens;

import personalidades.Personagem;

public abstract class Item {
	private String nome;
	private double peso;
	private double durabilidade;
	private int quantidade;
	private String tipo;
	

	public abstract void usar(Personagem jogador);

	public Item(String nome, double peso, double durabilidade , int quantidade, String tipo ) {
		this.nome = nome;
		this.durabilidade = durabilidade;
		this.peso = peso;
		this.quantidade= quantidade;
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
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade + getQuantidade();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	

}

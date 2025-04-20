package itens;

public abstract class Item {
private String nome;
private double peso;
private double durabilidade;
private String tipo;


public  abstract void usar();

public Item(String nome, double peso, double durabilidade) {
	this.nome= nome;
	this.durabilidade= durabilidade;
	this.peso= peso;
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
	this.peso = peso;
}

public double getDurabilidade() {
	return durabilidade;
}

public void setDurabilidade(double durabilidade) {
	this.durabilidade = durabilidade;
}
	
}

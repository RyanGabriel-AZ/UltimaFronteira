package itens;

import personalidades.Personagem;

public class Alimentos extends Item {
	

private double valorNutricional;
private double prazoValidade;
// prazo de validade, vais ser entre 0 e 1, de quanto falta para chegar na validade
// valor nutricional vai ser entre 0 e 100
public Alimentos(String nome, double peso, double durabilidade, double valorNutricional, double prazoValidade , int quantidade, String tipo ) {
	super(nome, peso, durabilidade, quantidade, tipo);
	this.setPrazoValidade(prazoValidade);
	this.setValorNutricional(valorNutricional);
	// TODO Auto-generated constructor stub
}
//nosso usar, vai ser o consumir. Restaura fome e energia


public double getValorNutricional() {
	return valorNutricional;
}

public void setValorNutricional(double valorNutricional) {
	this.valorNutricional = valorNutricional;
}

public double getPrazoValidade() {
	return prazoValidade;
}

public void setPrazoValidade(double prazoValidade) {
	this.prazoValidade = prazoValidade;
}
public void matarFome(Personagem jogador) {
	double vida= (getValorNutricional()*(getPrazoValidade()-7));
jogador.setVida(vida);
	double energia = (getValorNutricional()*0.7);
	jogador.setEnergia(energia);
	double fome= (getValorNutricional()*0.7 + (getPrazoValidade()-0.7)*getValorNutricional());
	jogador.setFome(fome);
	setQuantidade(-1);
}
@Override
public void usar(Personagem jogador) {
	matarFome(jogador);
	System.out.println("Nossa, então é isso que a peble come. O-O ");
	
}

}

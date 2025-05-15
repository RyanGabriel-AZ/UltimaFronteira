package itens;

public class CriacaoDeItens {

	public Ferramenta criarFerramenta(String nome, Material a, Material b, String tipo) {
		double resistencia= a.getResistencia() + b.getResistencia();
		double durabilidade= resistencia*2;
		double eficiencia= durabilidade/100;
		int quantidade= 1;
		double peso = (a.getPeso() + b.getPeso()) * 0.75;
		return new Ferramenta(nome, peso, durabilidade, quantidade, resistencia, eficiencia, tipo);
	}
	public Arma  criarArma(String nome, Material a, Material b, String tipo, double precisao) {
		double resistencia= a.getResistencia() + b.getResistencia();
		double durabilidade= resistencia*2;
		double poder= durabilidade/10;
		int quantidade= 1;
		double peso = (a.getPeso() + b.getPeso()) * 0.75;
		return new Arma(nome, peso, durabilidade, quantidade, resistencia, poder, precisao,  tipo);}
	
}

package itens;

public class Arma extends Material {
	private double poder;
	private double precisao;
	/*
	 * Vamos ter 3 tipos de arma, curto, medio, longo ,alcance. a classe do personagem pode se sair melhor com o tipo especifico
	 */
	public Arma(String nome, double peso, double durabilidade,
			int quantidade, double resistencia, double poder, double precisao, String tipo, String classe) {
		super(nome, peso, durabilidade, quantidade, resistencia, tipo, classe);
		this.poder= peso;
		this.precisao= precisao;
		
		// TODO Auto-generated constructor stub
	}
	
	public double getPoder() {
		return poder;
	}
	public void setPoder(double poder) {
		this.poder = poder;
	}
	public double getPrecisao() {
		return precisao;
	}
	public void setPrecisao(double precisao) {
		this.precisao = precisao;
	}
	
	@Override
	public String getEspecifico() {
		return String.valueOf(getPoder());
	}
}

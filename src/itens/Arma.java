package itens;

public class Arma extends Material {
	private double poder;
	private double precisao;
	
	public Arma(String nome, double peso, double durabilidade,
			int quantidade, double resistencia, double poder, double precisao, String tipo) {
		super(nome, peso, durabilidade, quantidade, resistencia, tipo);
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
	
	
}
